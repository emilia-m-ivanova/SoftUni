import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Homework {
    private Connection connection;
    private static Scanner scanner = new Scanner(System.in);

    private Homework() {
    }

    public static Homework startConnection() throws SQLException {
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();

        Homework homework = new Homework();
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        String URL = "jdbc:mysql://localhost:3306/minions_db";
        homework.connection = DriverManager.getConnection(URL, props);
        return homework;
    }

    //ex2
    public void getVillainsNames() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT name, COUNT(minion_id) AS minion_count\n" +
                "FROM villains, minions_villains\n" +
                "WHERE villain_id = villains.id\n" +
                "GROUP BY villain_id\n" +
                "HAVING minion_count > 15\n" +
                "ORDER BY minion_count DESC;");
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }

    }

    //ex 3
    public void getMinionNames() throws SQLException {
        System.out.println("Enter villain id: ");
        int id = Integer.parseInt(scanner.nextLine());
        PreparedStatement stmt = connection.prepareStatement("SELECT v.name, m.name, m.age\n" +
                "FROM villains v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "JOIN minions m on m.id = mv.minion_id\n" +
                "WHERE v.id = ?;");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.%n", id);
            return;
        }
        System.out.println("Villain: " + resultSet.getString(1));
        int n = 1;
        System.out.printf("%d. %s %d%n", n++, resultSet.getString(2),
                resultSet.getInt(3));
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n", n++, resultSet.getString(2),
                    resultSet.getInt(3));
        }
    }

    //ex 4
    public void addMinion() throws SQLException {
        System.out.println("Minion: ");
        String[] minionInfo = scanner.nextLine().split("\\s+");
        System.out.println("Villain: ");
        String villainName = scanner.nextLine();
        ResultSet resultSetTown = searchByCriteria("id", "towns", "name", minionInfo[2]);
        ResultSet resultSetVillain = searchByCriteria("id", "villains", "name", villainName);
        if (!resultSetTown.next()) {
            resultSetTown = insertIntoTable(String.format("INSERT INTO towns(name) VALUES ('%s');", minionInfo[2]),
                    minionInfo[2], "towns");
            System.out.printf("Town %s was added to the database.%n", minionInfo[2]);
        }
        if (!resultSetVillain.next()) {
            resultSetVillain = insertIntoTable(String.format("INSERT INTO villains(name,evilness_factor) VALUES ('%s', 'evil');", villainName),
                    villainName, "villains");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
        ResultSet resultSetMinion = insertIntoTable(String.format("INSERT INTO minions(name,age,town_id) VALUES ('%s', %s, %s);",
                minionInfo[0], minionInfo[1], resultSetTown.getString("id")), minionInfo[0], "minions");
        PreparedStatement insertStmt = connection.prepareStatement(String.format("INSERT INTO minions_villains VALUES (%d, %d);",
                resultSetMinion.getInt("id"), resultSetVillain.getInt("id")));
        insertStmt.execute();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionInfo[0], villainName);
    }

    //ex 5
    public void changeTownNamesCasing() throws SQLException {
        System.out.println("Enter country name: ");
        String country = scanner.nextLine();
        PreparedStatement stmt = connection.prepareStatement("UPDATE towns " +
                "SET name = UPPER(name)" +
                "WHERE country = ?");
        stmt.setString(1, country);
        int num = stmt.executeUpdate();
        System.out.println(num > 0 ? num + " town names were affected." : "No town names were affected.");
        ResultSet resultSet = searchByCriteria("name", "towns", "country", country);
        List<String> towns = new ArrayList<>();
        while (resultSet.next()) {
            towns.add(resultSet.getString(1));
        }
        System.out.println(towns.isEmpty() ? "" : "[" + String.join(", ", towns) + "]");
    }

    //ex 7
    public void printAllMinionNames() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT name\n" +
                "FROM minions;");
        ResultSet resultSet = stmt.executeQuery();
        List<String> minionNames = new ArrayList<>();
        while (resultSet.next()) {
            minionNames.add(resultSet.getString(1));
        }
        for (int i = 0; i < minionNames.size() / 2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(minionNames.size() - 1 - i));
        }
    }

    //ex 8
    public void increaseMinionsAge() throws SQLException {
        System.out.println("Please enter minion IDs seperated by space:");
        String[] ids = scanner.nextLine().split("\\s+");
        PreparedStatement updateStmt = connection.prepareStatement("UPDATE minions\n" +
                "SET age = age + 1, name = CONCAT(LOWER(LEFT(name,1)),SUBSTR(name FROM 2))\n" +
                String.format("WHERE id IN (%s)", String.join(", ", ids)));
        updateStmt.executeUpdate();
        PreparedStatement stmt = connection.prepareStatement("SELECT name, age\n" +
                "FROM minions;");
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }
    }

    //ex 9
    public void increaseAgeStoredProcedure() throws SQLException {
        System.out.println("Please enter minion ID:");
        int id = Integer.parseInt(scanner.nextLine());
        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1,id);
        callableStatement.execute();
        PreparedStatement stmt = connection.prepareStatement("SELECT name, age\n" +
                "FROM minions " +
                "WHERE id = ?;");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));

    }

    private ResultSet insertIntoTable(String query, String columnValue, String table) throws SQLException {
        PreparedStatement insertStmt = connection.prepareStatement(query);
        insertStmt.execute();
        ResultSet resultSet = searchByCriteria("id", table, "name", columnValue);
        resultSet.next();
        return resultSet;
    }

    private ResultSet searchByCriteria(String columnName, String tableName,
                                       String criteria, String searchValue) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(String.format("SELECT %s FROM %s\n" +
                "WHERE %s = '%s';", columnName, tableName, criteria, searchValue));
    }
}
