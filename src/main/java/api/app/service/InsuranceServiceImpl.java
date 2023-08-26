package api.app.service;

import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import api.app.model.InsuranceJson;
import api.app.mapper.InsuranceMapper;
import api.app.repository.InsuranceRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceServiceImpl implements InsuranceService{
    InsuranceRepository insuranceRepository;

    ObjectMapper objectMapper;


    public InsuranceServiceImpl(InsuranceRepository insuranceRepository,ObjectMapper objectMapper){
        this.insuranceRepository = insuranceRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Page<InsuranceDto> getAll(Pageable pageable) {
        return insuranceRepository.findAll(pageable).map(insurance -> InsuranceMapper.INSTANCE.entityToDto(insurance)) ;
    }

    @Override
    public InsuranceDto save(Insurance insurance) {
        return InsuranceMapper.INSTANCE.entityToDto(insuranceRepository.save(insurance));
    }

    @Override
    public boolean remove(int insuranceId) {
        try{
            insuranceRepository.deleteById(insuranceId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void loadOnstart(String path) throws IOException {
        if(insuranceRepository.findAll().size() == 0) {
            ClassPathResource resource = new ClassPathResource(path);
            InputStream inputStream = resource.getInputStream();
            List<InsuranceJson> insurancesJson = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            List<Insurance> insurances = insurancesJson.stream().map(insuranceJson -> InsuranceMapper.INSTANCE.jsonToEntity(insuranceJson)).collect(Collectors.toList());
            insuranceRepository.saveAll(insurances);

            System.out.println("Data Is Loaded");
        }else{
            System.out.println("Data Is Already Loaded");
        }
    }

    public static String inputStreamContent(InputStream inputStream) {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result+=(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
