package userDtl;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, String> authority;
	public static volatile SingularAttribute<Role, String> roleName;
	public static volatile SingularAttribute<Role, Long> id;

	public static final String AUTHORITY = "authority";
	public static final String ROLE_NAME = "roleName";
	public static final String ID = "id";

}

