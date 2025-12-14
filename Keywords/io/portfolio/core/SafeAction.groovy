package io.portfolio.core

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.nio.file.Files
import java.nio.file.Paths

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

class SafeAction {

	/* ================= CONFIG ================= */

	static final int DEFAULT_TIMEOUT = GlobalVariable.DEFAULT_TIMEOUT
	static final int DEFAULT_RETRY = GlobalVariable.DEFAULT_RETRY
	static final int RETRY_INTERVAL_MS = GlobalVariable.RETRY_INTERVAL_MS

	/* ================= CORE RETRY ENGINE ================= */

	private static void executeWithRetry(String actionName, TestObject to, int retry, Closure action) {
		int attempt = 0
		Exception lastException = null

		while (attempt < retry) {
			try {
				action.call()
				return
			} catch (Exception e) {
				attempt++
				lastException = e
				KeywordUtil.logInfo(
						"[SafeAction][$actionName] Retry $attempt/$retry - ${getObjectName(to)}"
						)

				if (attempt >= retry) {
					WebUI.takeScreenshot(FailureHandling.OPTIONAL)
					throw new StepFailedException(
					"[SafeAction][$actionName] FAILED after $retry retries - ${getObjectName(to)}",
					e
					)
				}
				Thread.sleep(RETRY_INTERVAL_MS)
			}
		}
	}

	private static String getObjectName(TestObject to) {
		return to?.getObjectId() ?: "UnknownObject"
	}

	/* ================= BASIC ACTIONS ================= */

	static void click(TestObject to,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		executeWithRetry("CLICK", to, retry) {
			WebUI.waitForElementClickable(to, timeout)
			WebUI.click(to)
		}
	}

	static void setText(TestObject to,
			String text,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		executeWithRetry("SET_TEXT", to, retry) {
			WebUI.waitForElementVisible(to, timeout)
			WebUI.clearText(to, FailureHandling.OPTIONAL)
			WebUI.setText(to, text)
		}
	}

	static void sendKeys(TestObject to,
			String text,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		executeWithRetry("SEND_KEYS", to, retry) {
			WebUI.waitForElementVisible(to, timeout)
			WebUI.sendKeys(to, text)
		}
	}

	static String getText(TestObject to,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		String result = ""

		executeWithRetry("GET_TEXT", to, retry) {
			WebUI.waitForElementVisible(to, timeout)
			result = WebUI.getText(to)
		}
		return result
	}

	/* ================= SCREENSHOOT ================= */
	static void takeScreenshotSafe(String fileName, 
		int retry = DEFAULT_RETRY) {
		String fullPath = Paths.get(fileName).toAbsolutePath().toString()
		
		int attempt = 0
		while (attempt < retry) {
			try {
				WebUI.takeScreenshot(fullPath, FailureHandling.OPTIONAL)
				KeywordUtil.logInfo("[SafeAction][SCREENSHOT] Success ($fullPath) attempt ${attempt + 1}/$retry")
				return
			} catch (Exception e) {
				attempt++
				KeywordUtil.logInfo("[SafeAction][SCREENSHOT] Failed ($fullPath) attempt $attempt/$retry : ${e.message}")
				Thread.sleep(RETRY_INTERVAL_MS)
			}
		}
	
		KeywordUtil.logInfo("[SafeAction][SCREENSHOT] Giving up after $retry attempts ($fullPath)")
	}
		
	/* ================= VERIFY (NO DIRECT FAIL) ================= */

	static boolean verifyVisible(TestObject to,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		int attempt = 0
		while (attempt < retry) {
			try {
				return WebUI.waitForElementVisible(to, timeout)
			} catch (Exception e) {
				attempt++
				KeywordUtil.logInfo(
						"[SafeAction][VERIFY_VISIBLE] Retry $attempt/$retry - ${getObjectName(to)}"
						)
				Thread.sleep(RETRY_INTERVAL_MS)
			}
		}
		return false
	}

	static boolean verifyClickable(TestObject to,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		int attempt = 0
		while (attempt < retry) {
			try {
				return WebUI.waitForElementClickable(to, timeout)
			} catch (Exception e) {
				attempt++
				Thread.sleep(RETRY_INTERVAL_MS)
			}
		}
		return false
	}

	/* ================= WAIT ONLY ================= */

	static void waitVisible(TestObject to,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		executeWithRetry("WAIT_VISIBLE", to, retry) {
			WebUI.waitForElementVisible(to, timeout)
		}
	}

	static void waitVisibleOrFail(TestObject to,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		executeWithRetry("WAIT_VISIBLE_OR_FAIL", to, retry) {
			boolean visible = WebUI.waitForElementVisible(to, timeout)
			if (!visible) {
				throw new StepFailedException(
				"Element tidak visible setelah ${timeout}s"
				)
			}
		}
	}

	static void waitClickable(TestObject to,
			int timeout = DEFAULT_TIMEOUT,
			int retry = DEFAULT_RETRY) {

		executeWithRetry("WAIT_CLICKABLE", to, retry) {
			WebUI.waitForElementClickable(to, timeout)
		}
	}
}	