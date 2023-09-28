package api.app.controller.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;




@Data
public class InsuranceAddRequest {

    public int policyId;
    @NotBlank(message = "Date is Blank")
    public String dateOfPurchase;
    public int customerId;
    @NotBlank(message = "Fuel is Blank")
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
