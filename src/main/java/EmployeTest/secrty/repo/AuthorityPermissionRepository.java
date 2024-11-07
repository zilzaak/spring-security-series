package EmployeTest.secrty.repo;

import EmployeTest.secrty.entity.AuthorityPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuthorityPermissionRepository extends JpaRepository<AuthorityPermission, Long> {
    List<AuthorityPermission> findByRoleName(String roleName);
}
