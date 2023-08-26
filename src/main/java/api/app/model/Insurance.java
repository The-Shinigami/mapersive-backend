package api.app.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
@Data

@Entity
@Table(name = "insurance")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

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
