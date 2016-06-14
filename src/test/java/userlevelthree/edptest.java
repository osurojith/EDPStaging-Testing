package userlevelthree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class edptest {
	WebDriver webDriver;
	String IRID="MY010003";
	String vipID="317444";
	String chequeName=null;
	@DataProvider
	public Object[][] getData() {
		return new Object[][]{{"vk_Thili","1qaz2wsx"}};
	}
	@BeforeClass
	public void setDriver(){
		webDriver=new FirefoxDriver();
		webDriver.get("https://global.qntest.com/EDPSite/");
	}
	@Test(dataProvider="getData")
	public void loginTest(String username,String password){
		WebElement user=(WebElement)webDriver.findElement(By.xpath(".//*[@id='loginname']"));
		WebElement pass=(WebElement)webDriver.findElement(By.xpath(".//*[@id='password']"));
		WebElement loginbtn=(WebElement)webDriver.findElement(By.xpath(".//*[@id='Button1']"));
		user.sendKeys(username);
		pass.sendKeys(password);
		loginbtn.click();
	}
	@Test
	public void vipAccess() throws InterruptedException{
		WebElement vip=(WebElement)webDriver.findElement(By.xpath(".//*[@id='TextBox1']"));
		WebElement btn=(WebElement)webDriver.findElement(By.xpath(".//*[@id='btnsubmit']"));
		vip.sendKeys(vipID);
		btn.click();
		Thread.sleep(25000);
	}
	@Test
	public void searchIRID() throws InterruptedException{
		
		
		System.out.println(webDriver.getCurrentUrl());
		WebElement IRId=(WebElement)webDriver.findElement(By.id("txtTCO"));
		WebElement searchbtn=(WebElement)webDriver.findElement(By.id("btnsearch"));
		IRId.sendKeys(IRID);
		searchbtn.click();
		Thread.sleep(5000);
	}
	@Test
	public void varifyIRID(){
		WebElement IRId=(WebElement)webDriver.findElement(By.xpath(".//*[@id='lbTCO']"));
		Assert.assertEquals(IRId.getText(), IRID);
	}
	@Test
	public void getName(){
		WebElement cheque=(WebElement)webDriver.findElement(By.xpath(".//*[@id='lbCheque']"));
		chequeName=cheque.getText();
	}
	@Test
	public void navigateChequeList(){
		WebElement CommissionInformation=(WebElement)webDriver.findElement(By.xpath(".//*[@id='Menu1-menuItem001']"));
		WebElement CoinandChequesList=(WebElement)webDriver.findElement(By.xpath(".//*[@id='Menu1-menuItem001-subMenu-menuItem001']"));
		WebElement ByIr=(WebElement)webDriver.findElement(By.xpath(".//*[@id='Menu1-menuItem001-subMenu-menuItem001-subMenu-menuItem000']"));
		CommissionInformation.click();
		CoinandChequesList.click();
		ByIr.click();
	}
}
