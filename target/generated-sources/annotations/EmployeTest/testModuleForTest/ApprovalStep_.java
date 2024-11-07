package EmployeTest.testModuleForTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ApprovalStep.class)
public abstract class ApprovalStep_ {

	public static volatile SingularAttribute<ApprovalStep, Long> thisApprovalNode;
	public static volatile SingularAttribute<ApprovalStep, String> approvalGroupName;
	public static volatile SingularAttribute<ApprovalStep, Long> id;
	public static volatile SingularAttribute<ApprovalStep, ApprovalProcess> approvalProcess;
	public static volatile SingularAttribute<ApprovalStep, Long> nextApprovalNode;
	public static volatile SingularAttribute<ApprovalStep, Long> preApprovalNode;

	public static final String THIS_APPROVAL_NODE = "thisApprovalNode";
	public static final String APPROVAL_GROUP_NAME = "approvalGroupName";
	public static final String ID = "id";
	public static final String APPROVAL_PROCESS = "approvalProcess";
	public static final String NEXT_APPROVAL_NODE = "nextApprovalNode";
	public static final String PRE_APPROVAL_NODE = "preApprovalNode";

}

