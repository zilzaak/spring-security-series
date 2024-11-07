package EmployeTest.testModuleForTest;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ASSIGNMENT")
public class EmpAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="emp_name")
    private String empName;
    @Column(name="emp_code")
    private String empCode;


//    @JoinColumn(name = "HR_CR_EMP_ID")
//    private Long hrCrEmpId;

    @OneToOne(fetch = FetchType.LAZY,targetEntity= EmpAssignment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "HR_CR_EMP_ID")
    @NotFound(action= NotFoundAction.IGNORE)
    @JsonManagedReference
    private HrCrEmp hrCrEmpId;

}
