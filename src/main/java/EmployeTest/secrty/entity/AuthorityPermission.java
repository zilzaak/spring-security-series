package EmployeTest.secrty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuthorityPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;        // Role name, e.g., "SUPER_ADMIN"
    private String apiPattern;      // API pattern, e.g., "/player/**"

    // Constructors, getters, and setters

    public AuthorityPermission() {}

    public AuthorityPermission(String roleName, String apiPattern) {
        this.roleName = roleName;
        this.apiPattern = apiPattern;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getApiPattern() {
        return apiPattern;
    }

    public void setApiPattern(String apiPattern) {
        this.apiPattern = apiPattern;
    }
}

