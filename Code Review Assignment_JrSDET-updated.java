package com.org.happyfox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Testcase101 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://interview.supporthive.com/staff/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("id_username")).sendKeys("Agent");
		driver.findElement(By.id("id_password")).sendKeys("Agent@123");
		driver.findElement(By.id("btn-submit")).click();
		WebElement tickets = driver.findElement(By.id("ember29"));
		Actions action = new Actions(driver);
		action.moveToElement(tickets).build().perform();
		WebElement statuses = driver.findElement(By.linkText("Statuses"));
		statuses.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();// we can avoid using absolute xpath
		driver.findElement(By.tagName("input")).sendKeys("Issue Created");
		WebElement statusColourSelect =
		          driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
		          statusColourSelect.click();

		          WebElement statusColourEnter =
		          driver.findElement(By.xpath("//input[@class='sp-input']"));
		          statusColourEnter.clear(); statusColourEnter.sendKeys("#47963f");

		          Robot r = new Robot();
		          r.keyPress(KeyEvent.VK_ESCAPE);
	
        WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
        firstElement.click();

       
        WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
        secondElement.click();
        

		
		driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
		WebElement addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
	      addCreate.click();

	      Thread.sleep(3000);

	      WebElement moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
	      action.moveToElement(moveTo).build().perform();
	      moveTo.click();
	     
	      Thread.sleep(9000);
	      
	      WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
			action.moveToElement(issue).build().perform();
			
			
	      WebElement make = driver.findElement(By.linkText("Make Default"));
	      make.click();
	      driver.findElement(By.linkText("Priorities")).click();
	      driver.findElement(By.xpath("//header/button[1]")).click();
	      driver.findElement(By.tagName("input")).sendKeys("Assistance required");
	      driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
	      WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));// used css selector 
	      button.click();
	      
Thread.sleep(9000);

WebElement tickets2 = driver.findElement(By.id("ember29"));
action.moveToElement(tickets2).build().perform();
WebElement priorities2 = driver.findElement(By.linkText("Priorities"));
priorities2.click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// We can avoid using multiple implicitly wait because once written it will be consider for whole file.
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")).click(); // we can avoid using absolute xpath's
driver.findElement(By.linkText("Delete")).click();
WebElement delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
delete.click(); //For code optimization need to reduse writing the above code.

Thread.sleep(9000);
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click();  // Avoid absolute xpath
driver.findElement(By.linkText("Logout")).click();

public class PagesforAutomationAssignment //we can only have one public class in one file
{

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver(); // using gecko driver we cant open chrome driver
        driver.get("https://www.happyfox.com");	  //multiple url's we cant open at a need to use window handles

        LoginPage loginPage = new LoginPage(driver);	//Cant create multiple objects in the main as it is multiple inheritance, which is not possible java

        loginPage.login("username", "password");

        HomePage homePage = new HomePage(driver);//Cant create multiple objects in the main as it is multiple inheritance, which is not possible java
        homePage.verifyHomePage();

        driver.quit();
    }

    static class BasePage {
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

    static class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("loginButton")).click();
        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();
        }
    }

    static class HomePage extends BasePage //Cant extends the BasePage as we cant have multiple inheritance in java
 {
        public HomePage(WebDriver driver) {
            super(driver);    //cant call multiple times super to execute constructor
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page"); //This is not correct exception what is used.
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click();
        }

    public class TablePage extends BasePage //Cant extends the BasePage as we cant have multiple inheritance in java
 {

    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");//here need to use FindElement function.

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }




	}

}
