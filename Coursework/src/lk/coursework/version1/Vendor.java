package lk.coursework.version1;

import java.util.Map;

public class Vendor implements Runnable {
    private Map<String, Double> Eventprices; // to store the prices according to the event
    private TicketCollection ticketCollection;
    private int ticketReleaseRate;

    public Vendor(Map<String, Double> Eventptices, TicketCollection ticketCollection, int ticketReleaseRate) {
        this.Eventprices = Eventptices;
        this.ticketCollection = ticketCollection;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {

    }
}
