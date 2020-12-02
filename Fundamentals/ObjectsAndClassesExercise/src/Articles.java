import java.util.Scanner;

public class Articles {
    static class Article{
        String title;
        String content;
        String author;
        public Article(String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }
        public void edit(String content){
            this.content=content;
        }
        public void changeAuthor(String author){
            this.author=author;
        }
        public void rename (String title){
            this.title = title;
        }
        public String toString(){
            return String.format("%s - %s: %s",title,content,author);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(", ");
        Article article = new Article(input[0],input[1],input[2]);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[]command = scanner.nextLine().split(": ");
            switch (command[0]){
                case "Edit":
                    article.edit(command[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(command[1]);
                    break;
                case "Rename":
                    article.rename(command[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
