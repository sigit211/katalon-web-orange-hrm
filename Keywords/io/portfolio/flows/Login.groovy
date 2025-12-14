package io.portfolio.flows

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.portfolio.core.BrowserKeywords
import io.portfolio.core.SafeAction
import io.portfolio.core.StringUtil
import io.portfolio.pages.DashboardPage
import io.portfolio.pages.LoginPage

public class Login {
	static void loginWithUserData(String username, String password, String testcaseName) {
		SafeAction.sendKeys(LoginPage.username().testObject, username)
		SafeAction.sendKeys(LoginPage.password().testObject, password)
		SafeAction.takeScreenshotSafe("$testcaseName/login pic-1.png")
		SafeAction.click(LoginPage.loginButton().testObject)
		SafeAction.waitVisibleOrFail(DashboardPage.menuDashboard().testObject)
		SafeAction.takeScreenshotSafe("$testcaseName/login pic-2.png")
	}
	
	static void loginWithGetUserData(String testcaseName) {
		String getUsername = StringUtil.after(SafeAction.getText(LoginPage.demoUsernameText().testObject), ":")
		String getPassword = StringUtil.after(SafeAction.getText(LoginPage.demoPasswordText().testObject), ":")

		SafeAction.sendKeys(LoginPage.username().testObject, getUsername)
		SafeAction.sendKeys(LoginPage.password().testObject, getPassword)
		SafeAction.takeScreenshotSafe("$testcaseName/login pic-1.png")
		SafeAction.click(LoginPage.loginButton().testObject)
		SafeAction.waitVisibleOrFail(DashboardPage.menuDashboard().testObject)
		SafeAction.takeScreenshotSafe("$testcaseName/login pic-2.png")
	}
}
