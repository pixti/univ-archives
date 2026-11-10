/**
 * [9강 실습] 생성자 - 4번 문제 (Nation 클래스 - 인구 · 국민소득 비교)  💡 참고 답안
 *
 * 문제 (요약)
 *  국가 이름(country), 인구(population, 만 명), 넓이(area, ㎢), 국민 소득(income, $)을 필드로 가지는
 *  Nation 클래스를 작성하시오.
 *  - 생성자를 중복 정의한다. (모든 값을 받는 생성자 / 매개변수 없는 생성자)
 *  - 주어진 main 으로 세 나라를 출력하고, 인구가 가장 많은 국가와 국민소득이 가장 높은 국가를 출력한다.
 *
 *    Nation n1 = new Nation("대한민국", 4977, 100032, 17074);
 *    Nation n2 = new Nation("일본", 12728, 377835, 39731);
 *    Nation n3 = new Nation();
 *    n3.setCountry("중국");
 *    n3.setPopulation(133004);
 *    n3.setArea(9596960);
 *    n3.setIncome(3677);
 *
 * 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
 * ⚠ 문제의 실행 결과에는 중국의 넓이가 9.59696e+006 으로 나온다. C++ 의 cout 이 큰 실수를 지수 표기로
 *    출력한 것이다(원래 C++ 용 문제). 자바에서 int 로 저장하면 9596960 그대로 나온다.
 *    (double 로 저장하면 자바도 9596960.0 으로 출력. 지수 표기는 1.0E7 이상부터)
 *
 * 실행 결과
 *  ==========================
 *  국가 이름 : 대한민국
 *  인    구 : 4977만명
 *  넓    이 : 100032㎢
 *  국민 소득 : 17074$
 *  ==========================
 *  국가 이름 : 일본
 *  인    구 : 12728만명
 *  넓    이 : 377835㎢
 *  국민 소득 : 39731$
 *  ==========================
 *  국가 이름 : 중국
 *  인    구 : 133004만명
 *  넓    이 : 9596960㎢
 *  국민 소득 : 3677$
 *  ==========================
 *  가장 인구가 많은 국가 : 중국
 *  가장 국민소득이 높은 국가 : 일본
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
