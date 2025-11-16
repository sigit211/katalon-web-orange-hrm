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

public class PIMPage {
	static addEmployeeButton() {
		ObjectFactory.by("addEmployeeButton", "xpath", "//button[contains(.,'Add')]")
	}

	static employeeName() {
		ObjectFactory.by("employeeName", "xpath", "//label[text()='Employee Name']/parent::div//input")
	}

	static employeeId() {
		ObjectFactory.by("employeeId", "xpath", "//label[text()='Employee Id']/parent::div//input")
	}

	static searchButton() {
		ObjectFactory.by("searchButton", "xpath", "//button[@type='submit']")
	}

	static resetButton() {
		ObjectFactory.by("resetButton", "xpath", "//button[@type='reset']")
	}
}
