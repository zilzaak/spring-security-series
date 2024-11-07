package EmployeTest.testModuleForTest;

import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HrTlShftDtl.class)
public abstract class HrTlShftDtl_ {

	public static volatile SingularAttribute<HrTlShftDtl, LocalTime> startTime;
	public static volatile SingularAttribute<HrTlShftDtl, Long> id;
	public static volatile SingularAttribute<HrTlShftDtl, LocalTime> endTime;
	public static volatile SingularAttribute<HrTlShftDtl, String> title;

	public static final String START_TIME = "startTime";
	public static final String ID = "id";
	public static final String END_TIME = "endTime";
	public static final String TITLE = "title";

}

