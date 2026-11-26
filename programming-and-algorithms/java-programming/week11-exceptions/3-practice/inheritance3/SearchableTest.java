/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 2번 문제 (Searchable 인터페이스)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
