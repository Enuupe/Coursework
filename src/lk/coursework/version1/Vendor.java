package lk.coursework.version1;

import java.util.Map;

public class Vendor implements Runnable {
    private Map<String, Double> Eventprices; // to store the prices according to the event
    private TicketCollection ticketCollection;
    private int ticketReleaseRate;

    public Vendor(TicketCollection ticketCollection, int ticketReleaseRate) {
        this.ticketCollection = ticketCollection;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {
        while(true){
            try{
                while(!Thread.currentThread().isInterrupted()) {
                    Ticket ticket = new Ticket();
                    ticketCollection.addTicket(ticket);
                    Thread.sleep(ticketReleaseRate);
                }
            }
            catch(InterruptedException e){
                System.out.println("The thread is interrupted. Stopping thread");
                Thread.currentThread().interrupt();
            }
        }
    }
}
