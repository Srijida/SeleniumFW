package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testcase.BaseTest;
import utilities.ExtentUtility;

public class ListenerTestNG extends BaseTest implements ITestListener{
    ExtentReports extent = ExtentUtility.createextentreport();
    
    public static ExtentTest test;
    

    public void onTestStart(ITestResult result) {
        System.out.println("Test case :"+result.getName());
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case passed :"+result.getName());
        test.log(Status.PASS, "Test case passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test case failed :"+result.getName());

        test.fail(result.getThrowable());
    }


    public void onTestSkipped(ITestResult result) {

    }


    public void onStart(ITestContext context) {
        System.out.println("Execution started :"+context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Execution finished :"+context.getName());
        extent.flush();
    }
}
