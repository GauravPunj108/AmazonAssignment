/*
 * This is Listener class which will implement in build iTestListener interface which has the various methods.
 * This class extends testUtils which has the screenshot method which will be utilized for Test pass and fail events.
 * Author: Gaurav Punj
 */

package testPackage;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.testUtils;

public class ListenerTest extends testUtils implements ITestListener {

	// When Test case get started, this method is called.
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getName());

	}

	// When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception f) {
			f.printStackTrace();
		}

	}

	// When Test case get failed, this method is called.
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception f) {
			f.printStackTrace();
		}

	}

	// When Test case get skipped, this method is called.
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
