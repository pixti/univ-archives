/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 2번 문제 (Searchable 인터페이스)
 *
 * 문제
 *  텍스트 문서에서 주어진 키워드를 검색하는 search(문자열 키워드) 메소드를 갖는 Searchable 인터페이스를 작성하라.
 *  Searchable 인터페이스를 구현하고 search() 메서드의 자체 구현을 제공하는 두 개의 클래스 Document 및 WebPage 를 작성하라.
 *  main 은 다음과 같다.
 *
 *    // Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            Document document = new Document("This is a sample document.");
 *            boolean documentContainsKeyword = document.search("sample");
 *            System.out.println("Document contains keyword 'sample': " + documentContainsKeyword);
 *
 *            WebPage webPage = new WebPage("https://www.w3resource.com", "This is a sample webpage.");
 *            boolean webPageContainsKeyword = webPage.search("webpage");
 *
 *            System.out.println("Webpage contains keyword 'webpage': " + webPageContainsKeyword);
 *        }
 *    }
 *
 * 📝 필기 : 1. 문제 요구사항 및 Main 코드 분석 - 제시된 Main 클래스의 코드와 실행 결과를 통해 역추적할 수 있는 설계 조건
 *  1. Searchable 인터페이스의 메소드 규격
 *     - boolean documentContainsKeyword = document.search("sample"); 코드를 보면, search 메소드는 검색할 단어인
 *       문자열(String) 1개를 매개변수로 전달받는다.
 *     - 메소드의 실행 결과를 boolean 타입 변수에 저장하고, 출력 결과가 true 이므로 반환 타입은 boolean 이어야 한다.
 *     - 따라서 인터페이스에 선언할 추상 메소드의 형태는 boolean search(String keyword); 가 된다.
 *  2. Document 클래스의 구조
 *     - new Document("This is a sample document.") 와 같이 생성자에 문자열 1개를 전달하고 있다.
 *     - 따라서 문서의 본문 내용을 저장할 String 타입의 멤버 변수 1개와, 이를 초기화하는 생성자가 필요하다.
 *  3. WebPage 클래스의 구조
 *     - new WebPage("https://www.w3resource.com", "This is a sample webpage.") 와 같이 생성자에 문자열 2개를 전달하고 있다.
 *     - 첫 번째 인자는 웹사이트의 주소(URL)이고, 두 번째 인자는 웹페이지의 본문 내용이다. 따라서 String 타입의 멤버 변수
 *       2개(url, htmlContent 등)와 이를 초기화하는 생성자가 필요하다.
 *
 * 📝 필기 : 2. 문제에 사용된 핵심 개념 설명
 *  1) String 클래스의 contains() 메소드
 *     자바에서 문자열을 다루는 String 클래스는 문자열 내부에 특정 단어(부분 문자열)가 포함되어 있는지 확인하는 내장 메소드를 제공한다.
 *     - 문법 : 대상문자열.contains("찾을문자열")
 *     - 동작 : 대상 문자열 안에 찾을 문자열이 존재하면 true 를 반환하고, 존재하지 않으면 false 를 반환한다. 대소문자를 구분한다.
 *     - 적용 : 본문 내용이 저장된 변수가 content 이고 검색어가 keyword 라면, content.contains(keyword) 를 호출하여 검색 결과를
 *       즉시 boolean 값으로 얻을 수 있다.
 *     - (참고 : content.indexOf(keyword) != -1 방식을 사용할 수도 있다. indexOf 는 특정 문자열이 시작되는 위치 인덱스를 반환하며,
 *       찾지 못하면 -1 을 반환하므로 동일한 결과를 얻을 수 있다)
 *  2) 인터페이스 구현 클래스의 내부 구조 독립성
 *     1번 문제와 마찬가지로, 인터페이스는 외부에서 호출할 메소드의 형태(boolean search(String keyword))만 강제할 뿐 클래스 내부의
 *     멤버 변수나 생성자의 형태는 관여하지 않는다.
 *     - Document 는 변수가 1개이고, WebPage 는 변수가 2개이지만 둘 다 Searchable 인터페이스의 규격을 따르므로 외부(Main)에서는
 *       동일한 방식(객체.search("키워드"))으로 검색 기능을 사용할 수 있다.
 *     - 만약 WebPage 의 검색 기능을 "본문뿐만 아니라 URL 주소에서도 키워드를 검색" 하도록 변경하고 싶다면, WebPage 내부의
 *       search 메소드만 return htmlContent.contains(keyword) || url.contains(keyword); 형태로 수정하면 된다.
 *       이처럼 인터페이스에 맞춰 각 클래스가 자신의 특성에 맞게 동작을 개별적으로 정의하는 것이 인터페이스를 통한 다형성의 핵심이다.
 *
 * 💡 이클립스는 url 필드에 "값을 쓰기만 하고 읽지 않는다" 는 노란 경고(The value of the field WebPage.url is not used)를 표시한다.
 *    위 필기처럼 search 에서 url 도 검색하거나 getUrl() 을 만들면 사라진다. 실행에는 문제가 없다.
 * ⚠ 자주 틀리는 부분 : contains 는 대소문자를 구분한다. search("Sample") 은 "This is a sample document." 에서 false 다.
 *    대소문자 없이 찾으려면 content.toLowerCase().contains(keyword.toLowerCase()) 처럼 둘 다 소문자로 바꿔서 비교한다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 SearchableTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Document contains keyword 'sample': true
 *  Webpage contains keyword 'webpage': true
 */
public class SearchableTest {
    public static void main(String[] args) {
        Document document = new Document("This is a sample document.");
        boolean documentContainsKeyword = document.search("sample");
        System.out.println("Document contains keyword 'sample': " + documentContainsKeyword);

        WebPage webPage = new WebPage("https://www.w3resource.com", "This is a sample webpage.");
        boolean webPageContainsKeyword = webPage.search("webpage");
        System.out.println("Webpage contains keyword 'webpage': " + webPageContainsKeyword);
    }
}

interface Searchable {
    boolean search(String keyword);
}

class Document implements Searchable {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public boolean search(String keyword) {
        return content.contains(keyword);
    }
}

class WebPage implements Searchable {
    private String url;
    private String htmlContent;

    public WebPage(String url, String htmlContent) {
        this.url = url;
        this.htmlContent = htmlContent;
    }

    @Override
    public boolean search(String keyword) {
        return htmlContent.contains(keyword);
    }
}
