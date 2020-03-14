package payroll_system.main;

import java.util.HashMap;
import java.util.Map;

public class UnionAffiliation implements Affiliation {
    private static Map<Long, Double> itsCharge = new HashMap<>();

    public UnionAffiliation(double v) {
    }

    public void AddServiceCharge(long date, double amount) {
        itsCharge.put(date, amount);
    }

    public double GetServiceCharge(long date) {
        return itsCharge.get(date);
    }
}
