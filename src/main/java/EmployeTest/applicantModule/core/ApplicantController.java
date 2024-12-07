package EmployeTest.applicantModule.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantRepo applicantRepo;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Applicant applicants){
       applicantRepo.save(applicants);
        return new  ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("The current user name is "+username);
        Applicant applicant = applicantRepo.findById(id).orElse(null);
        return new  ResponseEntity<>(applicant, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return new  ResponseEntity<>(applicantRepo.findAll(),HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody List<Applicant> applicants){
        applicantRepo.saveAll(applicants);
        return new  ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Applicant applicant = applicantRepo.findById(id).orElse(null);
        applicantRepo.delete(applicant);
        return new  ResponseEntity<>("deleted", HttpStatus.OK);
    }


}
