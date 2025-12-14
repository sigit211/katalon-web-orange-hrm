package io.portfolio.pages

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
import io.portfolio.core.ObjectFactory
import io.portfolio.core.ObjectFactory.ObjectResult

public class LoginPage {
	static ObjectResult username() {
		ObjectFactory.testObject("username", "xpath", "//input[@name='username']")
	}

	static ObjectResult password() {
		ObjectFactory.testObject("password", "xpath", "//input[@name='password']")
	}

	static ObjectResult loginButton() {
		ObjectFactory.testObject("loginButton", "xpath", "//button[@type='submit']")
	}

	static ObjectResult errorMessage() {
		ObjectFactory.testObject("errorMessage", "css", "p.oxd-alert-content-text")
	}

	static ObjectResult demoUsernameText() {
		ObjectFactory.testObject("demoUsernameText", "xpath", "//div[contains(@class,'orangehrm-demo-credentials')]/p[1]")
	}

	static ObjectResult demoPasswordText() {
		ObjectFactory.testObject("demoPasswordText", "xpath", "//div[contains(@class,'orangehrm-demo-credentials')]/p[2]")
	}
}
