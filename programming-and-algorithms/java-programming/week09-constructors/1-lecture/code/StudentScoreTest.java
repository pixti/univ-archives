/**
 * [9-3 생성자와 소멸자] [실습] 학생 성적 클래스 정의하기 – 전체, 과목별 평균
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StudentScoreTest {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;
        StudentScore[] students = new StudentScore[3];   // 💡 레퍼런스 배열만 생김 (객체는 아직 없음)
        students[0] = new StudentScore("bmkim1", 2016001, 70, 80, 90);
        students[1] = new StudentScore("bmkim2", 2016002, 60, 70, 80);
        students[2] = new StudentScore("bmkim3", 2016003, 50, 60, 70);

        for (int i = 0; i < 3; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
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

class StudentScore {
    String sname;
    int sid, kor, eng, math;

    public StudentScore(String name, int id, int k, int e, int m) {   // 생성자
        sname = name;
        sid = id;
        kor = k;
        eng = e;
        math = m;
    }

    double getAverage() {
        return (kor + eng + math) / 3.0;   // 💡 3 이 아니라 3.0 → 실수 나눗셈
    }

    String getInfo() {
        return sname + ", " + sid + ", " + kor + ", " + eng + ", " + math;
    }
}
