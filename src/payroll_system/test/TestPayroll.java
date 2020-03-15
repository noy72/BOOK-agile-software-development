package payroll_system.test;


import org.junit.jupiter.api.Test;
import payroll_system.affiliation.*;
import payroll_system.main.*;
import payroll_system.main.classification.*;
import payroll_system.main.method.*;
import payroll_system.main.schedule.*;
import payroll_system.main.transaction.*;
import payroll_system.main.transaction.add.*;
import payroll_system.main.transaction.change.*;

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

    @Test
    public void testAddHourlyEmployee() {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 1000.00);
        t.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        assertEquals("Bob", e.GetName());

        PaymentClassification pc = e.GetClassification();
        HourlyClassification sc = (HourlyClassification) pc;
        assertNotNull(sc);
        PaymentSchedule ps = e.GetSchedule();
        WeeklySchedule ms = (WeeklySchedule) ps;
        assertNotNull(ms);
        PaymentMethod pm = e.GetMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertNotNull(hm);
    }

    @Test
    public void testAddCommissionedEmployee() {
        int empId = 1;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bob", "Home", 1000.00, 1200.00);
        t.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        assertEquals("Bob", e.GetName());

        PaymentClassification pc = e.GetClassification();
        CommissionedClassification sc = (CommissionedClassification) pc;
        assertNotNull(sc);
        PaymentSchedule ps = e.GetSchedule();
        BiweeklySchedule ms = (BiweeklySchedule) ps;
        assertNotNull(ms);
        PaymentMethod pm = e.GetMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertNotNull(hm);
    }

    @Test
    public void testDeleteEmployee() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(
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

    @Test
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
        assertNotNull(tc);
        assertEquals(8.0, tc.GetHours());

    }

    @Test
    public void testAddServiceCharge() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.Execute();
        TimeCardTransaction tct = new TimeCardTransaction(20011031, 8.0, empId);
        tct.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        Affiliation af = new UnionAffiliation(12.5);
        e.SetAffiliation(af);
        int memberId = 86;
        PayrollDatabase.AddUnionMember(memberId, e);
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, 20011031, 12.95);
        sct.Execute();
        double sc = af.GetServiceCharge(20011031);
        assertEquals(12.95, sc, .001);
    }

    @Test
    public void testChangeNameTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.Execute();
        ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Bob");
        cnt.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        assertEquals("Bob", e.GetName());
    }

    @Test
    public void testChangeAddressTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Homee", 15.25);
        t.Execute();
        ChangeAddressTransaction cnt = new ChangeAddressTransaction(empId, "Home");
        cnt.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        assertEquals("Home", e.GetAddress());
    }

    @Test
    public void testChangeHourlyTransaction() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.Execute();
        ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
        cht.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.GetClassification();
        assertNotNull(pc);
        HourlyClassification hc = (HourlyClassification) pc;
        assertNotNull(hc);
        assertEquals(27.52, hc.GetRate());
        PaymentSchedule ps = e.GetSchedule();
        WeeklySchedule ws = (WeeklySchedule) ps;
        assertNotNull(ws);
    }

    @Test
    public void testChangeSalariedTransaction() {
        int empId = 3;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Lance", "Home", 2500);
        t.Execute();
        ChangeSalariedTransaction cst = new ChangeSalariedTransaction(empId, 2600);
        cst.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.GetClassification();
        assertNotNull(pc);
        SalariedClassification sc = (SalariedClassification) pc;
        assertNotNull(sc);
        assertEquals(2600, sc.GetSalary());
        PaymentSchedule ps = e.GetSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertNotNull(ms);
    }

    @Test
    public void testChangeCommissionedTransaction() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 2.8);
        t.Execute();
        ChangeCommissionedTransaction cct = new ChangeCommissionedTransaction(empId, 2600, 2.4);
        cct.Execute();
        Employee e = PayrollDatabase.GetEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.GetClassification();
        assertNotNull(pc);
        CommissionedClassification cc = (CommissionedClassification) pc;
        assertNotNull(cc);
        assertEquals(2600, cc.GetSalary());
        assertEquals(2.4, cc.GetRate());
        PaymentSchedule ps = e.GetSchedule();
        BiweeklySchedule bws = (BiweeklySchedule) ps;
        assertNotNull(bws);
    }
}
