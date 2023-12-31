package api.app.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InsuranceDto {
    public int insuranceId;
    public int policyId;
    public String dateOfPurchase;
    public int customerId;
    public String fuel;
    public String vehicleSegment;
    public int premium;
    public int bodilyInjuryLiability;
    public int personalInjuryProtection;
    public int propertyDamageLiability;
    public int collision;
    public int comprehensive;
    public String customerGender;
    public String customerIncomeGroup;
    public String customerRegion;
    public int customerMaritalStatus;
}
