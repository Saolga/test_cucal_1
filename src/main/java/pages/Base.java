package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    WebDriver driver;

    public void waitVisibilityOf(WebElement loc, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(loc));
    }
    //всплывающее
    @FindBy(xpath = ".//button[contains(@class,'button2 button2_theme_clear button2_size_l button2_view_classic subscribe-form-email__button subscribe-form-email__button_type_close subscribe-modal__close')]")
    public WebElement one;
    @FindBy(xpath = ".//div[contains(@class,'tutorial-modal__close')]")
    public WebElement two;

    public void waitVisibilityOf(WebElement loc){
        waitVisibilityOf(loc,25);
    }

   // public void fillField(String var,WebElement loc){
    //    loc.sendKeys(var);
   // }


    public void closeScum(WebElement w){
        if(one.isDisplayed()){
            one.click();}
        if(two.isDisplayed()){
            two.click();}
        waitVisibilityOf(w);        //Ожидает отображение нужного элемента
    }

    public void closeScum(){        //не ожидает
        if(one.isDisplayed()){
            one.click();}
        if(two.isDisplayed()){
            two.click();}
    }

}
