package api.app.model.mapper;


import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InsuranceMapper {
    @Mapping(source = "id",target = "insuranceId")
    InsuranceDto entityToDto(Insurance insurance);

    @Mapping(source = "insuranceId",target = "id")
    Insurance DtoToEntity(InsuranceDto insuranceDto);

}