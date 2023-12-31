package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.TrainingPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class TrainingTest extends BaseTest {
	LoginPage objLogin;
	TrainingPage objtaining;
	 
	  @Test(priority=1,retryAnalyzer=retry_analyzer.RetryAnalyzer.class)
	    public void ValidatingTheTrainingTypeNotSavedWithoutPassingAnyDataInTheFeilds() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Training");	       
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objtaining=new TrainingPage(driver);
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();    
	        objtaining.clicksave();
	        Assert.assertTrue(objtaining.isFailureMessageDisplayed());       
	
}

	 @Test(priority=2,retryAnalyzer=retry_analyzer.RetryAnalyzer.class)
	    public void ValidatingTrainingTestSavedDtailsByPassingAllTheDatas() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Training");
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objtaining=new TrainingPage(driver);
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();
	        objtaining.strtraintypename(excelData.getCellData(1,2));	     
	        objtaining.clicksave();
	        Assert.assertTrue(objtaining.isSaveSuccessMessageDisplayed());          
	
}
}
