package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import other.Stash;

import java.util.List;

import static other.Stash.filmNameString;
import static other.Stash.filmNumbersString;

public class AfishaPage extends Base {
    @FindBy(xpath = ".//a[contains(text(),'Кино')]")
    public WebElement kinoBut;        // кино

    @FindBy(xpath = ".//h1")
    public WebElement header;          //заголовок "кино в Москве"

    @FindBy(xpath = ".//button[contains(@class,'events-filter-date__button')]")
    public WebElement dateBut;       //кнопка выбрать дату

    @FindBy(xpath = ".//span[text()='Завтра']")
    public WebElement demainBut;    //пункт завтра

    @FindBy(xpath = ".//div[@class='event-rating__value']")
    List<WebElement> raitings;      //рейтинги фильмов


    public AfishaPage() {       //конструктор
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void gotokino(){
        closeScum();
        kinoBut.click();
        closeScum();
    }
    public void proveheader(){
       // closeScum();
        waitVisibilityOf(header);
        closeScum(header);
        Assert.assertEquals("Нужный заголовок отсутсвует",
                "Кино в Москве", header.getText());
    }
    public void choosedate(){
        closeScum(dateBut);
        dateBut.click();
        //closeScum();
        waitVisibilityOf(demainBut);
        closeScum(demainBut);
        demainBut.click();
        closeScum();
    }
    public FilmPage findfilm(){
        closeScum();
        waitVisibilityOf(raitings.get(0));
        //closeScum(raitings.get(0));
        WebElement filmname = null;
        WebElement filmnumbers = null;
        WebElement erw=null;
        for (int i = 0; i < raitings.size(); ++i) {     //определение первого элемента с рейтинггом не меньше 8
            String rait = raitings.get(i).getText();
            if (rait.charAt(0) == '8' || rait.charAt(0) == '9') {
                filmname = driver.findElement(By.xpath(".//div[contains(text(),'" + rait + "')]//ancestor::div[contains(@class,'event event_id')]//h2"));
                filmnumbers = driver.findElement(By.xpath(".//div[contains(text(),'" + rait + "')]//ancestor::div[contains(@class,'event event_id')]//div[@class='event__place']"));  //в ччч кинотеатрах
                erw=driver.findElement(By.xpath(".//div[contains(text(),'" + rait + "')]//ancestor::div[contains(@class,'event event_id')]//div[@class='event__inner']"));
                break;
            }
        }
        Stash.put(filmNameString, filmname.getText());
        Stash.put(filmNumbersString,filmnumbers.getText());
        //filmname.click();
        erw.click();
        return new FilmPage();
    }


    public FilmPage afisha() {      //вариант для без step'ов
        closeScum();
        kinoBut.click();
        closeScum();
        waitVisibilityOf(header);
        closeScum();
        Assert.assertEquals("Нужный заголовок отсутсвует",
                "Кино в Москве", header.getText());
        dateBut.click();
        closeScum();
        waitVisibilityOf(demainBut);
        closeScum();
        demainBut.click();
        closeScum();
        waitVisibilityOf(raitings.get(0));
        closeScum();
        WebElement filmname = null;
        WebElement filmnumbers = null;
        for (int i = 0; i < raitings.size(); ++i) {     //определение первого элемента с рейтинггом не меньше 8
            String rait = raitings.get(i).getText();
            if (rait.charAt(0) == '8' || rait.charAt(0) == '9') {
                filmname = driver.findElement(By.xpath(".//div[contains(text(),'" + rait + "')]//ancestor::div[contains(@class,'event event_id')]//h2"));
                filmnumbers = driver.findElement(By.xpath(".//div[contains(text(),'" + rait + "')]//ancestor::div[contains(@class,'event event_id')]//div[@class='event__place']"));  //в ччч кинотеатрах
                break;
            }
        }
        Stash.put(filmNameString, filmname.getText());
        Stash.put(filmNumbersString,filmnumbers.getText());
        filmname.click();
        return new FilmPage();
    }

}