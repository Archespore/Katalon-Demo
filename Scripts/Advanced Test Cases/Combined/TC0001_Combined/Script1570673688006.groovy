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

WebUI.openBrowser(GlobalVariable.ENV)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Page_Landing/a_Make Appointment'))

WebUI.setText(findTestObject('Page_Login/input_Username_username'), 'John Doe')

WebUI.setText(findTestObject('Page_Login/input_Password_password'), 'ThisIsNotAPassword')

WebUI.click(findTestObject('Page_Login/button_Login'))

WebUI.selectOptionByValue(findTestObject('Page_Appointment/select_Tokyo CURA Healthcare Center                            Hongkong CURA Healthcare Center                            Seoul CURA Healthcare Center'), 
    'Tokyo CURA Healthcare Center', false)

WebUI.check(findTestObject('Page_Appointment/input_Apply for hospital readmission_hospital_readmission'))

WebUI.click(findTestObject('Page_Appointment/input_Medicaid_programs'))

WebUI.setText(findTestObject('Page_Appointment/input_Visit Date (Required)_visit_date'), '29/05/2019')

WebUI.setText(findTestObject('Page_Appointment/textarea_Comment_comment'), 'This is NOT a test')

WebUI.click(findTestObject('Page_Appointment/button_Book Appointment'))

WebUI.callTestCase(findTestCase('Summary Page/Verify_Details'), [('Facility') : 'Tokyo CURA Healthcare Center', ('Readmission') : 'Yes'
        , ('Healthcare') : 'Medicaid', ('Dates') : '29/05/2019', ('Comment') : 'This is NOT a test'], FailureHandling.STOP_ON_FAILURE)

