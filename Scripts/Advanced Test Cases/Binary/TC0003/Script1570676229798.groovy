import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://www.random.org/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Random/input_Min_true-random-integer-generator-min'), '0')

WebUI.setText(findTestObject('Page_Random/input_Max_true-random-integer-generator-max'), '4')

WebUI.click(findTestObject('Page_Random/input_Max_true-random-integer-generator-button'))

WS.delay(GlobalVariable.Timeout_Short)

numberGenerated = WebUI.getText(findTestObject('Page_Random/span_result'))

integerGenerated = Integer.parseInt(numberGenerated)

integerGenerated += 1

WebUI.setText(findTestObject('Page_Random/input_Max_true-random-integer-generator-max'), ((String)integerGenerated))

WebUI.click(findTestObject('Page_Random/input_Max_true-random-integer-generator-button'))

WS.delay(GlobalVariable.Timeout_Short)

