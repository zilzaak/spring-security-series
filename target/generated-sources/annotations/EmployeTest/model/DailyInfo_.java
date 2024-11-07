package EmployeTest.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DailyInfo.class)
public abstract class DailyInfo_ {

	public static volatile SingularAttribute<DailyInfo, LocalDate> joindate;
	public static volatile SingularAttribute<DailyInfo, Double> averageSalary;
	public static volatile SingularAttribute<DailyInfo, Integer> id;

	public static final String JOINDATE = "joindate";
	public static final String AVERAGE_SALARY = "averageSalary";
	public static final String ID = "id";

}

