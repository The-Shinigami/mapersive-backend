package api.app.controller;

import api.app.model.InsuranceDto;
import api.app.model.mapper.InsuranceMapper;
import api.app.service.InsuranceService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    InsuranceService insuranceService;

    InsuranceController(InsuranceService insuranceService){
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public ResponseEntity<Page<InsuranceDto>> getInsurances(Pageable pageable) {
        Page<InsuranceDto> insurances = insuranceService.getAll(pageable);
        return ResponseEntity.ok(insurances);
    }

    @PostMapping
    public ResponseEntity<InsuranceDto> addInsurance(@RequestBody InsuranceDto insuranceDto) {
        InsuranceDto insurance = insuranceService.save(InsuranceMapper.INSTANCE.DtoToEntity(insuranceDto));
        return ResponseEntity.ok(insurance);
    }
    @PutMapping
    public ResponseEntity<InsuranceDto> updateInsurance(@RequestBody InsuranceDto insuranceDto) {
        InsuranceDto insurance = insuranceService.save(InsuranceMapper.INSTANCE.DtoToEntity(insuranceDto));
        return ResponseEntity.ok(insurance);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteInsurance(@RequestBody int insuranceId) {
        boolean isDeleted =  insuranceService.remove(insuranceId);
        return ResponseEntity.ok(isDeleted);
    }
}
