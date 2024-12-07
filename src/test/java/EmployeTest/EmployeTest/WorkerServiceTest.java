package EmployeTest.EmployeTest;

import EmployeTest.workerModule.core.Workerrepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class WorkerServiceTest {

    @InjectMocks
    private WorkerService srvc;

    @Mock
    private Workerrepo wrr;
    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("When No max salary value found ")
    public void getMaximumAgedEmployee(){

       System.out.println("the max salary is" + srvc.getMaximumAgedEmployee());

    }




}
