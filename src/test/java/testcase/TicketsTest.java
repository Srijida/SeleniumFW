package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.LoginPage;
import Pages.TicketPage;
import utilities.ReadExcelData;
@Listeners(listeners.ListenerTestNG.class)
public class TicketsTest extends BaseTest{
	LoginPage objLogin;
	TicketPage objticket;
	
 @Test(priority=1,retryAnalyzer=retry_analyzer.RetryAnalyzer.class)
	    public void ValidatingTicketsIssuedToStaffIsSaved() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Tickets");
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objticket=new TicketPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname(excelData.getCellData(1,2));
	        objticket.strsub( excelData.getCellData(1,3));
	        objticket.stremp_ticket(excelData.getCellData(1,4));
	        objticket.strpriority(excelData.getCellData(1,5));
	        objticket.clicksave();
	        Assert.assertTrue(objticket.isSaveSuccessMessageDisplayed());  
	
}
	
	 @Test(priority=2)
	    public void ValidatingTicketsTestNotSavedWithoutPassingAnyData() throws InterruptedException, IOException {
	        ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH,"Tickets");
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objticket=new TicketPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname(excelData.getCellData(1,2));
	        objticket.strsub( excelData.getCellData(1,3));
	        objticket.clicksave();
	        Assert.assertTrue(objticket.isFailureMessageDisplayed());  
	
}
	

	
}
