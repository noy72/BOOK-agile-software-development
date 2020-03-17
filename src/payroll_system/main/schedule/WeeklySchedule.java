package payroll_system.main.schedule;

import java.util.Calendar;

public class WeeklySchedule extends PaymentSchedule {
    @Override
    public boolean IsPayDate(Calendar payDate) {
        return false;
    }
}
