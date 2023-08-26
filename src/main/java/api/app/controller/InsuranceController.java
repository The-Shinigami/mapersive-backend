package api.app.controller;

import api.app.controller.request.InsuranceDeleteRequest;
import api.app.controller.util.Response;
import api.app.model.InsuranceDto;
import api.app.mapper.InsuranceMapper;
import api.app.service.InsuranceService;
import api.app.service.MapValidationErrorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/insurance")
@CrossOrigin("*")
public class InsuranceController {

    InsuranceService insuranceService;
    MapValidationErrorService mapValidationErrorService;

    InsuranceController(InsuranceService insuranceService,
                        MapValidationErrorService mapValidationErrorService
    ){
        this.insuranceService = insuranceService;
        this.mapValidationErrorService = mapValidationErrorService;
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

    @DeleteMapping("/{insuranceId}")
    public ResponseEntity<Boolean> deleteInsurance(@PathVariable Integer insuranceId) {
        boolean isDeleted =  insuranceService.remove(insuranceId);
        return ResponseEntity.ok(isDeleted);
    }
}
