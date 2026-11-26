/**
 * [7강 실습] 클래스(1) - 1번 문제 ❷ (Book 클래스 - private 필드 + getter / setter)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BookGetterSetter {
    public static void main(String[] args) {
        Book b = new Book();
        b.setTitle("Great C++");
        b.setAuthor("bob");
        System.out.println(b.getTitle() + " - " + b.getAuthor());
        // b.title = "Great C++";   // ❌ error: title has private access in Book
    }
}

class Book {
    private String title;
    private String author;

    public String getTitle() {
        return title;                  // 이름이 겹치지 않으므로 this 생략
    }

    public void setTitle(String title) {
        this.title = title;            // this.title = 필드, title = 매개변수
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
