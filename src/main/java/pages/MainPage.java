package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import other.Stash;

public class MainPage extends Base {        //Главная страница яндекса
    @FindBy(xpath = ".//a[contains(text(),'Афиша')]")
    public WebElement afishaBut;

    public MainPage (){         //конструктор
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public AfishaPage MainPageGoToAfisha (){
        afishaBut.click();
        return new AfishaPage();
    }
}
