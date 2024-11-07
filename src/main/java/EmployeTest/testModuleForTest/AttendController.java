package EmployeTest.testModuleForTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attend")

public class AttendController {

    @Autowired
    private HrCrEmpRepo hrCrEmpRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HrTlShftAssignRepo hrTlShftAssignRepo;
    @Autowired
    private HrTlShftRepo hrTlShftRepo;

    @PostMapping("/createEmp")
    public ResponseEntity<?> addHrCrEmp(@RequestBody HrCrEmp worker){
        worker.getAssignment().setHrCrEmpId(worker);
        hrCrEmpRepo.save(worker);
        return new  ResponseEntity<HrCrEmp>(worker, HttpStatus.OK);
    }

    @GetMapping("/shiftassignById/{id}")
    public ResponseEntity<?> shiftassignById(@PathVariable Long id){
        HrTlShftAssign ob  = hrTlShftAssignRepo.findById(id).get();
        return new  ResponseEntity<HrTlShftAssign>(ob, HttpStatus.OK);
    }

    @PostMapping("/createShift")
    public ResponseEntity<?> addHrCrEmp(@RequestBody HrTlShftDtl worker){
        hrTlShftRepo.save(worker);
        return new  ResponseEntity<HrTlShftDtl>(worker, HttpStatus.OK);
    }

    @GetMapping("/getIds")
    public ResponseEntity<?> khgk(){
        List<Object[]> lst = hrTlShftAssignRepo.getHrCrEmpIdAndShftId();
        return new  ResponseEntity<>(lst, HttpStatus.OK);
    }


    @PostMapping("/assignShift")
    public ResponseEntity<?> assignShift(@RequestBody HrTlShftAssign worker){
//        if(hrTlShftAssignRepo.existsByHrCrEmpAndHrTlShftDtl(worker.getHrCrEmp(),worker.getHrTlShftDtl())){
//            return new  ResponseEntity<>("already assigned this shift for this emp id ", HttpStatus.OK);
//        }
        HrTlShftAssign k = hrTlShftAssignRepo.save(worker);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(k.getHrTlShftDtl());
        System.out.println(worker.getHrTlShftDtl());

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return new  ResponseEntity<HrTlShftAssign>(worker, HttpStatus.OK);
    }

    @GetMapping("/existByTitle/{title}/{code}")
    public ResponseEntity<?> existByTitle(@PathVariable String title ,@PathVariable String code ){
        if(hrTlShftAssignRepo.existsByTitleAndHrCrEmpLoginCode(title,code)){
            return new  ResponseEntity<>("yesssssssssssssss exist ", HttpStatus.OK);
        }
        return new  ResponseEntity<>("noooooooo not exist ", HttpStatus.OK);
    }


    @GetMapping("/shftDtl/{hrcrempId}")
    public ResponseEntity<?> getShftDtlByEmpId(@PathVariable Long hrcrempId){

        String sqlString2 = " select id,start_time,end_time  " +
                "from hr_tl_shft_dtl  where id=(select HR_TL_SHFT_DTL_ID from hr_tl_shft_assign  " +
                " where hr_cr_emp_id="+hrcrempId+" and active_status=false order by id desc limit 1)  limit 1";
        List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(sqlString2);

      //  Map<String,Object> rows2=hrTlShftAssignRepo.getListByHrCrEmp(hrcrempId,Boolean.TRUE);

        return new  ResponseEntity<>(rows2, HttpStatus.OK);
    }




}
