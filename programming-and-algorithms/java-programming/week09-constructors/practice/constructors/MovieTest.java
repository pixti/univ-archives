/**
 * [9강 실습] 생성자 - 3번 문제 (Movie 클래스 - 평점이 가장 좋은 영화)  💡 참고 답안
 *
 * 문제 (요약)
 *  영화 제목(name), 감독(director), 평점(point)을 필드로 가지는 Movie 클래스를 작성하시오.
 *  - 생성자를 중복 정의한다. (모든 값을 받는 생성자 / 매개변수 없는 생성자)
 *  - 주어진 main 으로 세 영화를 출력하고, 평점이 가장 좋은 영화의 제목을 출력한다.
 *
 *    Movie m1 = new Movie("아저씨", "이정범", 9.28);
 *    Movie m2 = new Movie("슈퍼배드", "피에르 꼬팽", 8.96);
 *    Movie m3 = new Movie();
 *    m3.setName("무적자");
 *    m3.setDirector("송해성");
 *    m3.setPoint(6.08);
 *
 * 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
 * 💡 "가장 좋은 영화" 를 구하는 메소드를 static 으로 두고 Movie 객체 세 개를 받게 했다.
 *    객체(레퍼런스)를 그대로 돌려주므로 제목뿐 아니라 감독 · 평점도 꺼낼 수 있다.
 *
 * 실행 결과
 *  ========================
 *  영화제목 : 아저씨
 *  감    독 : 이정범
 *  평    점 : 9.28
 *  ========================
 *  영화제목 : 슈퍼배드
 *  감    독 : 피에르 꼬팽
 *  평    점 : 8.96
 *  ========================
 *  영화제목 : 무적자
 *  감    독 : 송해성
 *  평    점 : 6.08
 *  ========================
 *  가장 평점이 좋은 영화 : 아저씨
 */
public class MovieTest {
    public static void main(String[] args) {
        Movie m1 = new Movie("아저씨", "이정범", 9.28);
        Movie m2 = new Movie("슈퍼배드", "피에르 꼬팽", 8.96);
        Movie m3 = new Movie();
        m3.setName("무적자");
        m3.setDirector("송해성");
        m3.setPoint(6.08);

        System.out.println("========================");
        m1.print();
        m2.print();
        m3.print();

        Movie best = best(m1, m2, m3);
        System.out.println("가장 평점이 좋은 영화 : " + best.getName());
    }

    static Movie best(Movie a, Movie b, Movie c) {
        Movie best = a;
        if (b.getPoint() > best.getPoint()) best = b;
        if (c.getPoint() > best.getPoint()) best = c;
        return best;
    }
}

class Movie {
    private String name;
    private String director;
    private double point;

    public Movie() {
        this("", "", 0.0);
    }

    public Movie(String name, String director, double point) {
        this.name = name;
        this.director = director;
        this.point = point;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public double getPoint() { return point; }
    public void setPoint(double point) { this.point = point; }

    public void print() {
        System.out.println("영화제목 : " + name);
        System.out.println("감    독 : " + director);
        System.out.println("평    점 : " + point);
        System.out.println("========================");
    }
}
