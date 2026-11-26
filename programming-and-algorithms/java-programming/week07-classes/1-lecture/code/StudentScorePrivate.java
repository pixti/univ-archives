/**
 * [7-3 실습] 접근자에 따른 변수 접근성 확인하기 - 필드를 private 으로, getter 로 읽기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StudentScorePrivate {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        StudentPrivate[] students = new StudentPrivate[3];
        students[0] = new StudentPrivate();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        students[1] = new StudentPrivate();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        students[2] = new StudentPrivate();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);

        for (int i = 0; i < 3; i++) {
            System.out.println(students[i].getInfo());
            // korSum += students[i].kor;     // ❌ 컴파일 오류 : kor has private access in StudentPrivate
            korSum += students[i].getKor();    // ✅ getter 로 읽기
            engSum += students[i].getEng();
            mathSum += students[i].getMath();
            totalSum += students[i].getAverage();
        }
        korAvg = korSum / 3.0;
        engAvg = engSum / 3.0;
        mathAvg = mathSum / 3.0;
        totalAvg = totalSum / 3.0;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class StudentPrivate {
    private String sname;
    private int sid, kor, eng, math;

    public String getName() { return sname; }
    public int getSID() { return sid; }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }

    void setInfo(String name, int id, int k, int e, int m) {
        sname = name; sid = id; kor = k; eng = e; math = m;
    }

    double getAverage() { return (kor + eng + math) / 3.0; }

    String getInfo() {
        return sname + ", " + sid + ", " + kor + ", " + eng + ", " + math;
    }
}
