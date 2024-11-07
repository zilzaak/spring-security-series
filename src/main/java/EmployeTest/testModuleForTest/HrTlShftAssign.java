package EmployeTest.testModuleForTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HR_TL_SHFT_ASSIGN")
public class HrTlShftAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hr_cr_emp_id")
    private HrCrEmp hrCrEmp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hr_tl_shft_dtl_id")
    private HrTlShftDtl hrTlShftDtl;

    private Boolean activeStatus;

}
