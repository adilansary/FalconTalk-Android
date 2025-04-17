package com.FalconTalk.Config;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.FalconTalk.PageObject.Common.Common;

public class TestListener implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		try {
			Activity.AndroidLaunchApp();
			Common common = new Common();
			common.AgreeAndContinue();
			Thread.sleep(2000);
			common.UserTypeAndExtension();
			Thread.sleep(2000);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
