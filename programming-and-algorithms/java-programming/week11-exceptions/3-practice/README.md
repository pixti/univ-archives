# 11주차 실습

[🏠 11주차 학습 가이드](../README.md)

## [exceptions/](exceptions/README.md) · 예외 처리

| 파일 | 내용 |
|---|---|
| [Exception_Example.java](exceptions/README.md#1-0으로-나누기를-throw하고-try-catch로-잡기-getmessage-vs-e-vs-printstacktrace) | 1. 0으로 나누기를 `throw`하고 `try-catch`로 잡기 (📝 `getMessage()` vs `e` vs `printStackTrace()`) |
| [Exception_OddNumber.java](exceptions/README.md#2-홀수이면-illegalargumentexception) | 2. 홀수이면 `IllegalArgumentException` (📝 `n % 2 != 0`이 안전한 이유) |
| [DuplicateNumberTest.java](exceptions/README.md#3-중복-숫자이면-duplicate_number_exception) | 3. 중복 숫자이면 `Duplicate_Number_Exception` (📝 checked라서 `throws` 필수, 💡 `HashSet`) |
| [Vowel_Check.java](exceptions/README.md#4-모음이-없으면-novowelsexception) | 4. 모음이 없으면 `NoVowelsException` (📝 Exception vs RuntimeException, 헷갈리는 개념 5가지, 풀이 6가지) |

## [inheritance3/](inheritance3/README.md) · 상속 (인터페이스, 다중 상속)

| 파일 | 내용 |
|---|---|
| [ShapeInterfaceTest.java](inheritance3/README.md#1-shape-인터페이스와-rectangle--circle--triangle) | 1. `Shape` 인터페이스와 `Rectangle` · `Circle` · `Triangle` (📝 일반 · 추상 클래스 · 인터페이스 비교) |
| [SearchableTest.java](inheritance3/README.md#2-searchable-인터페이스와-document--webpage-contains) | 2. `Searchable` 인터페이스와 `Document` · `WebPage` (📝 `contains()`) |
| [TestPerson.java](inheritance3/README.md#3-person-has-a-job-컴포지션) | 3. `Person` has-a `Job` 컴포지션 (📝 객체 생성 메커니즘, 상속 vs 포함의 메모리 구조) |
| [MultipleInheritanceABC.java](inheritance3/README.md#4-a-b를-모두-상속받는-c-다중-상속불가--컴포지션--인터페이스--컴포지션) | 4. `A`, `B`를 모두 상속받는 `C`: 다중 상속(불가) / 컴포지션 / 인터페이스 + 컴포지션 (📝 다이아몬드 문제) |

