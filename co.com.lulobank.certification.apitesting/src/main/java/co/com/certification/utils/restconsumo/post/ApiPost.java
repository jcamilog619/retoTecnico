package co.com.certification.utils.restconsumo.post;

import co.com.certification.models.transversal.Peticiones;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import static co.com.certification.enums.EndPoint.ENDPOINT_CREAR;
import static co.com.certification.utils.constantes.ConstantesExcepcion.EXCEPTION_SERVICO;
import static co.com.certification.utils.constantes.ConstantesTrasnversales.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.rest;

public class ApiPost {
    private static final Logger LOGGER = LogManager.getLogger(ApiPost.class.getName());

    private ApiPost() {
    }

    public static void procesarPost(Map<String, Object> testData) throws IOException {
        SetPostDatos.empleados(testData);
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(Peticiones.getBodyRequest())
                .when()
                .post(ENDPOINT_CREAR.toString());

        lastResponse().prettyPrint();
        JSONObject jsPost = new JSONObject(lastResponse().asString());
        try {
            if (STATUS_OK == lastResponse().statusCode()) {
                Integer id_empleado = jsPost.getJSONObject(DATA).getInt(ID);
                String mensaje = jsPost.getString(MENSAJE);
                Peticiones.setId(id_empleado);
                Peticiones.setMensaje(mensaje);
            }
        } catch (Exception e) {
            LOGGER.error(EXCEPTION_SERVICO, e);
        }
    }
}