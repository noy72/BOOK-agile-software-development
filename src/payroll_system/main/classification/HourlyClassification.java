package payroll_system.main.classification;

import payroll_system.main.TimeCard;

import java.util.HashMap;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {
    double itsRate;
    Map<Long, TimeCard> timeCards;

    public HourlyClassification(double rate) {
        super();
        itsRate = rate;
        timeCards = new HashMap<>();
    }

    public void AddTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.GetDate(), timeCard);
    }

    public TimeCard GetTimeCard(long date) {
        return timeCards.get(date);
    }

    public double GetRate() {
        return itsRate;
    }
}
