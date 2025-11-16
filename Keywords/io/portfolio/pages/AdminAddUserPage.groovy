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

public class AdminAddUserPage {
	static userRole() {
		ObjectFactory.by("userRole", "xpath", "//label[text()='User Role']/parent::div//div[contains(@class,'oxd-select-text')]")
	}

	static employeeName() {
		ObjectFactory.by("employeeName", "xpath", "//input[@placeholder='Type for hints...']")
	}

	static status() {
		ObjectFactory.by("status", "xpath", "//label[text()='Status']/parent::div//div[contains(@class,'oxd-select-text')]")
	}

	static username() {
		ObjectFactory.by("username", "xpath", "(//input[@class='oxd-input oxd-input--active'])[2]")
	}

	static password() {
		ObjectFactory.by("password", "xpath", "(//input[@type='password'])[1]")
	}

	static confirmPassword() {
		ObjectFactory.by("confirmPassword", "xpath", "(//input[@type='password'])[2]")
	}

	static saveButton() {
		ObjectFactory.by("saveButton", "xpath", "//button[@type='submit']")
	}

	static cancelButton() {
		ObjectFactory.by("cancelButton", "xpath", "//button[contains(.,'Cancel')]")
	}
}
