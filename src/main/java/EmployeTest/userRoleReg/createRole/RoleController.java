package EmployeTest.userRoleReg.createRole;

import EmployeTest.dto.MessageResponse;
import EmployeTest.userDtl.Role;
import EmployeTest.userDtl.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/user/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/create")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> save(@RequestBody Role role){
        if(roleRepository.existsByRoleName(role.getRoleName()) ||
           roleRepository.existsByAuthority(role.getAuthority())){
            return new  ResponseEntity<>(new MessageResponse("Already created",false), HttpStatus.OK);
        }
        roleRepository.save(role);
        SecurityContextHolder.clearContext();
        return new  ResponseEntity<>(new MessageResponse("Successfully created",false), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
   // //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Role role = roleRepository.findById(id).orElse(null);
        return new  ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping("/getAll")
   // //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> getAll(){
        return new  ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }


    @PutMapping("/update")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> update(@RequestBody Role role){
        if(roleRepository.existsByRoleNameAndIdNotIn(role.getRoleName(), Arrays.asList(role.getId())) ||
                roleRepository.existsByAuthorityAndIdNotIn(role.getAuthority(),Arrays.asList(role.getId()))){
            return new  ResponseEntity<>(new MessageResponse("Already created",false), HttpStatus.OK);
        }
        roleRepository.save(role);
        SecurityContextHolder.clearContext();
        return new  ResponseEntity<>(new MessageResponse("Successfully edited",false), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Role applicant = roleRepository.findById(id).orElse(null);
        roleRepository.delete(applicant);
        return new  ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
