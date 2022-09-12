package co.com.certification.taks;

import co.com.certification.utils.restconsumo.get.ApiGetLista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

public class ObtenerGetLista implements Task {
    private final Map<String, Object> testData;

    public ObtenerGetLista(Map<String, Object> testData) {
        this.testData = testData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ApiGetLista.procesarGetListas(testData);
    }

    public static ObtenerGetLista api(Map<String, Object> testData) {
        return Tasks.instrumented(ObtenerGetLista.class, testData);
    }
}
