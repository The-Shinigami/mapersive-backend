package api.app.mapper;


import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import api.app.model.InsuranceJson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {
    InsuranceMapper INSTANCE = Mappers.getMapper(InsuranceMapper.class);

    @Mapping(source = "id",target = "insuranceId")
    InsuranceDto entityToDto(Insurance insurance);

    @Mapping(source = "insuranceId",target = "id")
    Insurance DtoToEntity(InsuranceDto insuranceDto);

    @Mapping(source = "Policy_id", target = "policyId")
    @Mapping(source = "Date_of_Purchase", target = "dateOfPurchase")
    @Mapping(source = "Customer_id", target = "customerId")
    @Mapping(source = "Fuel", target = "fuel")
    @Mapping(source = "VEHICLE_SEGMENT", target = "vehicleSegment")
    @Mapping(source = "Premium", target = "premium")
    @Mapping(source = "bodily_injury_liability", target = "bodilyInjuryLiability")
    @Mapping(source = "personal_injury_protection", target = "personalInjuryProtection")
    @Mapping(source = "property_damage_liability", target = "propertyDamageLiability")
    @Mapping(source = "collision", target = "collision")
    @Mapping(source = "comprehensive", target = "comprehensive")
    @Mapping(source = "Customer_Gender", target = "customerGender")
    @Mapping(source = "Customer_Income_group", target = "customerIncomeGroup")
    @Mapping(source = "Customer_Region", target = "customerRegion")
    @Mapping(source = "Customer_Marital_status", target = "customerMaritalStatus")
    Insurance jsonToEntity(InsuranceJson insuranceJson);


}
