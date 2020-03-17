package payroll_system.main.schedule;

import java.util.Calendar;

public abstract class PaymentSchedule {
    public abstract boolean IsPayDate(Calendar payDate);
}
