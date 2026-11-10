# Week 06: 문자열

자바프로그래밍(GA1001) 6주차 정리입니다.
교재는 『자바만 잡아도』입니다.

- 강의 자료(.pptx)는 Markdown으로 정리했습니다.
- 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 수업 중 필기와 AI에게 받은 설명은 **📝 필기** 표시로 주석과 노트에 넣었습니다.
- 💡 표시는 정리하면서 덧붙인 설명입니다. 직접 풀지 않은 문제는 💡 참고 답안으로 채웠습니다.
- ⚠ 표시는 원본 자료의 오타나 버그, 내 답안의 틀린 부분, AI가 알려 준 코드의 문제점을 바로잡은 곳입니다. 바로잡은 코드는 ❌ 원본 / ✅ 수정으로 나란히 두었습니다.

## 📁 구조

```
week06-strings/
├── lecture-notes/          강의 자료 (.pptx → .md)
├── examples/               강의 슬라이드 속 예제 코드
├── practice/               실습
│   ├── strings1/           ├ 문자열(1)
│   └── strings2/           └ 문자열(2) - 정규식
├── quiz/                   퀴즈
└── assignment/             과제
    ├── strings1/           ├ 문자열(1)
    └── strings2/           └ 문자열(2) - 정규식
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 6-1 | [String 생성 · 비교 · 검색 · 조작](lecture-notes/6-1_String생성_비교_검색_조작.md) | 문자열 저장(리터럴 vs `new`), 문자 다루기(`charAt`, `toCharArray`), `equals` vs `==`, `compareTo`, `indexOf`·`startsWith`, `substring`·`concat`, `replace` 계열, `toLowerCase`·`trim` |
| 6-2 | [split · format · String 실습](lecture-notes/6-2_split_format_실습.md) | `split`(인자는 정규식), `printf`·`String.format`, [실습] 아이디·패스워드 검사, 검색 및 치환, 가변 개수 숫자 더하기 |
| 6-3 | [StringBuilder](lecture-notes/6-3_StringBuilder.md) | String vs StringBuilder, `capacity`·`ensureCapacity`, `append`·`insert`·`delete`·`replace`·`reverse`·`setCharAt` 등, [실습] StringBuilder로 검색 및 치환 |
| 6-4 | [정규식 · Pattern · Matcher](lecture-notes/6-4_정규식_Pattern_Matcher.md) | 문자 클래스, 수량자, 위치 앵커(`^ $ \b \B`), `String.matches`, `Pattern.compile`·`matches`·`lookingAt`·`find`·`start`·`end`·`group`, [실습] 이름·주소·우편번호·핸드폰 번호 검사 |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [StringCreate.java](examples/StringCreate.java) | 6-1 | 문자열 생성 (리터럴, `new String`, char 배열로 생성) |
| [StringCompare.java](examples/StringCompare.java) | 6-1 | `equals` vs `==`, `compareTo` |
| [StringSearch.java](examples/StringSearch.java) | 6-1 | `indexOf` · `lastIndexOf` · `startsWith` · `endsWith` · `contains` |
| [StringManipulation.java](examples/StringManipulation.java) | 6-1 | `substring` · `concat` · `replace` 계열 · `toLowerCase` · `trim` |
| [SplitTest.java](examples/SplitTest.java) | 6-2 | `split` |
| [FormatTest.java](examples/FormatTest.java) | 6-2 | `printf`와 `String.format`. ⚠ 슬라이드의 변수 중복 선언 · 미선언 수정 |
| [IDPassword.java](examples/IDPassword.java) | 6-2 | [실습] 아이디와 패스워드 검사 |
| [SearchReplace.java](examples/SearchReplace.java) | 6-2 | [실습] 부분 문자열 검색 및 치환 (`replaceFirst`) |
| [VariableSum.java](examples/VariableSum.java) | 6-2 | [실습] 가변 개수의 숫자 더하기. ⚠ 슬라이드의 클래스 이름 `ConditionOperation`을 바꿈 |
| [StringBuilderCapacity.java](examples/StringBuilderCapacity.java) | 6-3 | `capacity` · `ensureCapacity` (용량이 늘어나는 규칙) |
| [StringBuilderMethods.java](examples/StringBuilderMethods.java) | 6-3 | `append` · `insert` · `delete` · `replace` · `reverse` · `substring` · `setCharAt` 등 |
| [SearchReplaceBuilder.java](examples/SearchReplaceBuilder.java) | 6-3 | [실습] StringBuilder로 검색 및 치환. 💡 찾지 못했을 때(-1) 처리 추가 |
| [RegexMatches.java](examples/RegexMatches.java) | 6-4 | `String.matches`로 전화번호 형식 검사 |
| [PatternMatcherFind.java](examples/PatternMatcherFind.java) | 6-4 | `Pattern` · `Matcher`, `matches` · `lookingAt` · `find`, 꽃 · 고향 · 산골 찾기 |
| [RegularExpression.java](examples/RegularExpression.java) | 6-4 | [실습] 정규식으로 사용자 입력 값 검사. ⚠ 슬라이드의 `compiles` 오타 수정 |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [strings1/WordCount.java](practice/strings1/WordCount.java) | 1. 💡 단어 개수 세기 (split 없이 `Character.isLetter`로) |
| [strings1/WordCountSplit.java](practice/strings1/WordCountSplit.java) | 1. 변형: split 정규식으로 단어 나누기 (⚠ null 검사 → `isEmpty`) |
| [strings1/Palindrome.java](practice/strings1/Palindrome.java) | 2. 회문 검사 (공백 제거 + 양 끝 비교) |
| [strings1/PalindromeRegex.java](practice/strings1/PalindromeRegex.java) | 2. 같은 문제를 정규식으로 특수문자까지 제거 (📝 AI 비교표, ⚠ 한글도 지워짐) |
| [strings1/SpellCorrection.java](practice/strings1/SpellCorrection.java) | 3. 💡 철자 교정 (문장 첫 글자 대문자 등) |
| [strings1/RegexCatDog.java](practice/strings1/RegexCatDog.java) | 3. 풀이 중 해 본 정규식 실험 (`matches` · `replaceAll` · `find`) |
| [strings1/WordFrequency.java](practice/strings1/WordFrequency.java) | 4. 단어 빈도수 |
| [strings2/LowercaseUnderscore.java](practice/strings2/LowercaseUnderscore.java) | 1. 밑줄로 연결된 소문자 문자열 찾기 (⚠ 첫 시도 ❌ / ✅) |
| [strings2/MiddleG.java](practice/strings2/MiddleG.java) | 2. 단어 가운데에 g가 있는지 (`\B` · `\b`) |
| [strings2/ReplaceWords.java](practice/strings2/ReplaceWords.java) | 3. Python → Java, code → coding 바꾸기 |
| [strings2/PinValidation.java](practice/strings2/PinValidation.java) | 4. PIN 번호 검사 (숫자 4 · 6 · 8자리) |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [StringQuiz.java](quiz/StringQuiz.java) | 문자열 1~11번: String 생성, `equals` vs `==`, `compareTo`, 검색·조작 메소드(⚠ 5번 `substring(20)` 예외), `split`, `matches`, StringBuilder `replace`·`capacity`, Pattern/Matcher 빈칸 채우기, StringBuilder 메소드 |

### 과제 (`assignment/`)

| 파일 | 문제 |
|---|---|
| [strings1/ReverseWords.java](assignment/strings1/ReverseWords.java) | 1. 단어 순서를 거꾸로 출력 (`trim` + `split("\\s+")`) |
| [strings1/ReverseWordsRegexSplit.java](assignment/strings1/ReverseWordsRegexSplit.java) | 1. AI 방법 1: split 정규식만으로 (⚠ 앞에 공백이 있으면 단어 사이 공백이 사라지는 버그 ✅ 수정) |
| [strings1/ReverseWordsMatcher.java](assignment/strings1/ReverseWordsMatcher.java) | 1. AI 방법 2: `Matcher.find` + `ArrayList` + `Collections.reverse` |
| [strings1/SwapName.java](assignment/strings1/SwapName.java) | 2. "성 이름" → 소문자 "이름 성" |
| [strings1/FindReplace.java](assignment/strings1/FindReplace.java) | 3. 찾을 문자열을 모두 바꾸기 |
| [strings1/CaesarCipher.java](assignment/strings1/CaesarCipher.java) | 4. 암호화 / 복호화 (+4 시저 암호) |
| [strings2/AlphanumericCheck.java](assignment/strings2/AlphanumericCheck.java) | 1. 영문자와 숫자로만 이루어졌는지 |
| [strings2/PStartQEnd.java](assignment/strings2/PStartQEnd.java) | 2. p로 시작하고 q로 끝나는 문자열 |
| [strings2/StartsWithFive.java](assignment/strings2/StartsWithFive.java) | 3. 숫자 5로 시작하는지 |
| [strings2/VowelCount.java](assignment/strings2/VowelCount.java) | 4. 모음 개수 세기 (📝 import가 필요한 이유, `replaceAll`로 세는 방법) |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/StringBuilderMethods.java
java practice/strings1/Palindrome.java
java quiz/StringQuiz.java
java assignment/strings1/CaesarCipher.java
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 -Dfile.encoding=UTF-8 examples/RegularExpression.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
