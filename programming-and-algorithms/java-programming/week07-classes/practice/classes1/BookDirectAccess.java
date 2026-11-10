/**
 * [7강 실습] 클래스(1) - 1번 문제 ❶ (Book 클래스 - public 필드에 직접 접근)
 *
 * 문제
 *  책 제목(title)과 저자(author)를 필드로 가지는 Book 클래스를 만들고,
 *  Book 클래스 안의 main 에서 객체를 만들어 필드에 직접 값을 넣고 출력하시오.
 *
 * 포인트
 *  - 필드를 public 으로 열어 두면 b.title = "..." 처럼 "객체.필드" 로 바로 읽고 쓸 수 있다.
 *  - 간단하지만 아무 값이나 들어갈 수 있어서(유효성 검사 불가) 보통은 ❷ 처럼 private + getter/setter 로 바꾼다.
 *    (퀴즈 2번 📝 필기 : 캡슐화와 정보 은닉)
 *
 * 💡 문제의 클래스 이름은 Book. 같은 폴더의 ❷ 버전(BookGetterSetter.java)에 있는 Book 과 겹치지 않도록
 *    BookDirectAccess 로 바꿨다.
 *
 * 실행 결과
 *  Great C++ - bob
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
