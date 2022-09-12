package co.com.certification.utils.restconsumo.get;

import co.com.certification.models.transversal.Peticiones;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.Map;

import static co.com.certification.enums.EndPoint.ENDPOINT_LISTA;
import static co.com.certification.enums.EndPoint.ENDPOINT_LISTA_ERROR;
import static co.com.certification.utils.constantes.ConstantesExcepcion.EXCEPTION_SERVICO;
import static co.com.certification.utils.constantes.ConstantesTrasnversales.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.rest;

public class ApiGetLista {
    private static final Logger LOGGER = LogManager.getLogger(ApiGetLista.class.getName());

    private ApiGetLista() {
    }

    public static void procesarGetListas(Map<String, Object> testData) {
        if (DATA_EXITOSA.equals(testData.get(DATE).toString())) {
            rest().contentType(ContentType.JSON).relaxedHTTPSValidation().when().get(ENDPOINT_LISTA.toString());
        } else {
            rest().contentType(ContentType.JSON).relaxedHTTPSValidation().when().get(ENDPOINT_LISTA_ERROR.toString());
        }
        lastResponse().prettyPrint();
        JSONObject jsGetLista = new JSONObject(lastResponse().asString());
        try {
            if (STATUS_OK == lastResponse().statusCode()) {
                for (int i = 0; i <= Integer.parseInt(testData.get(EMPLOYEE_ID).toString()); i++) {
                    String salario = String.valueOf(jsGetLista.getJSONArray(DATA).getJSONObject(i).getInt(EMPLOYEE_SALARY));
                    String edad = String.valueOf(jsGetLista.getJSONArray(DATA).getJSONObject(i).getInt(EMPLOYEE_AGE));
                    String info = jsGetLista.getJSONArray(DATA).getJSONObject(i).getString(EMPLOYEE_NAME) + salario + edad;
                    Peticiones.setInfoEmpleado(info);
                }
            } else {
                Peticiones.setRsEstadoCodigo(String.valueOf(lastResponse().statusCode()));
                String mensaje = jsGetLista.getString(MENSAJE);
                Peticiones.setMensaje(mensaje);
            }
        } catch (Exception e) {
            LOGGER.error(EXCEPTION_SERVICO, e);
        }
    }
}