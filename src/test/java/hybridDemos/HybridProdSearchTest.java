package hybridDemos;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.BrowserFactory;
import pomPages.ClsEbay;
import pomPages.ClsTestData;

public class HybridProdSearchTest {
	 @Test(dataProvider = "ebayData")
	  public void ProdSearch(String ddValue,String txtValue) 
	  {
		  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://ebay.com");
		  
		  ClsEbay obj=new ClsEbay(driver);
		  obj.fnSearch(txtValue);
		  
		  Reporter.log("'" + txtValue + "' Product Search Test is Successful..",true);
	  }

	  @DataProvider
	  public Object[][] ebayData() throws Exception
	  {
		  Object[][] myData=ClsTestData.getExcelData("D:\\Google Drive\\QA @6PM IST(30Sep2020)\\Selenium\\Programs\\mvnDemo\\src\\test\\resources\\DDFEbayInput.xlsx");
		  return myData;
	  }
	}
