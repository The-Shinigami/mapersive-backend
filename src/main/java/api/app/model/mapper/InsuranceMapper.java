package api.app.model.mapper;


import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InsuranceMapper {
    InsuranceMapper INSTANCE = Mappers.getMapper(InsuranceMapper.class);

    @Mapping(source = "id",target = "insuranceId")
    InsuranceDto entityToDto(Insurance insurance);

    @Mapping(source = "insuranceId",target = "id")
    Insurance DtoToEntity(InsuranceDto insuranceDto);

}
