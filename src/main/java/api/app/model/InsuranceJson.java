package api.app.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
public class InsuranceJson {
       public Integer Policy_id;
       public String Date_of_Purchase;
       public Integer Customer_id;
       public String Fuel;
       public String VEHICLE_SEGMENT;
       public Integer Premium;
       public Integer bodily_injury_liability;
       public Integer personal_injury_protection;
       public Integer property_damage_liability;
       public Integer collision;
       public Integer comprehensive;
       public String Customer_Gender;
       public String Customer_Income_group;
       public String Customer_Region;
       public Integer Customer_Marital_status;

}
