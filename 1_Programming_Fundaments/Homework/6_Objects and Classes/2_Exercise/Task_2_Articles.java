import java.util.Scanner;

public class Task_2_Articles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        Article article = new Article(input[0], input[1], input[2]);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split(": ");
            switch (command[0]) {
                case "Edit":
                    article.setContent(command[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(command[1]);
                    break;
                case "Rename":
                    article.setTitles(command[1]);
                    break;
            }
        }
        System.out.println(article);
    }
    public static class Article {
        private String titles;
        private String content;
        private String author;

        public Article(String titles, String content, String author) {
            this.titles = titles;
            this.content = content;
            this.author = author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setTitles(String titles) {
            this.titles = titles;
        }

        public void setContent(String content) {
            this.content = content;
        }
        @Override
        public String toString() {
            return String.format("%s - %s: %s",
                    titles, content, author);
        }
    }
}