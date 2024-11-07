package EmployeTest.userRoleReg.userReg;

import EmployeTest.dto.MessageResponse;
import EmployeTest.userDtl.Role;
import EmployeTest.userDtl.User;
import EmployeTest.userDtl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/reg")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> save(@RequestBody User user){
        if(userRepository.existsByUsername(user.getUsername()) || user.getEnabled()==null){
            return new  ResponseEntity<>(new MessageResponse("Choose Unique username",false),
                    HttpStatus.OK);
        }
  for(Role role : user.getRoles()){
      if(role.getId()==null){
          return new  ResponseEntity<>(new MessageResponse("Null Role assigned to user",false),
                  HttpStatus.OK);
      }
     }
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
        SecurityContextHolder.clearContext();
        return new  ResponseEntity<>(new MessageResponse("Successfully created user ",false),
                HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> getById(@PathVariable Long id){
        User user = userRepository.findById(id).orElse(null);
        return new  ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> getAll(){
        return new  ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }


    @PutMapping("/update")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> update(@RequestBody User user){
        if(userRepository.existsByUsernameAndIdNotIn(user.getUsername(), Arrays.asList(user.getId()))){
            return new  ResponseEntity<>(new MessageResponse("Choose Unique username",false),
                    HttpStatus.OK);
        }
        for(Role role : user.getRoles()){
            if(role.getId()==null){
                return new  ResponseEntity<>(new MessageResponse("Null Role assigned to user",false),
                        HttpStatus.OK);
            }
        }
        User usd = userRepository.findById(user.getId()).get();
        String newPass = passwordEncoder.encode(user.getPassword());
        String  oldPass = usd.getPassword();
        if(!newPass.equals(oldPass)){
            user.setPassword(newPass);
        }
        userRepository.save(user);
        SecurityContextHolder.clearContext();
        return new  ResponseEntity<>(new MessageResponse("Successfully edited user",false),
                HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
   // //@PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        User applicant = userRepository.findById(id).orElse(null);
        userRepository.delete(applicant);
        return new  ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
