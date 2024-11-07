package EmployeTest.applicantModule.core;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Data
public class ApplicantDTO {
    private Long id;
    private String session;
    private String district;
    private String unit;
    private Long name;
    private String gender;
    private String groupName;
    private String gpaTotal;
    private String hscBoard;

}
