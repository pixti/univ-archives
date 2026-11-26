/**
 * [7-2 실습] 앞 예제(StudentScore.java)를 this 키워드와 정적 변수를 사용하여 재구현하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StudentScoreStatic {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        StudentStatic[] students = new StudentStatic[100];
        students[0] = new StudentStatic();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        StudentStatic.count++; // students[0].count++;
        students[1] = new StudentStatic();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        StudentStatic.count++; // students[0].count++;
        students[2] = new StudentStatic();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);
        StudentStatic.count++; // students[0].count++;

        for (int i = 0; i < StudentStatic.count; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
            totalSum += students[i].getAverage();
        }
        korAvg = ((double) korSum) / StudentStatic.count;
        engAvg = ((double) engSum) / StudentStatic.count;
        mathAvg = ((double) mathSum) / StudentStatic.count;
        totalAvg = totalSum / StudentStatic.count;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class StudentStatic {
    String sname;
    int sid, kor, eng, math;
    static int count = 0; // 정적 변수 추가!

    void setInfo(String name, int id, int k, int e, int m) {
        this.sname = name; this.sid = id; this.kor = k; this.eng = e; this.math = m;
    }

    double getAverage() { return (this.kor + this.eng + this.math) / 3.0; }

    String getInfo() {
        return this.sname + ", " + this.sid + ", " + this.kor + ", " + this.eng + ", " + this.math;
    }
}
