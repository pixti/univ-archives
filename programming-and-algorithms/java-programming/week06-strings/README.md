# Week 06: 문자열

자바프로그래밍(GA1001) 6주차 정리입니다.

- 강의 내용은 `1-lecture/`에 정리했습니다.
- 퀴즈 · 실습 · 과제는 폴더마다 `README.md`에 **문제 → 풀이 코드 → 실행 결과 → 📝 필기 · 해설** 순서로 정리했습니다. 같은 폴더의 `.java` 파일은 바로 실행해 볼 수 있는 코드입니다.

| 표시 | 의미 |
|---|---|
| 📝 **필기** | 수업 중 필기한 내용, 질문하며 정리한 설명 |
| 💡 **보충** | 정리하면서 덧붙인 설명, 참고 답안 |
| ⚠ **주의** | 자주 틀리는 부분, 헷갈리기 쉬운 부분 |
| ❌ / ✅ | 틀린 코드 / 고친 코드 |

## 📚 학습 순서

수업 흐름(교안 → 퀴즈 → 실습 → 과제)대로 읽도록 폴더 이름에 번호를 붙였습니다.

| 단계 | 이렇게 공부하세요 | 바로가기 |
|---|---|---|
| 1️⃣ 강의 | 강의 노트로 개념을 익히고, 예제 코드를 직접 실행해 결과를 확인합니다. | 노트 [6-1](1-lecture/6-1_String생성_비교_검색_조작.md) · [6-2](1-lecture/6-2_split_format_실습.md) · [6-3](1-lecture/6-3_StringBuilder.md) · [6-4](1-lecture/6-4_정규식_Pattern_Matcher.md) · [예제 코드](1-lecture/code/README.md) |
| 2️⃣ 퀴즈 | 문제만 보고 답을 먼저 떠올린 뒤, 정답과 📝 필기로 확인합니다. | [퀴즈](2-quiz/README.md) |
| 3️⃣ 실습 | 문제를 직접 풀어 본 뒤, 풀이 코드 · 실행 결과 · 해설과 비교합니다. | [strings1](3-practice/strings1/README.md) · [strings2](3-practice/strings2/README.md) |
| 4️⃣ 과제 | 실습에서 익힌 내용을 응용합니다. ⚠ 자주 틀리는 부분을 다시 확인하세요. | [strings1](4-assignment/strings1/README.md) · [strings2](4-assignment/strings2/README.md) |

## 1️⃣ 강의 노트 (`1-lecture/`)

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 6-1 | [String 생성 · 비교 · 검색 · 조작](1-lecture/6-1_String생성_비교_검색_조작.md) | 문자열 저장(리터럴 vs `new`), 문자 다루기(`charAt`, `toCharArray`), `equals` vs `==`, `compareTo`, `indexOf`·`startsWith`, `substring`·`concat`, `replace` 계열, `toLowerCase`·`trim` |
| 6-2 | [split · format · String 실습](1-lecture/6-2_split_format_실습.md) | `split`(인자는 정규식), `printf`·`String.format`, [실습] 아이디·패스워드 검사, 검색 및 치환, 가변 개수 숫자 더하기 |
| 6-3 | [StringBuilder](1-lecture/6-3_StringBuilder.md) | String vs StringBuilder, `capacity`·`ensureCapacity`, `append`·`insert`·`delete`·`replace`·`reverse`·`setCharAt` 등, [실습] StringBuilder로 검색 및 치환 |
| 6-4 | [정규식 · Pattern · Matcher](1-lecture/6-4_정규식_Pattern_Matcher.md) | 문자 클래스, 수량자, 위치 앵커(`^ $ \b \B`), `String.matches`, `Pattern.compile`·`matches`·`lookingAt`·`find`·`start`·`end`·`group`, [실습] 이름·주소·우편번호·핸드폰 번호 검사 |

### 강의 예제 코드 ([`1-lecture/code/`](1-lecture/code/README.md))

