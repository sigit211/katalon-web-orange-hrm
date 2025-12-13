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
import io.portfolio.pages.DashboardPage
import io.portfolio.pages.LoginPage

public class LoginKeywords {
	/**
	 * Hanya melakukan login (tanpa open browser)
	 */
	static void login(String username, String password) {
		SafeAction.sendKeys(LoginPage.username().testObject, username)
		SafeAction.sendKeys(LoginPage.password().testObject, password)
		SafeAction.click(LoginPage.loginButton().testObject)
		SafeAction.waitVisibleOrFail(DashboardPage.menuDashboard().testObject)
	}

	/**
	 * Full login sequence: open login page + login
	 */
	static void loginToApp(String username, String password) {
		BrowserKeywords.openLoginPage()
		login(username, password)
	}
}
