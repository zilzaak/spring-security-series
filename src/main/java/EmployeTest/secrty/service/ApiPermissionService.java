package EmployeTest.secrty.service;

import EmployeTest.dto.MessageResponse;
import EmployeTest.secrty.entity.AuthorityPermission;
import EmployeTest.secrty.repo.AuthorityPermissionRepository;
import EmployeTest.userDtl.RoleRepository;
import EmployeTest.userDtl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ApiPermissionService {

  @Autowired
  private AuthorityPermissionRepository authorityPermissionRepository;
  @Autowired
  private RoleRepository roleRepository;
  public MessageResponse create(AuthorityPermission permission){
       if(!roleRepository.existsByRoleName(permission.getRoleName())){
           throw new RuntimeException("The given authority does not exist");
       }
       if(authorityPermissionRepository.existsByApiPatternAndRoleName(permission.getApiPattern(),permission.getRoleName())){
         throw new RuntimeException("Already created for this employee");
       }
       authorityPermissionRepository.saveAndFlush(permission);
       return new MessageResponse("Successfully edited...");
  }

    public MessageResponse edit(AuthorityPermission permission){
      if(!roleRepository.existsByRoleName(permission.getRoleName())){
        throw new RuntimeException("The given authority does not exist");
      }
      if(authorityPermissionRepository.existsByApiPatternAndRoleNameAndIdNotIn(permission.getApiPattern(),permission.getRoleName(), Arrays.asList(permission.getId()))){
        throw new RuntimeException("Already created for this employee");
      }
      authorityPermissionRepository.saveAndFlush(permission);
      return new MessageResponse("Successfully edited...");
    }


    public List<Map<String,String>> search(Map<String,String> param) {
      return new ArrayList<>();
       }
}
