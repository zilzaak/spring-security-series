package EmployeTest.model;

import EmployeTest.testModuleForTest.EmpAssignment;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmpAssignment.class)
public abstract class EmpAssignment_ {

	public static volatile SingularAttribute<EmpAssignment, String> empCode;
	public static volatile SingularAttribute<EmpAssignment, EmpAssignment> hrCrEmpId;
	public static volatile SingularAttribute<EmpAssignment, String> empName;
	public static volatile SingularAttribute<EmpAssignment, Long> id;

	public static final String EMP_CODE = "empCode";
	public static final String HR_CR_EMP_ID = "hrCrEmpId";
	public static final String EMP_NAME = "empName";
	public static final String ID = "id";

}

