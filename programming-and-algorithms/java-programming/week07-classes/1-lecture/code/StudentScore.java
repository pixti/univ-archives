/**
 * [7-1 실습] 학생 성적 클래스 정의하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StudentScore {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        Student[] students = new Student[3];
        students[0] = new Student();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        students[1] = new Student();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        students[2] = new Student();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
            totalSum += students[i].getAverage();
        }
        korAvg = korSum / (double) students.length;
        engAvg = engSum / (double) students.length;
        mathAvg = mathSum / (double) students.length;
        totalAvg = totalSum / (double) students.length;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class Student {
    String sname;
    int sid, kor, eng, math;

    void setInfo(String name, int id, int k, int e, int m) {
        sname = name;
        sid = id;
        kor = k; eng = e;
        math = m;
    }

    double getAverage() {
        return (kor + eng + math) / 3.0;     // 3 이 아니라 3.0 으로 나눠야 소수점까지 계산
    }

    String getInfo() {
        return sname + ", " + sid + ", " + kor + ", " + eng + ", " + math;
    }
}
