/**
 * [7강 실습] 클래스(1) - 1번 문제 ❷ (Book 클래스 - private 필드 + getter / setter)
 *
 * 문제
 *  ❶ 의 Book 클래스의 필드를 private 으로 바꾸고 getter / setter 를 통해 접근하도록 수정하시오.
 *
 * 포인트
 *  - private 필드는 Book 클래스 밖(main 이 있는 클래스)에서 직접 접근할 수 없다.
 *    → b.setTitle("Great C++"); 로 쓰고 b.getTitle() 로 읽는다.
 *  - setter 의 매개변수 이름을 필드와 같게 지으면 this.title = title; 로 구분한다.
 *
 * 📝 필기 : 처음에는 매개변수 이름을 다르게 지어서 이렇게 작성해 봤다.
 *      public String getTitle() { return this.title; }
 *      public void setTitle(String newTitle) { this.title = newTitle; }
 *
 * 📝 필기 (AI 설명) this 키워드
 *   - 같은 클래스로 만든 객체들은 메서드 코드를 객체마다 따로 갖지 않는다.
 *     메서드 코드는 메모리(Method Area)에 한 번만 올라가고 모든 객체가 공유한다.
 *   - 그래서 "어느 객체의 필드인지" 를 알려 줘야 하는데, 그것이 this 다.
 *     b.setTitle("Great C++") 를 호출하면 JVM 이 b 의 주소를 숨겨진 매개변수로 몰래 넘겨주고,
 *     그 값이 바로 this (= 메서드를 호출한 객체) 이다.
 *
 *        b.setTitle("Great C++");
 *            │            │
 *            ▼            ▼
 *        setTitle(this = b, title = "Great C++")  →  this.title = title;  →  b 의 title 에 저장
 *
 *   - 매개변수 이름을 필드 이름과 같게 짓는 것이 표준 관례다.
 *     메서드 안에서는 매개변수가 우선하기 때문에 title = title; 이라고 쓰면 매개변수에 자기 자신을 대입할 뿐
 *     필드는 바뀌지 않는다. → this.title = title; 이 필요하다.
 *   - getter 는 이름이 겹치는 매개변수가 없으므로 return title; 처럼 this 를 생략하는 경우가 많다.
 *     (return this.title; 로 써도 같다)
 *
 * 📝 필기 : 최종 코드는 Book.java 와 Main.java 두 파일로 나눠서 작성했다.
 *    여기서는 한 파일로 실행할 수 있도록 합쳤다. (public class 는 하나만 → Book 의 public 을 뺌,
 *    Main 은 BookGetterSetter 로 이름을 바꿈)
 *
 * 실행 결과
 *  Great C++ - bob
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
