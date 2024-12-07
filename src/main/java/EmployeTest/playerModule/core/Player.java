package EmployeTest.playerModule.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String dob;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER ,mappedBy = "player",orphanRemoval = true)
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Set<Club> clubList = new HashSet<>();

    public void addSingleEmpList(Club club){
        this.clubList.add(club);
        club.setPlayer(this);
    }
    public void setSingleEmpList(Set<Club> lst){
        this.clubList.clear();
        this.clubList.addAll(lst);
    }


}
