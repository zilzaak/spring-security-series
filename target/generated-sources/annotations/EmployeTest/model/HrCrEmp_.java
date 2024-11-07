package EmployeTest.model;

import EmployeTest.testModuleForTest.EmpAssignment;
import EmployeTest.testModuleForTest.HrCrEmp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HrCrEmp.class)
public abstract class HrCrEmp_ {

	public static volatile SingularAttribute<HrCrEmp, String> displayName;
	public static volatile SingularAttribute<HrCrEmp, EmpAssignment> assignment;
	public static volatile SingularAttribute<HrCrEmp, String> loginCode;
	public static volatile SingularAttribute<HrCrEmp, Long> id;

	public static final String DISPLAY_NAME = "displayName";
	public static final String ASSIGNMENT = "assignment";
	public static final String LOGIN_CODE = "loginCode";
	public static final String ID = "id";

}

