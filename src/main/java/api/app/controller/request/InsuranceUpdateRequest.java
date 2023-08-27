package api.app.controller.request;

import lombok.Data;

@Data
public class InsuranceUpdateRequest {
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
