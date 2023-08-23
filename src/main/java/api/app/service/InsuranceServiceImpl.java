package api.app.service;

import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import api.app.model.mapper.InsuranceMapper;
import api.app.repository.InsuranceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.stream.Collectors;

public class InsuranceServiceImpl implements InsuranceService{
    InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository){
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Page<InsuranceDto> getAll(Pageable pageable) {
        return insuranceRepository.findAll(pageable).map(insurance -> InsuranceMapper.INSTANCE.entityToDto(insurance)) ;
    }

    @Override
    public Insurance save(Insurance insurance) {
        return null;
    }

    @Override
    public Insurance remove(Insurance insurance) {
        return null;
    }
}
