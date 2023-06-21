 package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class Pomlogin extends BaseHRMClass {
	
@FindBy(name="username")WebElement Username;
@FindBy(name="password")WebElement Password;
@FindBy(css=" div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action")WebElement Login;

public Pomlogin() {
	PageFactory.initElements(driver, this);
}
public void typeusername(String name) {
	Username.sendKeys("name");
}
public void typepassword(String pass) {
	Password.sendKeys(pass);
}
public void clickbutton() {
	Login.click();
}
public String Verify() {
	return driver.getTitle();
	
}
}
