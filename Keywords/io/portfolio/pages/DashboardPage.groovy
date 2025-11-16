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

public class DashboardPage {
	static menuDashboard() { ObjectFactory.by("menuDashboard", "xpath", "//span[text()='Dashboard']") }
	static menuAdmin()     { ObjectFactory.by("menuAdmin", "xpath", "//span[text()='Admin']") }
	static menuPIM()       { ObjectFactory.by("menuPIM", "xpath", "//span[text()='PIM']") }
	static menuLeave()     { ObjectFactory.by("menuLeave", "xpath", "//span[text()='Leave']") }
	static menuRecruitment(){ ObjectFactory.by("menuRecruitment","xpath","//span[text()='Recruitment']") }
	static menuMyInfo()    { ObjectFactory.by("menuMyInfo", "xpath", "//span[text()='My Info']") }
	static menuTime()      { ObjectFactory.by("menuTime", "xpath", "//span[text()='Time']") }
	static menuMaintenance(){ ObjectFactory.by("menuMaintenance","xpath","//span[text()='Maintenance']") }
	static menuClaim()     { ObjectFactory.by("menuClaim", "xpath", "//span[text()='Claim']") }

	static userDropdown() {
		ObjectFactory.by("userDropdown", "css", "p.oxd-userdropdown-name")
	}
}
