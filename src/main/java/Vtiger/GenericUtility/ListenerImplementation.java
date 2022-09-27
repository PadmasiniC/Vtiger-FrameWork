package Vtiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * This class provides implementation to all the methods in ITestListener Interface
 * @author Padmasini
 *
 */
public class ListenerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"-> sucessfully started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"-> Sucessfully completed test", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"-> test failed", true);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"-> test skipped", true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname, true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname, true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Execution started", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Execution completed", true);
	}
}
