import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {
    //Initializing the WebDriver depending on the used browser
    public static WebDriver driver = new EdgeDriver();

    public static void main(String[] args) {
        maximizeWindow();
        openBrowser("https://the-internet.herokuapp.com/login");
        printPageTitle();
        printPageUrl();
        printWindowHandle();
        openNewTab();
        navigateTo("https://fb.com");
        printWindowHandle();
//        closeTab();
        waitForMs(5000);

        closeTab();
        waitForMs(3000);
        closeWindow();
//        waitForMs(5000);
//        setWindowSize(430,932);
//        printPageSourceCode();
//        navigateTo("https://fb.com");
//        refreshPage();

    }

    public static void waitForMs(int Ms){
        try {
            Thread.sleep(Ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //This function is used to open the browser on a specific web page
    public static void openBrowser(String url){
        driver.get(url);

    }

    public static void closeWindow(){
        if(driver != null){
            driver.quit();
        }
    }

    public static void closeTab(){
        if(driver != null){
            driver.close();
        }
    }
    //This function is used to navigate to a specific website
    public static void navigateTo(String url){
        driver.navigate().to(url);
    }

    //This function is used to refresh the web page
    public static void refreshPage(){
        driver.navigate().refresh();
    }

    //This function is used to maximize the browser window
    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    //This function is used to control the browser window dimensions
    public static void setWindowSize(int width, int height){
        driver.manage().window().setSize(new Dimension(width,height)); //this is called anonymous object
    }

    public static void printPageUrl(){
        System.out.println(driver.getCurrentUrl());
    }

    public static void printPageTitle(){
        System.out.println(driver.getTitle());
    }

    public static void printPageSourceCode(){
        System.out.println(driver.getPageSource());
    }

    public static void printWindowHandle(){
        System.out.println(driver.getWindowHandle());
    }

    public static void openNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public static void openNewWindow(){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
}
