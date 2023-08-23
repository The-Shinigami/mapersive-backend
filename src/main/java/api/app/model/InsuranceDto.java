package api.app.model;


import lombok.Data;

@Data
public class InsuranceDto {
    private String insuranceId;
    private int policyId;
    private String dateOfPurchase;
    private int customerId;
    private String fuel;
    private String vehicleSegment;
    private int premium;
    private int bodilyInjuryLiability;
    private int personalInjuryProtection;
    private int propertyDamageLiability;
    private int collision;
    private int comprehensive;
    private String customerGender;
    private String customerIncomeGroup;
    private String customerRegion;
    private int customerMaritalStatus;
}
