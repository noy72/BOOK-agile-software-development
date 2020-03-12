package payroll_system.test;


import org.junit.jupiter.api.Test;
import payroll_system.main.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestPayroll {
    @Test
    public void testAddSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        assertEquals("Bob", e.GetName());

        PaymentClassification pc = e.GetClassification();
        SalariedClassification sc = (SalariedClassification) pc;
        assertNotNull(sc);
        PaymentSchedule ps = e.GetSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertNotNull(ms);
        PaymentMethod pm = e.GetMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertNotNull(hm);
    }

    public void testDeleteEmployee() {
        int empId = 3;
        AddCommisionedEmployee t = new AddComissionedEmployee(
                empId, "Lance", "Home", 2500, 3.2
        );
        t.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.Execute();
        e = PayrollDatabase.GetEmployee(empId);
        assertNull(e);
    }

    public void testTimeCardTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "ill", "Home", 15.25);
        t.Execute();
        TimeCardTransaction tct = new TimeCardTransaction(20200229, 8.0, empId);
        tct.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.GetClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        assertNotNull(hc);
        TimeCard tc = hc.GetTimeCard(20200229);
        asssertNotNull(tc);
        assertEquals(8.0, tc.GetHours());

    }
}
