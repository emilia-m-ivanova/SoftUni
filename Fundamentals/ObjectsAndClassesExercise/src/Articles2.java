import java.util.*;

public class Articles2 {
    static class Article{
        String title;
        String content;
        String author;
        public Article(String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle(){
            return this.title;
        }

        public String getContent(){
            return this.content;
        }

        public String getAuthor(){
            return this.author;
        }

        public String toString(){
            return String.format("%s - %s: %s",title,content,author);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article> articleList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] articleArray = scanner.nextLine().split(", ");
            Article newArticle = new Article(articleArray[0], articleArray[1],articleArray[2]);
            articleList.add(newArticle);
        }
        String comparator = scanner.nextLine();
        switch (comparator){
            case "title":
                articleList.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articleList.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articleList.sort(Comparator.comparing(Article::getAuthor));
                break;
        }
        for (Article article : articleList) {
            System.out.println(article.toString());
        }
    }
}
