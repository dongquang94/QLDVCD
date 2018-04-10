package createNewUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewUser {

	static WebDriver driver = new ChromeDriver();
	static GetProperties prop = new GetProperties();
	
	@Test(priority=1)
	public void Login() throws IOException{
		System.out.println("--------------Step login start----------------");
		try {			
			
			driver.get(prop.getPropValues("homepage"));
					
			//Login process
			WebElement loginButt = driver.findElement(By.xpath("/html/body/header/nav/div/ul/li/a"));
			loginButt.click();
			Thread.sleep(2000);
			
			WebElement loginPanel = driver.findElement(By.xpath("//*[@id=\"loginModal\"]/div/div"));
			loginPanel.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(prop.getPropValues("username"));
			loginPanel.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(prop.getPropValues("password"));
			Thread.sleep(1000);
			
			WebElement loginButt2 = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));
			loginButt2.click();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("--------------Step login exception----------------");
			Assert.fail();
			e.printStackTrace();
		}
		Assert.assertTrue(true);
		System.out.println("--------------Step login end----------------");
	}
	
	@Test(priority=2)
	public void CreateUser() {
		System.out.println("--------------Step create user start----------------");
		try {		
			
			Thread.sleep(2000);
			
			//Click choose roles
			Select dropdownRoles = new Select(driver.findElement(By.id("roles")));
			dropdownRoles.selectByValue("ROLE_CREATER");
			Thread.sleep(500);
			
			//Click choose info manage 
			WebElement inforManage = driver.findElement(By.xpath("//*[@id='menu']/div[2]/section/ul/li[2]/a/span[1]"));													  
			inforManage.click();
			Thread.sleep(500);
			
			//Click manage unionists button
			WebElement unionistsManage = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/section/ul/li[2]/ul/li[1]/a/span[1]"));
			unionistsManage.click();
			Thread.sleep(500);
			
			//Click uninonist
			WebElement uninonist = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/section/ul/li[2]/ul/li[1]/ul/li[1]/a/span[1]"));
			uninonist.click();
			Thread.sleep(1000);
			
			//Click addMember
			WebElement addMember = driver.findElement(By.xpath("//*[@id=\"create-btn\"]/a[1]"));
			addMember.click();
			Thread.sleep(500);
			
			//Code du lieu sau . Chay duoc full luong truoc. Toi ae minh ngoi ban vu framework
			//Add name 
			WebElement addName = driver.findElement(By.xpath("//*[@id=\"hoten\"]"));
			addName.sendKeys("AUTOMATION TESTING");
			Thread.sleep(500);
			
			//Name 
			WebElement addDoB = driver.findElement(By.xpath("//*[@id=\"ngaysinh\"]"));
			addDoB.sendKeys("01/01/1990");
			Thread.sleep(500);
			
			//Gender //*[@id="registration"]/fieldset/div/div[1]/div[2]/div[3]/div[2]/div/div[2]/input Female
					///*[@id="registration"]/fieldset/div/div[1]/div[2]/div[3]/div[2]/div/div[1]/input Male
			WebElement gender = driver.findElement(By.xpath("//*[@id=\"registration\"]/fieldset/div/div[1]/div[2]/div[3]/div[2]/div/div[1]/input"));
			gender.click();
			Thread.sleep(500);
			
			//IdCardNo: //*[@id="idCard"]
			WebElement idCard = driver.findElement(By.xpath("//*[@id=\"idCard\"]"));
			idCard.sendKeys("001100000001");
			Thread.sleep(500);
			
			//IssuePlace: //*[@id="ngaycap"] ***
			WebElement  issuePlaceBox = driver.findElement(By.xpath("//*[@id=\"select2-noicap-container\"]"));
			issuePlaceBox.click();
			WebElement searchBox = driver.findElement(By.xpath("/html/body/span/span/span[1]/input")); // dang dung duong dan tuyet doi khong on lam
			searchBox.sendKeys("Hà Nội");
			issuePlaceBox.click();
			Thread.sleep(500);
			
			//JoinDate 
			WebElement joinDate = driver.findElement(By.xpath("//*[@id=\"ngayvaodoan\"]"));
			joinDate.sendKeys("01/01/2009");
			Thread.sleep(500);
			
			//CDCS same issuePlace
			
			//Save Button  //*[@id="save"]
			WebElement save = driver.findElement(By.xpath("//*[@id=\"save\"]"));
			save.click();
			Thread.sleep(500);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("--------------Step create user exception----------------");
			Assert.fail();
			e.printStackTrace();
		}
		Assert.assertTrue(true);;
		System.out.println("--------------Step create user end----------------");
	}
}