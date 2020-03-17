package payroll_system.main.transaction;

import payroll_system.main.Employee;
import payroll_system.main.Paycheck;
import payroll_system.main.PayrollDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaydayTransaction implements Transaction {
    private Calendar itsPayDate;
    private Map<Integer, Paycheck> itsPaychecks;

    public PaydayTransaction(Calendar payDate) {
        itsPayDate = payDate;
        itsPaychecks = new HashMap<>();
    }

    @Override
    public void Execute() {
        List<Integer> empIds = PayrollDatabase.GetAllEmployeeIds();
        for (int empId : empIds) {
            Employee e = PayrollDatabase.GetEmployee(empId);
            if (e.IsPayDate(itsPayDate)) {
                Paycheck pc = new Paycheck(e.GetPayPeriodStartDate(itsPayDate), itsPayDate);
                itsPaychecks.put(empId, pc);
                e.Payday(pc);
            }
        }
    }

    public Paycheck GetPaycheck(int empId) {
        return itsPaychecks.get(empId);
    }
}
