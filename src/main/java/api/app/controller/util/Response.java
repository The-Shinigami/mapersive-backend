package api.app.controller.util;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private Status status;
    public T payload;

    public Status getStatus() {
        return status;
    }

    public Response<T> setStatus(Status status) {
        this.status = status;
        return this;
    }

    public T getPayload() {
        return payload;
    }

    public Response<T> setPayload(T payload) {
        this.payload = payload;
        return this;
    }

    private Object errors;

    public Object getErrors() {
        return errors;
    }

    public Response<T> setErrors(Object errors) {
        this.errors = errors;
        return this;
    }

    private Object metadata;

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(Status.OK);
        return response;
    }

    public static <T> Response<T> unauthorized() {
        Response<T> response = new Response<>();
        response.setStatus(Status.UNAUTHORIZED);
        return response;
    }

    public static <T> Response<T> validationException() {
        Response<T> response = new Response<>();
        response.setStatus(Status.VALIDATION_EXCEPTION);
        return response;
    }

    public static <T> Response<T> wrongCredentials() {
        Response<T> response = new Response<>();
        response.setStatus(Status.WRONG_CREDENTIALS);
        return response;
    }

    public static <T> Response<T> exception() {
        Response<T> response = new Response<>();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

    public static <T> Response<T> notFound() {
        Response<T> response = new Response<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

    public static <T> Response<T> duplicateEntity() {
        Response<T> response = new Response<>();
        response.setStatus(Status.DUPLICATE_ENTITY);
        return response;
    }

    public void addErrorMsgToResponse(Exception ex) {
        ResponseError error = new ResponseError()
                .setMessage(ex.getMessage());
        setErrors(error);
    }

    public enum Status {
        OK, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, NOT_FOUND, DUPLICATE_ENTITY
    }

}