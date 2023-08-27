package api.app.service;

import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface InsuranceService {
    Page<InsuranceDto> getAll(Pageable pageable);

    InsuranceDto save(Insurance insurance);

    boolean remove(int insuranceId);

    void loadOnstart(String path) throws IOException;


}
