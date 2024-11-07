package EmployeTest.workerModule.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Taskrepo extends JpaRepository<Task,Integer> , JpaSpecificationExecutor<Task> {

}