| 파일 | 차시 | 내용 |
|---|---|---|
| [StringCreate.java](1-lecture/code/README.md#string-클래스---문자열-저장하기--문자열에서-문자-다루기) | 6-1 | 문자열 생성 (리터럴, `new String`, char 배열로 생성) |
| [StringCompare.java](1-lecture/code/README.md#string-클래스---문자열-비교-equals----compareto) | 6-1 | `equals` vs `==`, `compareTo` |
| [StringSearch.java](1-lecture/code/README.md#string-클래스---문자열-검색-startswith--endswith--indexof--lastindexof) | 6-1 | `indexOf` · `lastIndexOf` · `startsWith` · `endsWith` · `contains` |
| [StringManipulation.java](1-lecture/code/README.md#string-클래스---문자열-조작하기) | 6-1 | `substring` · `concat` · `replace` 계열 · `toLowerCase` · `trim` |
| [SplitTest.java](1-lecture/code/README.md#string-클래스---문자열-분리-split) | 6-2 | `split` |
| [FormatTest.java](1-lecture/code/README.md#string-클래스---문자열-포맷하기-printf--stringformat) | 6-2 | `printf`와 `String.format`. ⚠ 같은 변수를 두 번 선언하는 실수 |
| [IDPassword.java](1-lecture/code/README.md#아이디와-패스워드-검사) | 6-2 | [실습] 아이디와 패스워드 검사 |
| [SearchReplace.java](1-lecture/code/README.md#부분-문자열-검색-및-치환하기-string-이용----6-3-에서-같은-코드를-다시-보여준-뒤-stringbuilder-로-수정) | 6-2 | [실습] 부분 문자열 검색 및 치환 (`replaceFirst`) |
| [VariableSum.java](1-lecture/code/README.md#가변-개수의-숫자-더하기) | 6-2 | [실습] 가변 개수의 숫자 더하기 (`split` + `Integer.parseInt`) |
| [StringBuilderCapacity.java](1-lecture/code/README.md#stringbuilder-클래스---생성--용량-length--capacity--ensurecapacity) | 6-3 | `capacity` · `ensureCapacity` (용량이 늘어나는 규칙) |
| [StringBuilderMethods.java](1-lecture/code/README.md#stringbuilder-클래스---주요-메소드) | 6-3 | `append` · `insert` · `delete` · `replace` · `reverse` · `substring` · `setCharAt` 등 |
| [SearchReplaceBuilder.java](1-lecture/code/README.md#부분-문자열-바꾸기---이전-프로그램searchreplacejava-을-stringbuilder-로-수정) | 6-3 | [실습] StringBuilder로 검색 및 치환. 💡 찾지 못했을 때(-1) 처리 추가 |
| [RegexMatches.java](1-lecture/code/README.md#정규식-관련-클래스---string-클래스의-matches) | 6-4 | `String.matches`로 전화번호 형식 검사 |
| [PatternMatcherFind.java](1-lecture/code/README.md#정규식-관련-클래스---pattern-matcher-클래스) | 6-4 | `Pattern` · `Matcher`, `matches` · `lookingAt` · `find`, 꽃 · 고향 · 산골 찾기 |
| [RegularExpression.java](1-lecture/code/README.md#정규식을-이용한-사용자-입력-값-검사) | 6-4 | [실습] 정규식으로 사용자 입력 값 검사. ⚠ 긴 정규식은 `+`로 이어 쓴다 |

## 2️⃣ 퀴즈 ([`2-quiz/`](2-quiz/README.md))

| 파일 | 내용 |
|---|---|
| [StringQuiz.java](2-quiz/README.md#문자열-string--stringbuilder--정규식) | 문자열 1~11번: String 생성, `equals` vs `==`, `compareTo`, 검색·조작 메소드(⚠ 5번 `substring(20)` 예외), `split`, `matches`, StringBuilder `replace`·`capacity`, Pattern/Matcher 빈칸 채우기, StringBuilder 메소드 |

## 3️⃣ 실습 (`3-practice/`)

| 파일 | 문제 |
|---|---|
| [strings1/WordCount.java](3-practice/strings1/README.md#1-단어-개수-세기-split-없이-characterisletter로) | 1. 💡 단어 개수 세기 (split 없이 `Character.isLetter`로) |
| [strings1/WordCountSplit.java](3-practice/strings1/README.md#1-변형-split-정규식으로-단어-나누기) | 1. 변형: split 정규식으로 단어 나누기 (⚠ null 검사 → `isEmpty`) |
| [strings1/Palindrome.java](3-practice/strings1/README.md#2-회문-검사-공백-제거--양-끝-비교) | 2. 회문 검사 (공백 제거 + 양 끝 비교) |
| [strings1/PalindromeRegex.java](3-practice/strings1/README.md#2-같은-문제를-정규식으로-특수문자까지-제거) | 2. 같은 문제를 정규식으로 특수문자까지 제거 (📝 두 방법 비교표, ⚠ 한글도 지워짐) |
| [strings1/SpellCorrection.java](3-practice/strings1/README.md#3-철자-교정-문장-첫-글자-대문자-등) | 3. 💡 철자 교정 (문장 첫 글자 대문자 등) |
| [strings1/RegexCatDog.java](3-practice/strings1/README.md#3-풀이-중-해-본-정규식-실험-matches--replaceall--find) | 3. 풀이 중 해 본 정규식 실험 (`matches` · `replaceAll` · `find`) |
| [strings1/WordFrequency.java](3-practice/strings1/README.md#4-단어-빈도수) | 4. 단어 빈도수 |
| [strings2/LowercaseUnderscore.java](3-practice/strings2/README.md#1-밑줄로-연결된-소문자-문자열-찾기) | 1. 밑줄로 연결된 소문자 문자열 찾기 (⚠ 첫 시도 ❌ / ✅) |
| [strings2/MiddleG.java](3-practice/strings2/README.md#2-단어-가운데에-g가-있는지-b--b) | 2. 단어 가운데에 g가 있는지 (`\B` · `\b`) |
| [strings2/ReplaceWords.java](3-practice/strings2/README.md#3-python--java-code--coding-바꾸기) | 3. Python → Java, code → coding 바꾸기 |
| [strings2/PinValidation.java](3-practice/strings2/README.md#4-pin-번호-검사-숫자-4--6--8자리) | 4. PIN 번호 검사 (숫자 4 · 6 · 8자리) |

## 4️⃣ 과제 (`4-assignment/`)

| 파일 | 문제 |
|---|---|
| [strings1/ReverseWords.java](4-assignment/strings1/README.md#1-단어-순서를-거꾸로-출력-trim--splits) | 1. 단어 순서를 거꾸로 출력 (`trim` + `split("\\s+")`) |
| [strings1/ReverseWordsRegexSplit.java](4-assignment/strings1/README.md#1-다른-풀이-1-split-정규식만으로) | 1. 다른 풀이 1: split 정규식만으로 (⚠ 앞에 공백이 있으면 단어 사이 공백이 사라지는 실수와 고친 코드) |
| [strings1/ReverseWordsMatcher.java](4-assignment/strings1/README.md#1-다른-풀이-2-matcherfind--arraylist--collectionsreverse) | 1. 다른 풀이 2: `Matcher.find` + `ArrayList` + `Collections.reverse` |
| [strings1/SwapName.java](4-assignment/strings1/README.md#2-성-이름--소문자-이름-성) | 2. "성 이름" → 소문자 "이름 성" |
| [strings1/FindReplace.java](4-assignment/strings1/README.md#3-찾을-문자열을-모두-바꾸기) | 3. 찾을 문자열을 모두 바꾸기 |
| [strings1/CaesarCipher.java](4-assignment/strings1/README.md#4-암호화--복호화-4-시저-암호) | 4. 암호화 / 복호화 (+4 시저 암호) |
| [strings2/AlphanumericCheck.java](4-assignment/strings2/README.md#1-영문자와-숫자로만-이루어졌는지) | 1. 영문자와 숫자로만 이루어졌는지 |
| [strings2/PStartQEnd.java](4-assignment/strings2/README.md#2-p로-시작하고-q로-끝나는-문자열) | 2. p로 시작하고 q로 끝나는 문자열 |
| [strings2/StartsWithFive.java](4-assignment/strings2/README.md#3-숫자-5로-시작하는지) | 3. 숫자 5로 시작하는지 |
| [strings2/VowelCount.java](4-assignment/strings2/README.md#4-모음-개수-세기) | 4. 모음 개수 세기 (📝 import가 필요한 이유, `replaceAll`로 세는 방법) |

## 📁 구조

```
week06-strings/
├── README.md              학습 가이드 (이 문서)
├── 1-lecture/             1️⃣ 강의 노트
│   └── code/              　  강의 예제 코드 (README + .java)
├── 2-quiz/                2️⃣ 퀴즈 (README + .java)
├──  3-practice/          3️⃣ 실습
│   ├── strings1/         문자열(1)
│   └── strings2/         문자열(2) - 정규식
└──  4-assignment/        4️⃣ 과제
    ├── strings1/         문자열(1)
    └── strings2/         문자열(2) - 정규식
```

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java 1-lecture/code/StringBuilderMethods.java
java 3-practice/strings1/Palindrome.java
java 2-quiz/StringQuiz.java
java 4-assignment/strings1/CaesarCipher.java
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 -Dfile.encoding=UTF-8 1-lecture/code/RegularExpression.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
