package EmployeTest.applicantModule.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Applicant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String session;
    private String district;
    private String unit;
    private String name;
    private String gender;
    private String groupName;
    private Integer gpaTotal;
    private String hscBoard;

    @CreationTimestamp
    private Date createDate;

}
