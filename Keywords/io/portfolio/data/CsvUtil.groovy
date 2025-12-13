package io.portfolio.data

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

public class CsvUtil {
	/**
	 * Read csv file with return Map
	 * println data.get(0).password
	 */
	static List<Map<String, String>> readCsvAsMap(String filePath, String delimiter = ",") {
		File file = new File(filePath)
		if (!file.exists()) {
			throw new IllegalArgumentException("File CSV tidak ditemukan: ${filePath}")
		}

		List<String> lines = file.readLines("UTF-8")
		if (lines.isEmpty()) {
			return []
		}

		List<String> headers = lines[0].split(delimiter)*.trim()
		List<Map<String, String>> result = []

		lines.drop(1).each { line ->
			List<String> values = line.split(delimiter, -1)*.trim()
			Map<String, String> row = [:]

			headers.eachWithIndex { header, idx ->
				row[header] = idx < values.size() ? values[idx] : ""
			}

			result.add(row)
		}

		return result
	}

	/**
	 * Read csv file with return List
	 * println data.get(0)[1]
	 */
	static List<List<String>> readCsvAsList(boolean skipHeader,String filePath, String delimiter = ",") {
		File file = new File(filePath)
		if (!file.exists()) {
			throw new IllegalArgumentException("File CSV tidak ditemukan: ${filePath}")
		}
	
		List<List<String>> result = []
	
		file.readLines("UTF-8").eachWithIndex { line, index ->
			if (skipHeader && index == 0) return
			
			List<String> row = line.split(delimiter, -1)*.trim()
			result.add(row)
		}
	
		return result
	}	
}
