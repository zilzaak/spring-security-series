package EmployeTest.testModuleForTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HrTlShftAssign.class)
public abstract class HrTlShftAssign_ {

	public static volatile SingularAttribute<HrTlShftAssign, Boolean> activeStatus;
	public static volatile SingularAttribute<HrTlShftAssign, HrTlShftDtl> hrTlShftDtl;
	public static volatile SingularAttribute<HrTlShftAssign, HrCrEmp> hrCrEmp;
	public static volatile SingularAttribute<HrTlShftAssign, Long> id;
	public static volatile SingularAttribute<HrTlShftAssign, String> title;

	public static final String ACTIVE_STATUS = "activeStatus";
	public static final String HR_TL_SHFT_DTL = "hrTlShftDtl";
	public static final String HR_CR_EMP = "hrCrEmp";
	public static final String ID = "id";
	public static final String TITLE = "title";

}

