package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageStep {

    @Step("Переход на страницу афиша")
    public void goToAfisha(){

        new MainPage().MainPageGoToAfisha();
    }

}
