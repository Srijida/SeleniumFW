package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Constant.constant;
import Pages.GoalTrackingPage;
import utilities.ReadExcelData;

@Listeners(listeners.ListenerTestNG.class)

public class GoalTrackingTest extends BaseTest {
	 LoginTests objLogin;
	 GoalTrackingPage objGoalTrack;
	 
	 @Test(priority=2,retryAnalyzer=retry_analyzer.RetryAnalyzer.class)
	 public void ValidatingGoalTrackingAddedByPassingAllTheTestData() throws IOException, InterruptedException {
		 ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "GoalTrackDetails");
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objGoalTrack=new GoalTrackingPage(driver);
	        objGoalTrack.clickPerformance();
	        objGoalTrack.clickgoaltracking();
	        objGoalTrack.clickaddNew();
	        objGoalTrack.setCompany(excelData.getCellData(1,2));
	        objGoalTrack.setGoalType(excelData.getCellData(1,3));
	        objGoalTrack.setsubject(excelData.getCellData(1,4));
	        objGoalTrack.settarget(excelData.getCellData(1,5));
	        objGoalTrack.selectStartData(excelData.getCellData(1,6), excelData.getCellData(1,7), excelData.getCellData(1,8));
	        objGoalTrack.selectEndDate(excelData.getCellData(1,9), excelData.getCellData(1,10), excelData.getCellData(1,11));
	        objGoalTrack.clicksave();
	        Assert.assertTrue(objGoalTrack.isSaveSuccessMessageDisplayed()); 
	       
	 }
	 @Test(priority=1,retryAnalyzer=retry_analyzer.RetryAnalyzer.class)
	 public void ValidatingGoalTrackingNotAddedByNotPassingAnyTestData() throws IOException, InterruptedException {
		 ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "GoalTrackDetails");
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objGoalTrack=new GoalTrackingPage(driver);
	        objGoalTrack.clickPerformance();
	        objGoalTrack.clickgoaltracking();
	        objGoalTrack.clickaddNew();
	        objGoalTrack.clicksave();
	        Assert.assertTrue(objGoalTrack.isFailureMessageDisplayed()); 
	       
	 }
	 @Test(priority=3,retryAnalyzer=retry_analyzer.RetryAnalyzer.class)
	 public void ValidatingGoalTrackingNotAddedByNotPassingOnlyOneTestData() throws IOException, InterruptedException {
		 ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "GoalTrackDetails");
	        performLogin(excelData.getCellData(1,0),excelData.getCellData(1,1));
	        objGoalTrack=new GoalTrackingPage(driver);
	        objGoalTrack.clickPerformance();
	        objGoalTrack.clickgoaltracking();
	        objGoalTrack.clickaddNew();
	        objGoalTrack.setCompany(excelData.getCellData(1,2));
	        objGoalTrack.clicksave();
	        Assert.assertTrue(objGoalTrack.isFailureMessageDisplayed()); 
	       
	 }

}
