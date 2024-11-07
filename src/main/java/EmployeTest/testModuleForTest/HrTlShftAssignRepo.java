package EmployeTest.testModuleForTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface HrTlShftAssignRepo extends JpaRepository<HrTlShftAssign,Long>, JpaSpecificationExecutor<HrTlShftAssign> {
    boolean existsByHrCrEmpAndHrTlShftDtl(HrCrEmp hrCrEmp, HrTlShftDtl hrTlShftDtl);

    @Query("  select x.id as id , " +
            " x.hrTlShftDtl.startTime as start_time ," +
            " x.hrTlShftDtl.endTime as end_time ," +
            " x.title as title from HrTlShftAssign x where x.hrCrEmp.id=:hrcrempId and x.activeStatus=:sts order by x.id desc")
            Map<String, Object> getListByHrCrEmp(@Param("hrcrempId") Long hrcrempId,
                                               @Param("sts")  Boolean sts);

    Boolean existsByTitleAndHrCrEmpLoginCode(String title,String code);

    @Query("  select emp.id , shft.id from HrTlShftAssign x " +
            " left join  x.hrCrEmp emp " +
            " left join x.hrTlShftDtl shft where x.id=2 and emp is not null and shft is not null")
    List<Object[]> getHrCrEmpIdAndShftId();
}
