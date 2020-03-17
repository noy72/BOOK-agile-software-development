package payroll_system.affiliation;

import java.util.HashMap;
import java.util.Map;

public class UnionAffiliation implements Affiliation {
    private int itsMemberId;
    private double itsDues;
    private static Map<Long, Double> itsCharge = new HashMap<>();

    public UnionAffiliation(int memberId, double dues) {
        super();
        itsMemberId = memberId;
        itsDues = dues;
    }

    public void AddServiceCharge(long date, double amount) {
        itsCharge.put(date, amount);
    }

    public double GetServiceCharge(long date) {
        return itsCharge.get(date);
    }

    public int GetMemberId() {
        return itsMemberId;
    }

    public double GetDues() {
        return itsDues;
    }
}
