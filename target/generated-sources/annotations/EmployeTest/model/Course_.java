package EmployeTest.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, String> name;
	public static volatile SetAttribute<Course, Student> students;
	public static volatile SingularAttribute<Course, Long> id;

	public static final String NAME = "name";
	public static final String STUDENTS = "students";
	public static final String ID = "id";

}

