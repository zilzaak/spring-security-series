package EmployeTest.applicantModule.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantRepo applicantRepo;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('APPLICANT_ADMIN')")
    public ResponseEntity<?> save(@RequestBody List<Applicant> applicants){
       applicantRepo.saveAll(applicants);
        return new  ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('APPLICANT_ADMIN')")
    public ResponseEntity<?> getById(@PathVariable Long id){
             Applicant applicant = applicantRepo.findById(id).orElse(null);
        return new  ResponseEntity<>(applicant, HttpStatus.OK);
    }


    @PutMapping("/update")
    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('APPLICANT_ADMIN')")
    public ResponseEntity<?> update(@RequestBody List<Applicant> applicants){
        applicantRepo.saveAll(applicants);
        return new  ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('APPLICANT_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Applicant applicant = applicantRepo.findById(id).orElse(null);
        applicantRepo.delete(applicant);
        return new  ResponseEntity<>("deleted", HttpStatus.OK);
    }


}
