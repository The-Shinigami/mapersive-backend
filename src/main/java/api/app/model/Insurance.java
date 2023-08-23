package api.app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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
