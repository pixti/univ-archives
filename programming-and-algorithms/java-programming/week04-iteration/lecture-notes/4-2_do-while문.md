# 4-2. 반복문 2: do-while 문

> 원본: `4-2 반복문2.pptx`
> 관련 코드: [`examples/ContinueQuestion.java`](../examples/ContinueQuestion.java), [`examples/MenuCalculatorDoWhile.java`](../examples/MenuCalculatorDoWhile.java), [`examples/NumberGuessingRepeat.java`](../examples/NumberGuessingRepeat.java), [`practice/iteration1/FuelEfficiency.java`](../practice/iteration1/FuelEfficiency.java), [`quiz/IterationQuiz.java`](../quiz/IterationQuiz.java)

---

## 1. do-while 문

> **Python에서는 제공하지 않음**

- while 문의 변형이다.
- while 문은 반복하기 **전에** 조건을 먼저 검사한다. do-while 문은 반복 내용을 **한 번 실행한 후** 조건을 검사한다.
- 그래서 **최소 한 번은 반복 내용이 실행된다.**

```java
do {
    반복 내용들
} while (조건식);     // 세미콜론(;) 필수
```

do-while은 아래 while 코드와 같은 일을 한다. 반복 내용(`aaa`)을 반복문 앞에 한 번 더 써 둔 모양이다.

```java
aaa;
while (조건식) {
    aaa;
}
```

> 참고:
> - `while (조건식);` 끝의 **세미콜론**을 빠뜨리면 컴파일 에러가 난다. 반대로 **일반 while** 뒤에 `;`를 붙이면(`while (조건식);`) 빈 문장을 반복하는 무한루프가 될 수 있으니 조심한다.
> - 파이썬에서 같은 동작이 필요하면 `while True:` + 마지막에 `if not 조건: break`로 흉내 낸다.
>
> 📝 **필기 (퀴즈 1-②):**
> - `x = 10; do { println(x); x--; } while (x < 6);`의 출력을 묻는 문제였다.
> - 1번은 무조건 do를 실행시키고, 조건을 뒤에서 체크함. 그후 true면 do 실행, false면 빠져나옴.
> - 따라서 `10`. 따라서 오답.
> - 💡 정리하면, `10`을 한 번 출력하고 x가 9가 된 뒤 `9 < 6`이 false라서 끝난다. 같은 코드를 while로 쓰면 처음부터 `10 < 6`이 false라서 아무것도 출력되지 않는다. 이 차이가 while과 do-while의 차이다.
>
> 📝 **필기 (실습 반복문1 - 2번 연비 계산):** 반복 횟수가 일정하지 않으므로 for보단 while이 적절하고, 무조건 1번은 실행되므로 do-while이 적절하다.

---

## 2. 사용자에게 반복 여부를 묻는 예제를 do-while로

4-1에서 while로 쓴 "계속 하시겠습니까?" 예제를 do-while로 다시 쓴다.
**반복 조건을 나중에 검사하기 때문에 cont를 `'y'`로 초기화할 필요가 없다.**

```java
char cont;
Scanner sc = new Scanner(System.in);
do {
    // 반복작업 내용
    ...
    System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
    cont = sc.next().charAt(0);
} while (cont == 'y');
```

| | while (4-1) | do-while (4-2) |
|---|---|---|
| 선언 | `char cont = 'y';` (초기화 필수) | `char cont;` (초기화 불필요) |
| 조건 검사 시점 | 블록 실행 **전** | 블록 실행 **후** |
| 최소 실행 횟수 | 0번 | 1번 |

> 참고: do-while에서는 조건 검사 전에 반드시 블록 안의 `cont = sc.next().charAt(0);`이 실행된다. 그래서 컴파일러도 "cont에 값이 들어간 뒤 사용된다"는 것을 알고 에러를 내지 않는다.

---

## 3. [실습] 메뉴 반복 처리하기

4-1에서 while로 작성한 "메뉴 방식의 사칙연산"을 do-while로 바꾼다.

```java
boolean cont = true;
do {
    System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료 ");
    char c = sc.next().charAt(0);

    if (c == 'q') {
        System.out.println("프로그램을 종료하였습니다.");
        cont = false;
    }
    else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd'))
        System.out.println("유효하지 않는 메뉴입니다.");
    else {
        ....
    }
} while (cont);
```

> 참고:
> - 메뉴는 적어도 한 번은 보여 줘야 한다. 그래서 do-while이 자연스럽다.
> - `char c`를 블록 **안에서** 선언했다. c는 반복마다 새로 읽는 값이고 블록 밖에서 쓸 일이 없으므로 이렇게 범위를 좁히는 편이 낫다.
> - 4-1처럼 `boolean cont = true;`로 초기화했다. 하지만 do-while은 조건을 나중에 검사하므로 여기서는 초기값이 없어도 된다. 단, 모든 경로에서 cont에 값을 넣어 줘야 하므로 `else` 쪽에서도 대입이 필요해진다. 그래서 그냥 true로 초기화해 두는 편이 간단하다.
>
> ⚠ 슬라이드의 `"휴효하지 않는 메뉴입니다."`는 오타다. "유효"로 고쳤다.

---

## 4. [실습] 숫자 맞히기 게임 반복하기

4-1의 숫자 맞히기 게임에 "게임을 더 진행할지" 물어보는 기능을 추가한다.

```java
...
do {    // 바깥 반복문 추가, 제어하기 위해 programCont 변수 선언하여 사용
    cont = true;
    System.out.println("게임을 시작합니다.");
    while (cont) {
        System.out.println("예측값 ? ");
        guess = sc.nextInt();
        if (guess > answer) System.out.println("정답보다 큽니다.");
        else if (guess < answer) System.out.println("정답보다 작습니다.");
        else {
            System.out.println("정답입니다!!!");
            cont = false;
        }
    }
    System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
    programCont = sc.next().charAt(0);
} while (programCont == 'y');
System.out.println("게임을 종료합니다.");
sc.close();
```

```
...
예측값 ?
7
정답보다 작습니다.
예측값 ?
9
정답입니다!!!
계속 하시겠습니까 ? ('y' or 'n')
y
게임을 시작합니다.
예측값 ?
```

> 참고: **반복문 안의 반복문**
> - 바깥 do-while은 "게임 한 판"을 반복하고, 안쪽 while은 "한 판 안에서 예측"을 반복한다.
> - 새 판을 시작할 때마다 `cont = true;`로 **다시 초기화**해야 한다. 그렇지 않으면 직전 판에서 false가 된 cont 때문에 안쪽 while에 들어가지 못한다. (퀴즈 3번 Σ·Π에서 안쪽 누적 변수를 매번 초기화하는 것과 같은 이야기)
> - 실행 화면 캡처에서는 바깥 변수 이름이 `gameCont`로 되어 있다. 슬라이드 본문은 `programCont`다. 이름만 다르고 역할은 같다.
>
> ⚠ 슬라이드의 `...` 부분에서 answer를 **바깥 do 앞에서 한 번만** 만든다. 그러면 두 번째 판부터 정답이 계속 같다. 새 판마다 다른 숫자가 나오게 하려면 `answer = rnd.nextInt(100) + 1;`을 do 블록 안(`cont = true;` 근처)으로 옮겨야 한다. [`examples/NumberGuessingRepeat.java`](../examples/NumberGuessingRepeat.java)에서 그렇게 고쳤다.
