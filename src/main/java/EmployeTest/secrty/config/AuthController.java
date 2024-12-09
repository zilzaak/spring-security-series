package EmployeTest.secrty.config;

import EmployeTest.secrty.entity.AuthorityPermission;
import EmployeTest.secrty.service.ApiPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import lombok.var;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApiPermissionService permissionService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/permission/create")
    public ResponseEntity<?> createPermission(@RequestBody AuthorityPermission permission) {
        try{
            permissionService.create(permission);
        }catch (Exception e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Successfully created ");
    }
    @PutMapping("/permission/edit")
    public ResponseEntity<?> editPermission(@RequestBody AuthorityPermission permission) {
        try{
            permissionService.edit(permission);
        }catch (Exception e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Successfully created ");
    }

    @PutMapping("/permission/search")
    public ResponseEntity<?> search(@RequestParam Map<String,String> params) {
        return ResponseEntity.status(200).body(permissionService.search());
    }

    @PostMapping("/generateToken")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationManager.authenticate(authToken);
            final String jwt = jwtUtil.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

}

