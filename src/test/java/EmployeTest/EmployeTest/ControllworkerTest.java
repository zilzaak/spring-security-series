package EmployeTest.EmployeTest;

import EmployeTest.workerModule.core.Task;
import EmployeTest.workerModule.core.Worker;
import EmployeTest.workerModule.core.Workerrepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ControllworkerTest {
    @Autowired
    private Workerrepo wrr;

    @Test
    public void omarBorkanAlGala(){
        Worker wk=wrr.findById(3).get();
        Task w=wk.getTasks().get(0);
        System.out.println("worker name is "+w.getName()+" worker age"+w.getName()+" worker"+w.getDate());
        int h=45+556;
        int k=h+2;
        System.out.println("worker name "+w.getName()+" worker age"+w.getName()+" worker"+w.getDate());

    }


    @Test
    public void  xxxxxxxxxxxxxx(){
        int maxsalary= wrr.getMaxSalary();
        System.out.println("max salary ius "+maxsalary);
    }

}
