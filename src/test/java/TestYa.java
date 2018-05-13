import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.AfishaStep;
import steps.BaseStep;
import steps.FilmStep;
import steps.MainPageStep;

public class TestYa extends BaseStep {

    MainPageStep mps = new MainPageStep();
    AfishaStep as = new AfishaStep();
    FilmStep fs = new FilmStep();

    @DisplayName("Яндекс Афиша")
    @Test
    public void Test(){
        mps.goToAfisha();

        as.goToKino();
        as.prooveHeader();
        as.chooseD();
        as.findFilm();

        fs.check();
    }

}
