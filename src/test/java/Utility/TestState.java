package Utility;

public class TestState {

    private WebdriverFactory webdriverFactory;
    private PageObjectFactory pageObjectFactory;

    public TestState() throws Exception {
        webdriverFactory = new WebdriverFactory();
        pageObjectFactory = new PageObjectFactory(webdriverFactory.getDriver());
    }

    public WebdriverFactory getWebdriverFactory() {
        return webdriverFactory;
    }

    public PageObjectFactory getPageObjectFactory() {
        return pageObjectFactory;
    }
}
