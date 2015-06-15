import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Way2SMS_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", s+"\\Chrome090615\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			//FirefoxDriver driver=new FirefoxDriver();
			try{
				driver.manage().window().maximize();
			driver.get("http://site21.way2sms.com/content/index.html");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementByXPath("//*[@id='username']").sendKeys("9426576315");
			driver.findElementByXPath("//*[@id='password']").sendKeys("8051");
			driver.findElementByXPath("//*[@id='loginBTN']").click();
			
			//driver.findElement(By.id("ebFrm")).click();
			System.out.println("Waiting for 5 secs");
			WebElement we=(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("ebFrm")));
			System.out.println(we.isDisplayed());
			if(we.isDisplayed()==true){
				//driver.findElement(By.id("ebFrm")).click();
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@id='ebFrm']/div[2]/div[1]/input").click();	
				System.out.println("WE cliekded");
				}else{
					System.out.println("Not found");
					new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("ebFrm")));
				}
			
			driver.findElementByXPath("//*[@id='sendSMS']/a").click();
			System.out.println("Sent sms Clicked ");
			driver.switchTo().frame(driver.findElementByXPath("//*[@id='frame']"));
			
			String numbers[]={"8469212091","9426576315"};///{"8866685998","9998004440"};
			Random rn=new Random();
			for(int i=0; i<numbers.length; i++)
			{
			WebElement mb=driver.findElement(By.id("mobile"));
			boolean disp=mb.isDisplayed();
			//System.out.println(disp);
			mb.sendKeys(numbers[i]);
			int num=rn.nextInt(4)+1;
			Thread.sleep(3000);
			//System.out.println(num);
			driver.findElementByXPath("//*[@id='smsGreetsPaging']/ol/li["+num+"]").click();
			System.out.println("clicked option numbers :"+num+"\n================");
			Thread.sleep(4000);
			WebElement cs=driver.findElementByXPath("//*[@id='greet"+num+"']");
			System.out.println(cs.getText()+"\n================");
			driver.findElementByXPath("//*[@id='greet"+num+"']").click();
			driver.findElementByXPath("//*[@id='Send']").click();
			System.out.println("Message sent to "+numbers[i]);
			Thread.sleep(2000);
			driver.findElementByXPath("/html/body/form/div[1]/div/p[1]").click();
			Thread.sleep(3000);
			}
			
			/*String tk =driver.findElement(By.id("Token")).getAttribute("value");
			System.out.println(tk);*/
			
			
			
			/*WebElement mo=(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mobile")));
			System.out.println("after 15 secs");
			boolean dis=mo.isDisplayed();
			System.out.println(dis);*/
								
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
	}

}
