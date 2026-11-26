/**
 * [9강 실습] 생성자 - 3번 문제 (Movie 클래스 - 평점이 가장 좋은 영화)  💡 참고 답안
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
