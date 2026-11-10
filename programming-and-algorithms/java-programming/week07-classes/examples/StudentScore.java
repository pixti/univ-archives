/**
 * [8-1 실습] 학생 성적 클래스 정의하기
 *
 * 포인트
 *  - Student 클래스 = 필드(sname, sid, kor, eng, math) + 메소드(setInfo, getAverage, getInfo)
 *  - Student[] students = new Student[3];  → "레퍼런스 3칸" 만 생긴다. (객체는 아직 없음, 모두 null)
 *    students[0] = new Student();         → 각 칸마다 new 로 객체를 따로 만들어 넣어야 한다.
 *  - students[i].kor 처럼 필드에 직접 접근 (필드에 접근 수정자가 없어서 같은 패키지면 접근 가능, 8-3 참고)
 *  - korSum / (double) students.length : 정수 / 정수 는 소수점이 버려지므로 double 로 형변환
 *
 *      students ──▶ [ ● | ● | ● ]
 *                     │   │   └──▶ Student{bmkim3, 2016003, 50, 60, 70}
 *                     │   └──────▶ Student{bmkim2, 2016002, 60, 70, 80}
 *                     └──────────▶ Student{bmkim1, 2016001, 70, 80, 90}
 *
 * ⚠ 슬라이드 첫 줄 주석은 "// StudentInfo.java 파일" 이지만 public class 이름이 StudentScore 이므로
 *    파일 이름은 StudentScore.java 여야 한다.
 *
 * 실행 결과
 *  bmkim1, 2016001, 70, 80, 90
 *  bmkim2, 2016002, 60, 70, 80
 *  bmkim3, 2016003, 50, 60, 70
 *  국어 평균 : 60.0
 *  영어 평균 : 70.0
 *  수학 평균 : 80.0
 *  전체 평균 : 70.0
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
