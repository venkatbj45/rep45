package pomPages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ClsTestData 
{
	public static Object[][] getExcelData(String fPath) throws Exception
	{
		 Object[][] eData=null;
		  
		  XSSFWorkbook wb=new XSSFWorkbook(fPath);
		  XSSFSheet ws=wb.getSheet("Sheet1");
		  int rows=ws.getPhysicalNumberOfRows();
		  
		  eData=new Object[rows][2];
		  
		  for(int i=0;i<rows;i++)
		  {
			  eData[i][0]=ws.getRow(i).getCell(0).getStringCellValue();
			  eData[i][1]=ws.getRow(i).getCell(1).getStringCellValue();
		  }
		  
		  return eData;
	}
}
