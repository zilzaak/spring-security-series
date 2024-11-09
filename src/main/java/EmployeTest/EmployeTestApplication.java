package EmployeTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import EmployeTest.userDtl.Role;
import EmployeTest.userDtl.RoleRepository;
import EmployeTest.userDtl.User;
import EmployeTest.userDtl.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EmployeTestApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	// disable the user  caching so that for each requests real time user authority related data 
	// fetch and m aintain dynamicity so that no need to restart application again
	public static void main(String[] args) {
		SpringApplication.run(EmployeTestApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {

		User admin = new User();
		admin.setUsername("53157");
		admin.setPassword(passwordEncoder.encode("123456")); // Hash password
		admin.setEnabled(Boolean.TRUE);

		Role adminRole = new Role();
		adminRole.setRoleName("SUPER_ADMIN");
		adminRole.setAuthority("SUPER_ADMIN");


		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		admin.setRoles(adminRoles);
		try{
			for(Role r : adminRoles){
				if(!roleRepository.existsByRoleName(r.getRoleName())){
					r = roleRepository.saveAndFlush(r);
				}
			}
			if(!userRepository.existsByUsername(admin.getUsername())){
				userRepository.save(admin); // Save admin user
				int k = 45;
			}

		}catch (Exception e) {
			
			
		}


	}

}
