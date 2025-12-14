package io.portfolio.core

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

class StringUtil {
    /**
     * Ambil string setelah karakter tertentu
     * contoh: "Username : Admin" -> "Admin"
     */
    @Keyword
    static String after(String text, String delimiter) {
        if (!text || !delimiter) return ""
        int index = text.indexOf(delimiter)
        if (index == -1) return ""
        return text.substring(index + delimiter.length()).trim()
    }

    /**
     * Ambil string sebelum karakter tertentu
     * contoh: "Username : Admin" -> "Username"
     */
    @Keyword
    static String before(String text, String delimiter) {
        if (!text || !delimiter) return ""
        int index = text.indexOf(delimiter)
        if (index == -1) return ""
        return text.substring(0, index).trim()
    }

    /**
     * Ambil string di antara 2 karakter
     * contoh: "[Admin]" -> "Admin"
     */
    @Keyword
    static String between(String text, String start, String end) {
        if (!text) return ""
        int startIdx = text.indexOf(start)
        int endIdx = text.indexOf(end, startIdx + start.length())
        if (startIdx == -1 || endIdx == -1) return ""
        return text.substring(startIdx + start.length(), endIdx).trim()
    }

    /**
     * Ambil hanya angka
     * contoh: "Total : Rp 1.250.000" -> "1250000"
     */
    @Keyword
    static String numbersOnly(String text) {
        if (!text) return ""
        return text.replaceAll("[^0-9]", "")
    }

    /**
     * Ambil hanya huruf
     * contoh: "User123" -> "User"
     */
    @Keyword
    static String lettersOnly(String text) {
        if (!text) return ""
        return text.replaceAll("[^a-zA-Z]", "")
    }

    /**
     * Normalisasi spasi
     * contoh: " Admin   User  " -> "Admin User"
     */
    @Keyword
    static String normalizeSpace(String text) {
        if (!text) return ""
        return text.trim().replaceAll("\\s+", " ")
    }
}
