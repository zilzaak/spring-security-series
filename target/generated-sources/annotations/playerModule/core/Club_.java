package playerModule.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Club.class)
public abstract class Club_ {

	public static volatile SingularAttribute<Club, String> playingyear;
	public static volatile SingularAttribute<Club, String> name;
	public static volatile SingularAttribute<Club, String> location;
	public static volatile SingularAttribute<Club, Long> id;
	public static volatile SingularAttribute<Club, String> establisYear;
	public static volatile SingularAttribute<Club, Player> player;

	public static final String PLAYINGYEAR = "playingyear";
	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String ESTABLIS_YEAR = "establisYear";
	public static final String PLAYER = "player";

}

