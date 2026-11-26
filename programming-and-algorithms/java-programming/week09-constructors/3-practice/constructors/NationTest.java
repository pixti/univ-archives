/**
 * [9강 실습] 생성자 - 4번 문제 (Nation 클래스 - 인구 · 국민소득 비교)  💡 참고 답안
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class NationTest {
    public static void main(String[] args) {
        Nation n1 = new Nation("대한민국", 4977, 100032, 17074);
        Nation n2 = new Nation("일본", 12728, 377835, 39731);
        Nation n3 = new Nation();
        n3.setCountry("중국");
        n3.setPopulation(133004);
        n3.setArea(9596960);
        n3.setIncome(3677);

        Nation[] nations = { n1, n2, n3 };   // 💡 객체 배열로 묶으면 반복문으로 비교하기 편하다

        System.out.println("==========================");
        for (Nation n : nations) {
            n.print();
        }

        Nation maxPop = nations[0];
        Nation maxIncome = nations[0];
        for (Nation n : nations) {
            if (n.getPopulation() > maxPop.getPopulation()) maxPop = n;
            if (n.getIncome() > maxIncome.getIncome()) maxIncome = n;
        }
        System.out.println("가장 인구가 많은 국가 : " + maxPop.getCountry());
        System.out.println("가장 국민소득이 높은 국가 : " + maxIncome.getCountry());
    }
}

class Nation {
    private String country;
    private int population;   // 만 명
    private int area;         // ㎢
    private int income;       // $

    public Nation() {
        this("", 0, 0, 0);
    }

    public Nation(String country, int population, int area, int income) {
        this.country = country;
        this.population = population;
        this.area = area;
        this.income = income;
    }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }
    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }
    public int getIncome() { return income; }
    public void setIncome(int income) { this.income = income; }

    public void print() {
        System.out.println("국가 이름 : " + country);
        System.out.println("인    구 : " + population + "만명");
        System.out.println("넓    이 : " + area + "㎢");
        System.out.println("국민 소득 : " + income + "$");
        System.out.println("==========================");
    }
}
