package co.com.certification.questions;

import co.com.certification.models.transversal.Peticiones;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.certification.utils.constantes.ConstantesValidaciones.RS_DELETE;

public class ValidarDelete implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String responsePost = Peticiones.getMensaje();
        return RS_DELETE.contains(responsePost);
    }

    public static ValidarDelete transversal() {
        return new ValidarDelete();
    }
}
