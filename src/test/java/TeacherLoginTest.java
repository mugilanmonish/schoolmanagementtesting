import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TeacherLoginTest {
	@Test
	public void adminLogin() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://school-management-project.vercel.app/");
		driver.findElement(By.xpath("//button[text()='Students']")).click();
		driver.findElement(By.xpath("(//input[@id='outlined-basic'])[3]")).sendKeys("balaji@gmail.com");
		driver.findElement(By.xpath("(//input[@id='outlined-adornment-password'])[3]")).sendKeys("balaji123!@#");
		driver.findElement(By.xpath("//button[text()='Students submit']")).click();
		Thread.sleep(2000);
		WebElement studentName = driver.findElement(By.xpath("//div[contains(@id,'style_card')]/h1"));
		Reporter.log(studentName.getText(),true);
		driver.quit();
	}
}
