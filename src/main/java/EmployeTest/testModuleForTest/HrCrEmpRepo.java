package EmployeTest.testModuleForTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HrCrEmpRepo extends JpaRepository<HrCrEmp,Long>, JpaSpecificationExecutor<HrCrEmp> {


}
