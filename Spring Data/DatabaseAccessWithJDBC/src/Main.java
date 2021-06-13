import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.print("Enter password default (empty):");
        String password = sc.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt = connection.prepareStatement
                ("SELECT u.user_name, u.first_name, u.last_name, COUNT(g.id) AS game_count " +
                        "FROM users AS u, users_games AS g " +
                        "WHERE u.user_name = ? AND u.id = g.user_id " +
                        "GROUP BY g.user_id");
        System.out.print("Enter username:");

        String username = sc.nextLine();
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        if(!rs.next()){
            System.out.println("No such user exists");
        }
        while(rs.next()) {
            System.out.printf("User: %s%n%s %s has played %d games%n",
                    rs.getString("user_name"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("game_count"));
        }


    }

}
