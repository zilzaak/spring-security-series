package userDtl;

import EmployeTest.userDtl.Role;
import EmployeTest.userDtl.User;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SetAttribute<User, Role> roles;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, Boolean> enabled;
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String ROLES = "roles";
	public static final String ID = "id";
	public static final String ENABLED = "enabled";
	public static final String USERNAME = "username";

}

