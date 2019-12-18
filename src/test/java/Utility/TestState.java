package Utility;

/**
 * Exposes pages and driver factory with the single instance.Also this can be used to stored the temporary data while test execution to be used in later steps
 *
 * @author Arpit Kothari (arpitkothari45@gmail.com)
 * @version 1.0
 */
public class TestState {

    public String emailAddress;
    public String selectedItem;
    private WebdriverFactory webdriverFactory;
    private PageObjectFactory pageObjectFactory;

    public TestState() throws Exception {
        webdriverFactory = new WebdriverFactory();
        pageObjectFactory = new PageObjectFactory(webdriverFactory.getDriver());
    }

    /**
     * Gets instance of WebdriverFactory class
     *
     * @return
     */
    public WebdriverFactory getWebdriverFactory() {
        return webdriverFactory;
    }

    /**
     * Gets instance of PageObjectFactory class
     *
     * @return
     */
    public PageObjectFactory getPageObjectFactory() {
        return pageObjectFactory;
    }
}
