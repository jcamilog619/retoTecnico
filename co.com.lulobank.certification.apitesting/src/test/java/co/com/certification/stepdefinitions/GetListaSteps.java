package co.com.certification.stepdefinitions;

import co.com.certification.models.transversal.TestData;
import co.com.certification.questions.ValidarGet;
import co.com.certification.taks.ObtenerGetLista;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetListaSteps {

    @Cuando("se realiza la peticion a la api")
    @Cuando("se realiza la peticion a la api erronea")
    public void seRealizaLaPeticionALaApi() {
        theActorInTheSpotlight().attemptsTo(ObtenerGetLista.api(TestData.info()));
    }

    @Entonces("se vizualizara exitosamente el response")
    public void seVizualizaraExitosamenteElResponse() {
        theActorInTheSpotlight().should(seeThat(ValidarGet.transversal(TestData.info()).exioso()));
    }
    @Entonces("se vizualizara el error en el response")
    public void seVizualizaraElErrorEnElResponse() {
        theActorInTheSpotlight().should(seeThat(ValidarGet.transversal(TestData.info()).error()));
    }
}
