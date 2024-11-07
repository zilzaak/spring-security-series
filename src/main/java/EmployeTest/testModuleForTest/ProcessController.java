package EmployeTest.testModuleForTest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProcessController {
    @Autowired
    ApprovalProcessRepo processRepo;

    @Autowired
    ApprovalStepRepo stepRepo;

    @PostMapping("/process/save")
    public ResponseEntity<?> save(@RequestBody ApprovalProcess process){
        processRepo.save(process);
        return new  ResponseEntity<>(process, HttpStatus.OK);
    }

    @PostMapping("/step/save")
    public ResponseEntity<?> fghg(@RequestBody ApprovalStep process){
        stepRepo.save(process);
        return new  ResponseEntity<>(process, HttpStatus.OK);
    }

    @GetMapping("/step/getAll")
    public ResponseEntity<?> StepGetAll(){
        return new  ResponseEntity<>(stepRepo.findAll(), HttpStatus.OK);
    }


    @GetMapping("/process/getAll")
    public ResponseEntity<?> processGetAll(){
        return new  ResponseEntity<>(processRepo.findAll(), HttpStatus.OK);
    }

public ApprovalStep  makeApprovalStep(ApprovalStep st){
    ApprovalStep obj = new ApprovalStep();
    BeanUtils.copyProperties(st,obj);
    return obj;

}



}
