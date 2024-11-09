package EmployeTest.playerModule.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Player.class)
public abstract class Player_ {

	public static volatile SingularAttribute<Player, String> country;
	public static volatile SetAttribute<Player, Club> clubList;
	public static volatile SingularAttribute<Player, String> dob;
	public static volatile SingularAttribute<Player, String> name;
	public static volatile SingularAttribute<Player, Long> id;

	public static final String COUNTRY = "country";
	public static final String CLUB_LIST = "clubList";
	public static final String DOB = "dob";
	public static final String NAME = "name";
	public static final String ID = "id";

}

