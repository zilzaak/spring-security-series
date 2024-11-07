package EmployeTest.testModuleForTest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMP")
public class HrCrEmp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="display_name")
    private String displayName;
    @Column(name="login_code")
    private String loginCode;

    //,mappedBy="hrCrEmpId"
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY,mappedBy="hrCrEmpId",cascade = CascadeType.ALL)
    private EmpAssignment assignment;
}
