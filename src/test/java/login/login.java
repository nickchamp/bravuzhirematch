package login;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    private WebDriver driver = null;
//    String sessionId;
//    private String url;
//
//    private static int flag = 0;
    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^I am on Bravuz login page$")
    public void iAmOnBravuzLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JustDoIt\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://bravuzhirematch.do-it.co/");
    }

    @When("^I enter username as \"([^\"]*)\"$")
    public void iEnterUsernameAs(String arg0) {
        driver.findElement(By.id("login-input")).sendKeys(arg0);
    }

    @When("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String arg1) {
        driver.findElement(By.id("password-input")).sendKeys(arg1);
        driver.findElement(By.cssSelector("form > button")).click();
    }

    @Then("^Login should pass$")
    public void loginShouldPass() {
        String role = scenario.getName();
        if (roleLabelCheck(role, driver)) {
            System.out.println(role + " passed");
        } else {
            System.out.println(role + " failed");
        }
    }

    @After
    public void after() {
        driver.close();
    }

    private static boolean roleLabelCheck(String role, WebDriver driver) {
        WebElement element = driver.findElement(By.id("sidebar-user-role"));

        return element.getText().equalsIgnoreCase(role);
    }
}
