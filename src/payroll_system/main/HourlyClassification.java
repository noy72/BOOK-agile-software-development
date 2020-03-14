package payroll_system.main;

import java.util.HashMap;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {
    Map<Long, TimeCard> timeCards;

    public HourlyClassification(double itsHourlyRate) {
        super();
        timeCards = new HashMap<Long, TimeCard>();
    }

    public void AddTimeCard(TimeCard timeCard) {
        timeCards.put(timeCard.GetDate(), timeCard);
    }

    public TimeCard GetTimeCard(long date) {
        return timeCards.get(date);
    }
}
