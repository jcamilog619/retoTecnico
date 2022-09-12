package co.com.certification.utils.restconsumo.get;

import co.com.certification.models.transversal.Peticiones;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.Map;

import static co.com.certification.enums.EndPoint.ENDPOINT;
import static co.com.certification.enums.EndPoint.ENDPOINT_ERROR;
import static co.com.certification.utils.constantes.ConstantesExcepcion.EXCEPTION_SERVICO;
import static co.com.certification.utils.constantes.ConstantesTrasnversales.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.rest;

public class ApiGet {
    private static final Logger LOGGER = LogManager.getLogger(ApiGet.class.getName());

    private ApiGet() {
    }

    public static void procesarGet(Map<String, Object> testData) {
        if (DATA_EXITOSA.equals(testData.get(DATE).toString())) {
            rest().contentType(ContentType.JSON).relaxedHTTPSValidation().when().get(ENDPOINT.toString()+testData.get(EMPLOYEE_ID));
        } else {
            rest().contentType(ContentType.JSON).relaxedHTTPSValidation().when().get(ENDPOINT_ERROR.toString()+testData.get(EMPLOYEE_ID));
        }
        lastResponse().prettyPrint();
        JSONObject jsGet = new JSONObject(lastResponse().asString());
        try {
            if (STATUS_OK == lastResponse().statusCode()) {
                    String salario = String.valueOf(jsGet.getJSONObject(DATA).getInt(EMPLOYEE_SALARY));
                    String edad = String.valueOf(jsGet.getJSONObject(DATA).getInt(EMPLOYEE_AGE));
                    String info = jsGet.getJSONObject(DATA).getString(EMPLOYEE_NAME) + salario + edad;
                    Peticiones.setInfoEmpleado(info);
            } else {
                Peticiones.setRsEstadoCodigo(String.valueOf(lastResponse().statusCode()));
                String mensaje = jsGet.getString(MENSAJE);
                Peticiones.setMensaje(mensaje);
            }
        } catch (Exception e) {
            LOGGER.error(EXCEPTION_SERVICO, e);
        }
    }
}