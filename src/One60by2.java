import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class One60by2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String s=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", s+"\\Chrome090615\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();*/
		FirefoxDriver driver=new FirefoxDriver();
		try{
			driver.manage().window().maximize();
			driver.get("http://www.160by2.com/Index");
			driver.findElement(By.id("username")).sendKeys("9426576315");
			driver.findElement(By.id("password")).sendKeys("08moth42");
			Thread.sleep(2000);
			driver.findElementByXPath("//*[@id='loginform']/div/section/div/div[1]/div[3]/div[3]/button").click();
			System.out.println("logged in");
			String number[]={"9426576315","8469212091"};
			/*boolean fm=driver.findElementByXPath("//*[@id='by2Frame']").isDisplayed();
			System.out.println(fm);
			System.out.println("in the by2frame");*/
			Random rn=new Random();
			int num=rn.nextInt(5)+1;
			System.out.println("Random number is "+num);
			driver.switchTo().frame(driver.findElementByXPath("//*[@id='by2Frame']"));
			boolean dep=driver.findElementByClassName("da-sms-btn").isDisplayed();
			System.out.println(dep);
			driver.findElementByClassName("da-sms-btn").click();
			System.out.println("button cliecked");
			
			for(int i=0; i<number.length; i++)
			{
			Thread.sleep(3000);
			driver.findElementByXPath("/html/body/form/div/div[3]/div[1]/div[1]/div[1]/p[2]/input").sendKeys("");
			driver.findElementByXPath("/html/body/form/div/div[3]/div[1]/div[1]/div[1]/p[2]/input").sendKeys(number[i]);
			//driver.findElementByXPath("/html/body/form/div/div[3]/div[1]/div[1]/div[2]/textarea").sendKeys("This is just a test message for you");
			Thread.sleep(4000);
			driver.findElementByXPath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/ul/li["+num+"]/a").click();
			Thread.sleep(3000);
			driver.findElementByXPath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/ul/li["+num+"]/a").click();
			
			String text=driver.findElementByXPath("/html/body/form/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/ul/li["+num+"]/a").getText();
			
			Thread.sleep(2000);
			//System.out.println("After 2 secs");
			driver.findElementByXPath("/html/body/form/div/div[3]/div[1]/input[1]").click();
			System.out.println("After sent \n");
			System.out.println(text+"\n==========");
			Thread.sleep(4000);
			WebElement we=(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/section/div[1]/div/input[1]")));
			System.out.println("After 5 secs \n");
			driver.findElementByXPath("/html/body/form/div[1]/section/div[1]/div/input[1]").click();
			Thread.sleep(3000);
			}
		}catch(Exception e){
			
		}
	}

}
