package EmployeTest.testModuleForTest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class ApprovalStep {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String approvalGroupName;
    private Long thisApprovalNode;
    private Long nextApprovalNode;
    private Long preApprovalNode;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private ApprovalProcess approvalProcess;

}
