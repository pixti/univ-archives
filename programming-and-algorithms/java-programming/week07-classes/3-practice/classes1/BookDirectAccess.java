/**
 * [7강 실습] 클래스(1) - 1번 문제 ❶ (Book 클래스 - public 필드에 직접 접근)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BookDirectAccess {
    public String title;
    public String author;

    public static void main(String[] args) {
        BookDirectAccess b = new BookDirectAccess();     // 원래 코드 : Book b = new Book();
        b.title = "Great C++";
        b.author = "bob";
        System.out.println(b.title + " - " + b.author);
    }
}
