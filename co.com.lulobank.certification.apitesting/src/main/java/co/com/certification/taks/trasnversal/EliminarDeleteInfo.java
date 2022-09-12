package co.com.certification.taks.trasnversal;

import co.com.certification.utils.restconsumo.delete.ApiDelete;
import co.com.certification.utils.restconsumo.post.ApiPost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.io.IOException;
import java.util.Map;

public class EliminarDeleteInfo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        ApiDelete.procesarDelete();
    }

    public static EliminarDeleteInfo api() {
        return new EliminarDeleteInfo();
    }
}
