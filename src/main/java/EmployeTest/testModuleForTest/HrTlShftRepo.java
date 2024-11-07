package EmployeTest.testModuleForTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HrTlShftRepo extends JpaRepository<HrTlShftDtl,Long>, JpaSpecificationExecutor<HrTlShftDtl> {




  }
