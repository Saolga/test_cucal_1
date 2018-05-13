package steps;

import io.qameta.allure.Step;
import pages.AfishaPage;

public class AfishaStep {

    @Step("Выбрать пункт меню - Кино")
    public void goToKino(){
        new AfishaPage().gotokino();
    }

    @Step("Проверить наличие заголовка")
    public void prooveHeader(){
        new AfishaPage().proveheader();
    }
    @Step("Выбрать дату")
    public void chooseD(){
        new AfishaPage().choosedate();
    }
    @Step("Найти фильм, запомнить название и количество кинотеатров, нажать на него")
    public void findFilm(){
        new AfishaPage().findfilm();
    }


}
