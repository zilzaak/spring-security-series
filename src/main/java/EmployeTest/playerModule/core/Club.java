package EmployeTest.playerModule.core;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String establisYear;
    private String location;
    private String playingyear;

    @ManyToOne
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Player player;

}
