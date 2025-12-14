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

public class DashboardPage {
	static ObjectResult menuDashboard() {
		ObjectFactory.testObject("menuDashboard", "xpath", "//span[text()='Dashboard']")
	}
	static ObjectResult menuAdmin()     {
		ObjectFactory.testObject("menuAdmin", "xpath", "//span[text()='Admin']")
	}
	static ObjectResult menuPIM()       {
		ObjectFactory.testObject("menuPIM", "xpath", "//span[text()='PIM']")
	}
	static ObjectResult menuLeave()     {
		ObjectFactory.testObject("menuLeave", "xpath", "//span[text()='Leave']")
	}
	static ObjectResult menuRecruitment(){
		ObjectFactory.testObject("menuRecruitment","xpath","//span[text()='Recruitment']")
	}
	static ObjectResult menuMyInfo()    {
		ObjectFactory.testObject("menuMyInfo", "xpath", "//span[text()='My Info']")
	}
	static ObjectResult menuTime()      {
		ObjectFactory.testObject("menuTime", "xpath", "//span[text()='Time']")
	}
	static ObjectResult menuMaintenance(){
		ObjectFactory.testObject("menuMaintenance","xpath","//span[text()='Maintenance']")
	}
	static ObjectResult menuClaim()     {
		ObjectFactory.testObject("menuClaim", "xpath", "//span[text()='Claim']")
	}

	static ObjectResult userDropdown() {
		ObjectFactory.testObject("userDropdown", "css", "p.oxd-userdropdown-name")
	}
}
