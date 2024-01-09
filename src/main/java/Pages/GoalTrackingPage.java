package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constant.constant;
import utilities.ElementUtility;
import utilities.WaitUtility;

public class GoalTrackingPage {
	WebDriver driver;
	ElementUtility elementutility;
	
	@FindBy (xpath="//a[i[contains(@class, 'fa fa-cube')]]")
	WebElement performance;
	@FindBy (xpath="//a[@href='https://hrm.qabible.in/hrms/admin/goal_tracking']")
	WebElement goaltracking;
	@FindBy (xpath="//button[@class='btn btn-xs btn-primary']")
	WebElement addnew;
	@FindBy(xpath="(//select[@name='company'])")
	WebElement company;
	@FindBy(xpath="(//select[@name='tracking_type'])")
	WebElement goaltype;
	@FindBy(xpath="(//input[@name='subject'])")
	WebElement subject;
	@FindBy(xpath="(//input[@name='target_achiement'])")
	WebElement targetacheivement;
	@FindBy(xpath="(//input[@class='form-control date hasDatepicker'])[1]")
	WebElement startdate;
	@FindBy(xpath="(//input[@class='form-control date hasDatepicker'])[2]")
	WebElement enddate;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	WebElement save;
	
	@FindBy(className = "toast-message")
    WebElement response;

	
	public GoalTrackingPage(WebDriver driver) {
		   this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);
	}
	
	public void clickPerformance(){
		elementutility.clickOnElement(performance);
	}
	public void clickgoaltracking(){
		elementutility.clickOnElement(goaltracking);
	}
	public void clickaddNew() {
    	elementutility.mouseHoverAndClickonElement(addnew);
       elementutility.clickOnElement(addnew);
       WaitUtility.waitForElementToBeClickable(driver, addnew);
    }
	 public void setCompany(String name) {
	     elementutility.selectDrpdown(company, name);
	}
	 public void setGoalType(String name) {
	     elementutility.selectDrpdown(goaltype, name);
    }
	 public void setsubject(String strsub) {   	
	     elementutility.enterText(subject, strsub);
	     WaitUtility.waitForElementToBeVisible(driver, subject);
	 }
	 public void settarget(String strtarget) {   	
	     elementutility.enterText(targetacheivement, strtarget);
	     WaitUtility.waitForElementToBeVisible(driver, targetacheivement);
	 }
	 public void selectStartData(String day, String month, String year) {
	    	elementutility.enterDate(startdate, day, month, year);
	    	
	 }
	 public void selectEndDate(String day, String month, String year) {
	    	elementutility.enterDate(enddate, day, month, year);
	    	
	}
	 public void clicksave(){
			elementutility.clickOnElement(save);
		}
	 public boolean isSaveSuccessMessageDisplayed() {
	        
    	 String Text = response.getText();
    	    String successMessage =constant.SuccessMessageGoal; 
    	    return Text.contains(successMessage);
     }

     public boolean isFailureMessageDisplayed() {
    	 String Text = response.getText();
 	    String failureMessage = constant.FailureMessage; 
 	    return Text.contains(failureMessage);
     }
     

	
	

}
