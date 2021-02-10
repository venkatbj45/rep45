package ddfDemos;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDFEbayProdSearchTest 
{
  @Test(dataProvider = "ebayData")
  public void ProdSearch(String ddValue,String txtValue) 
  {
	  WebDriverManager.chromedriver().version("87").setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
	  
	  driver.findElement(By.id("gh-ac")).sendKeys(txtValue);
	  driver.findElement(By.id("gh-btn")).click();
	  
	  Reporter.log("'" + txtValue + "' Product Search Test is Successful..",true);
  }

  @DataProvider
  public Object[][] ebayData() throws Exception
  {
	  Object[][] myData=null;
	  
	  XSSFWorkbook wb=new XSSFWorkbook("D:\\Google Drive\\QA @6PM IST(30Sep2020)\\Selenium\\Programs\\mvnDemo\\src\\test\\resources\\DDFEbayInput.xlsx");
	  XSSFSheet ws=wb.getSheet("Sheet1");
	  int rows=ws.getPhysicalNumberOfRows();
	  
	  myData=new Object[rows][2];
	  
	  for(int i=0;i<myData.length;i++)
	  {
		  myData[i][0]=ws.getRow(i).getCell(0).getStringCellValue();
		  myData[i][1]=ws.getRow(i).getCell(1).getStringCellValue();
	  }
	  
	  return myData;
  }
}
