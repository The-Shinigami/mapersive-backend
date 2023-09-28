package api.app.controller;

import api.app.controller.request.InsuranceAddRequest;
import api.app.controller.request.InsuranceUpdateRequest;
import api.app.controller.util.EntityType;
import api.app.controller.util.ExceptionType;
import api.app.controller.util.MainException;
import api.app.controller.util.Response;
import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import api.app.mapper.InsuranceMapper;
import api.app.service.InsuranceService;
import api.app.service.MapValidationErrorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/insurance")
@CrossOrigin("*")
@Validated
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
    public ResponseEntity<Response> addInsurance(@RequestBody @Valid InsuranceAddRequest insuranceAddRequest) {
        Insurance insuranceEntity = InsuranceMapper.INSTANCE.requestAddToEntity(insuranceAddRequest);

        insuranceService.save(insuranceEntity);

    return  new ResponseEntity<Response>(Response.ok().setPayload(MainException.getMessageTemplate(EntityType.Insurance, ExceptionType.ADDED)), HttpStatus.OK);

    }
    @PutMapping
    public ResponseEntity updateInsurance(@RequestBody @Valid InsuranceUpdateRequest insuranceUpdateRequest) {

       insuranceService.save(InsuranceMapper.INSTANCE.requestUpdateToEntity(insuranceUpdateRequest));

        return  new ResponseEntity<Response>(Response.ok().setPayload(MainException.getMessageTemplate(EntityType.Insurance, ExceptionType.UPDATED)), HttpStatus.OK);
    }

    @DeleteMapping("/{insuranceId}")
    public ResponseEntity deleteInsurance(@PathVariable Integer insuranceId) {
        insuranceService.remove(insuranceId);
        return  new ResponseEntity<Response>(Response.ok().setPayload(MainException.getMessageTemplate(EntityType.Insurance, ExceptionType.DELETED)), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).toList();

        return new ResponseEntity<>(Response.validationException().setErrors(errors).setPayload(MainException.getMessageTemplate(EntityType.Insurance, ExceptionType.NOT_VALID)), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }




}
