import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AdminLoginTest {
	@Test
	public void adminLogin() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://school-management-project.vercel.app/");
		driver.findElement(By.xpath("//button[text()='Admin']")).click();
		driver.findElement(By.xpath("(//input[@id='outlined-basic'])[1]")).sendKeys("vimalraj");
		driver.findElement(By.xpath("(//input[@id='outlined-adornment-password'])[1]")).sendKeys("9791");
		driver.findElement(By.xpath("//button[text()='Admin submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='style_teacherslist__+TNUo']")));
		Actions actions = new Actions(driver);
		WebElement teacher = driver.findElement(By.xpath("//div[@id='style_teacherslist__+TNUo']"));
		actions.moveToElement(teacher).perform();
		WebElement teacherList = driver.findElement(By.xpath("//a[@href='/teacherspage']/*[@id='explore']"));
		teacherList.click();
		List<WebElement> allAdminName = driver.findElements(By.xpath("//div[@id='style_card__esKU5']/h1"));
		for(WebElement element : allAdminName) {
			Reporter.log(element.getText(),true);
		}
		driver.quit();
	}
}
