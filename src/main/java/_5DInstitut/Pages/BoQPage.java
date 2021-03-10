package _5DInstitut.Pages;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.paulhammant.ngwebdriver.ByAngularButtonText;

import _5DInstitut.ConfigReader.ConfigDataProvider;
import _5DInstitut.Utilities.FileUploader;
import _5DInstitut.Utilities.Interact;

public class BoQPage extends Interact {
	//private WebDriver driver;
	public static ConfigDataProvider config;

	public BoQPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Home page 
	@FindBy (xpath = "//span[normalize-space()='BoQ']") WebElement clickOnBoQ;
	@FindBy (xpath = "//button[@class='navbar-btn btn-main e2e-navbar-btn-refresh']") WebElement clickOnRefresh;
	@FindBy (xpath = "//button[@title='Wizard']") WebElement clicOnWizard;
	@FindBy (xpath = "//li[contains(text(),'Create and import multiple BoQs')]") WebElement clickOnCreateImportBoQ;

	public void SelectBoQ() {
		clickOnElement(clickOnBoQ);
	}
	public void RefreshProject() {
		clickOnElement(clickOnRefresh);
	}
	public void OpenWizard() {
		clickOnElement(clicOnWizard);
	}
	public void CreateImportBoQs() throws Exception {
		config = new ConfigDataProvider();
		clickOnElement(clickOnCreateImportBoQ);
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\abhijeetk\\OneDrive - Winjit Technologies Pvt Ltd\\Desktop\\BoQ_FileImport.exe");
	}

	@FindBy (xpath = "//div[text()='CODE01']/following-sibling::div[2]") WebElement AssignModeClick_1;
	@FindBy (xpath = "//li[normalize-space()='Ignore']") WebElement IgnoreClk;
	@FindBy (xpath = "//button[normalize-space()='OK']") WebElement OKClick;
	@FindBy (xpath = "//button[contains(@data-lookup-show,'settings.showEditButton')]") WebElement DropDownArrow;

	public void PopUp_GAEBImport() throws Exception {
		/*
		 * Set<String> s1=driver.getWindowHandles(); Iterator<String> i1=s1.iterator();
		 * String ChildWindow=i1.next(); String MainWindow=driver.getWindowHandle();
		 * driver.switchTo().window(ChildWindow);
		 */
		SwitchToPopUp();

		for (int i=1;i<=2;i++) {
			WebElement AssignModeClick = driver.findElement(By.xpath("//div[text()='CODE0"+i+"'"+"]/following-sibling::div[2]"));
			Thread.sleep(1000);
			clickOnElement(AssignModeClick);
			clickOnElement(DropDownArrow);
			Thread.sleep(1000);
			clickOnElement(IgnoreClk);

		}
		clickOnElement(OKClick);
		driver.switchTo().defaultContent();

	}

	@FindBy (xpath = "//button[normalize-space()='OK']")  WebElement OKClick_2;
	public void Conf_GAEBImport() throws Exception {
		Thread.sleep(3000);
		SwitchToPopUp();
		Thread.sleep(3000);
		clickOnElement(OKClick_2);
		driver.switchTo().defaultContent();
	}

	@FindBy (xpath = "//button[normalize-space()='Yes']") WebElement YesClick;
	public void QuestionPoPUp() throws Exception {
		Thread.sleep(3000);
		SwitchToPopUp();
		Thread.sleep(3000);
		clickOnElement(YesClick);
		driver.switchTo().defaultContent();
	}

	//Next GAEB Import
	@FindBy (xpath = "//div[text()='CODE01']/following-sibling::div[2]") WebElement row_1;
	@FindBy (xpath = "//div[text()='CODE02']/following-sibling::div[2]") WebElement row_2;
	@FindBy (xpath = "//div[text()='work category']/following-sibling::div[text()='CODE01']/following-sibling::div[2]") WebElement row_3;
	@FindBy (xpath = "//div[text()='cost group DIN 276-93']/following-sibling::div[5]") WebElement row_4;
	@FindBy (xpath = "//div[text()='cost group DIN 276-1 2008-12']/following-sibling::div[5]") WebElement row_5;
	@FindBy (xpath = "//button[contains(@title,'Wizard')]") WebElement WizardCloseClick;
	public void PopUp_2_GEABImport() throws Exception {
		Thread.sleep(3000);
		SwitchToPopUp();
//		Thread.sleep(1000);
//		clickOnElement(row_1);
//		clickOnElement(DropDownArrow);
//		clickOnElement(IgnoreClk);
//		Thread.sleep(1000);
//		clickOnElement(row_2);
//		clickOnElement(DropDownArrow);
//		clickOnElement(IgnoreClk);
		Thread.sleep(1000);
		clickOnElement(row_3);
		clickOnElement(DropDownArrow);
		clickOnElement(IgnoreClk);
		Thread.sleep(1000);
		clickOnElement(row_4);
		clickOnElement(DropDownArrow);
		clickOnElement(IgnoreClk);
		Thread.sleep(1000);
		clickOnElement(row_5);
		clickOnElement(DropDownArrow);
		clickOnElement(IgnoreClk);
		Thread.sleep(1000);
		clickOnElement(OKClick);
		Thread.sleep(2000);
		clickOnElement(WizardCloseClick);
		driver.switchTo().defaultContent();

	}

	@FindBy (xpath = "//div[@id='ac4a13a8f33540ed80d0d9f67983fa01']/div[4]/div[3]/div[1]/div[3]/div/div[1]") WebElement SelectBoQ_1;
	//@FindBy (xpath = "//div[@id='ac4a13a8f33540ed80d0d9f67983fa01']/div[4]/div[3]/div[1]/div[3]/div/div[2]") WebElement SelectBoQ_2;
	@FindBy (xpath = "//button[contains(@title,'Open BoQ')]") WebElement GoToBoQ;
	public void GoToBoQ_1() throws Exception {
		clickOnElement(SelectBoQ_1);
		clickOnElement(GoToBoQ);
		Thread.sleep(3000);
	}

	/*
	 * public void GoToBoQ_2() throws Exception { clickOnElement(SelectBoQ_2);
	 * clickOnElement(GoToBoQ); Thread.sleep(3000); }
	 */

	@FindBy (xpath = "//div[contains(@data-ng-animate,\"{enter: 'animate-enter', leave: 'animate-leave'}\")]//li[4]//button[1]") WebElement DeleteBoQ;
	@FindBy (xpath ="//button[@title='Unsaved Data']") WebElement UnsavedClick;
	
	public void DeleteAllBoQs() throws Exception {
		for (int i=1; i<=2;i++) {
			clickOnElement(SelectBoQ_1);
			Thread.sleep(2000);
			clickOnElement(DeleteBoQ);
			Thread.sleep(2000);
			SwitchToPopUp();
			Thread.sleep(2000);
			clickOnElement(YesClick);
			driver.switchTo().defaultContent();
		}
	}
	public void SaveChanges() throws Exception {
		Thread.sleep(2000);
		clickOnElement(UnsavedClick);
	}
}

