package api.app.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InsuranceDeleteRequest {

    @NotNull(message = "Deletion is failed")
    public Integer id;
}
