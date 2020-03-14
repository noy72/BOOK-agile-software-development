package payroll_system.main.classification;

import payroll_system.main.TimeCard;

import java.util.HashMap;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {
    Map<Long, TimeCard> timeCards;

    public HourlyClassification(double itsHourlyRate) {
        super();
        timeCards = new HashMap<>();
    }

    public void AddTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.GetDate(), timeCard);
    }

    public TimeCard GetTimeCard(long date) {
        return timeCards.get(date);
    }
}
