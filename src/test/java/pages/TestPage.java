package pages;

import myapps.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestPage extends CommonMethods {

    @FindBy(id="inputEmail")
    public WebElement emailTextField;


    @FindBy(id="inputPassword")
    public WebElement passwordTextfield;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//ul[@class='list-group']/li[contains(text(),'List')]")
    public List<WebElement> listItemValues;

    public TestPage(){
        PageFactory.initElements(driver,this);
    }
}
