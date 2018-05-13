package steps;

import io.qameta.allure.Step;
import pages.FilmPage;

public class FilmStep {
    @Step("Проверить на открывшейся странице название фильма и количество кинотеатров")
    public void check(){
        new FilmPage().checkNameNumbers();
    }
}
