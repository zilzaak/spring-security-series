package EmployeTest.workerModule.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/worker")
public class WorkerController {

   @Autowired
   private   Workerrepo wrr;
    @Autowired
    private Taskrepo trr;



    @PostMapping("/create")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('WORKER_ADMIN')")
public ResponseEntity<?> addworker(@RequestBody Worker worker){
wrr.save(worker);

    return new  ResponseEntity<Worker>(worker, HttpStatus.OK);
}


    @PostMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('WORKER_ADMIN')")
    public ResponseEntity<?> deletre(@PathVariable Integer id){
        wrr.deleteById(id);
        return new  ResponseEntity<>(id,HttpStatus.OK);
    }


    @PostMapping("/update")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('WORKER_ADMIN')")
    public ResponseEntity<?> update(@RequestBody Worker worker){
        wrr.save(worker);
        return new  ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('WORKER_ADMIN')")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return new  ResponseEntity<Worker>(wrr.findById(id).orElse(null), HttpStatus.OK);
    }



}
