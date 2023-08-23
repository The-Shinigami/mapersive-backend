package api.app.service;

import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface InsuranceService {
    Page<InsuranceDto> getAll(Pageable pageable);

    Insurance save(Insurance insurance);

    Insurance remove(Insurance insurance);


}
