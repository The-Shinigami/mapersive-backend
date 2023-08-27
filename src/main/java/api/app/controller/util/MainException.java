package api.app.controller.util;

import api.app.model.Insurance;
import org.springframework.stereotype.Component;

@Component
public class MainException  {

    public static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        /*aid*/
        return entityType.name().toUpperCase().concat(" is ").concat(exceptionType.getValue()).toUpperCase();
    }

}
