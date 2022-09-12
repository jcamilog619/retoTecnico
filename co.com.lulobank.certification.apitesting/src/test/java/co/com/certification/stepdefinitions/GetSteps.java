package co.com.certification.stepdefinitions;

import co.com.certification.models.transversal.TestData;
import co.com.certification.questions.ValidarGet;
import co.com.certification.taks.ObtenerGetInfo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetSteps {

    @Cuando("se realiza la consulta a la api")
    @Cuando("se realiza la consulta a la api erronea")
    public void seRealizaLaPeticionALaApi() {
        theActorInTheSpotlight().attemptsTo(ObtenerGetInfo.api(TestData.info()));
    }

    @Entonces("se vizualizara exitosamente la informacion del response")
    public void seVizualizaraExitosamenteLaInformacionDelResponseesponse() {
        theActorInTheSpotlight().should(seeThat(ValidarGet.transversal(TestData.info()).exioso()));
    }
    @Entonces("se vizualizara el error del response")
    public void seVizualizaraElErrorDelResponse() {
        theActorInTheSpotlight().should(seeThat(ValidarGet.transversal(TestData.info()).error()));
    }
}
