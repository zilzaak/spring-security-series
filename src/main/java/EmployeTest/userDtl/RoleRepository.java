package EmployeTest.userDtl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);

    boolean existsByRoleName(String super_admin);
}
