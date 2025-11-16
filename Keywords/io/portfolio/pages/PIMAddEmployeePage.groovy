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

public class PIMAddEmployeePage {
	static firstName() { ObjectFactory.by("firstName", "xpath", "//input[@name='firstName']") }
	static middleName(){ ObjectFactory.by("middleName","xpath","//input[@name='middleName']") }
	static lastName()  { ObjectFactory.by("lastName",  "xpath", "//input[@name='lastName']") }

	static employeeId() {
		ObjectFactory.by("employeeId", "xpath", "(//input[@class='oxd-input oxd-input--active'])[2]")
	}

	static saveButton() {
		ObjectFactory.by("saveButton", "xpath", "//button[@type='submit']")
	}
}
