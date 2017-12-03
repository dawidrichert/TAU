package pl.edu.pjatk.tau.pages;

public class PageElement {
    private String id;
    private String xpath;

    public PageElement(String id) {
        this.id = id;
    }

    public PageElement(String id, String xpath) {
        this.id = id;
        this.xpath = xpath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
}
