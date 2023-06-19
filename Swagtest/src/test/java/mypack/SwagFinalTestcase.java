package mypack;



import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;





public class SwagFinalTestcase {
  private WebDriver driver;
  

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    
            



  }

  @Test
  public void testSwagFinalTestcase() throws Exception {
   
   //Navigate to the page
	  
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
    
    // Assertion for Step 1: Verify the user is in the sauce demo page.
    WebElement homeTab = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
    String actualTabName = homeTab.getText();
    Assert.assertEquals(actualTabName, "Swag Labs");


    
    
 // Verify whether the user is unable to login to the page when entering an incorrect username and password.

    

    Thread.sleep(2000);

    driver.findElement(By.id("user-name")).click();

    driver.findElement(By.id("user-name")).sendKeys("standard_user");

    driver.findElement(By.id("password")).click();

    driver.findElement(By.id("password")).sendKeys("abcd");

    driver.findElement(By.id("login-button")).click();

    Thread.sleep(2000);
    
    WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
    String actualErrorMessage = errorMessage.getText();
    Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");

    

    driver.findElement(By.id("user-name")).click();

    driver.findElement(By.id("user-name")).clear();

    driver.findElement(By.id("user-name")).sendKeys("abcd");

    driver.findElement(By.id("password")).click();

    driver.findElement(By.id("password")).clear();

    driver.findElement(By.id("password")).sendKeys("secret_sauc");

    driver.findElement(By.id("login-button")).click();

    Thread.sleep(2000);
    Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");

    

    // Verify whether the user can able to login to the page when entering an correct username and password.

    

    driver.findElement(By.id("user-name")).click();

    driver.findElement(By.id("user-name")).clear();

    driver.findElement(By.id("user-name")).sendKeys("standard_user");

    driver.findElement(By.id("password")).click();

    driver.findElement(By.id("password")).clear();

    driver.findElement(By.id("password")).sendKeys("secret_sauce");

    driver.findElement(By.id("login-button")).click();

    Thread.sleep(2000);
    WebElement swagpage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]"));
    String actualswagpage = swagpage.getText();
    Assert.assertEquals(actualswagpage, "Swag Labs");



    
    // Sort the products in price low to high order 

    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
    Thread.sleep(3000);
    
    //Verify the filter label set to price low to high
    
    WebElement filterlabel = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/span"));
    String actualfilterlabel = filterlabel.getText();
    Assert.assertEquals(actualfilterlabel, "Price (low to high)");
  
  //Add all items to the cart 

    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    Thread.sleep(3000);
    
    // Verify the all items added to the cart by its count
    WebElement shoppingcart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
    String actualshoppingcartbadge = shoppingcart.getText();
    Assert.assertEquals(actualshoppingcartbadge, "6");
    
  
    
    //Go to the Cart page

    driver.findElement(By.linkText("6")).click();
    Thread.sleep(3000);
    
    // Verify the user is in the cart page
    
    WebElement yourcart = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]"));
    String actualyourcart = yourcart.getText();
    Assert.assertEquals(actualyourcart, "Your Cart");
    
   
  //Remove items that have a price <$15 
    driver.findElement(By.id("remove-sauce-labs-onesie")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    
    //Verify two items are remove by checking the count in the cart logo
    
    WebElement cartlogonumber = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
    String actualcartlogonumber = cartlogonumber.getText();
    Assert.assertEquals(actualcartlogonumber, "4");
    
    
    
  //click on the Checkout button 
    
    driver.findElement(By.id("checkout")).click();
    
    // Verify the user is in the information page
    WebElement informationpage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    String actualinformationpage = informationpage.getText();
    Assert.assertEquals(actualinformationpage, "Checkout: Your Information");
    
    //Enter the details on your information page  

    driver.findElement(By.id("first-name")).click();
    driver.findElement(By.id("first-name")).sendKeys("Anagha");
    driver.findElement(By.id("last-name")).click();
    driver.findElement(By.id("last-name")).sendKeys("M R");
    driver.findElement(By.id("postal-code")).click();
    driver.findElement(By.id("postal-code")).sendKeys("695541");
    
    //Click on the Continue button
    
    Thread.sleep(2000);
    driver.findElement(By.id("continue")).click();
  
    //Verify the user is in the overview page
    WebElement overviewpage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    String actualoverviewpage = overviewpage.getText();
    Assert.assertEquals(actualoverviewpage, "Checkout: Overview");
    
    //Finish the checkout by clicking the Finish button 
    Thread.sleep(1000);
    driver.findElement(By.id("finish")).click();
    
    //Verify user is in the Complete page
    WebElement completepage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    String actualcompletepage = completepage.getText();
    Assert.assertEquals(actualcompletepage, "Checkout: Complete!");
    
   //Return to the home page 

    Thread.sleep(1000);
    driver.findElement(By.id("back-to-products")).click();
    
    //Verify the user is in the home page
    WebElement productpage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    String actualproductpage = productpage.getText();
    Assert.assertEquals(actualproductpage, "Products");
    
    //Perform logout 

    Thread.sleep(1000);
    driver.findElement(By.id("react-burger-menu-btn")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("logout_sidebar_link")).click();
    
    //Verify the user reach in the login page again
   
    WebElement loginpage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
    String actualloginpage = loginpage.getText();
    Assert.assertEquals(actualloginpage, "Swag Labs");
    
    driver.quit();

    
  }

}
