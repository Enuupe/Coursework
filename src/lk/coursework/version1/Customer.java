package lk.coursework.version1;

public class Customer implements Runnable{
    private TicketCollection ticketCollection;
    private int customerRetrievalRate;

    public Customer(TicketCollection ticketCollection, int customerRetrievalRate){
        this.ticketCollection = ticketCollection;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    public void run(){
        try{
            while(!Thread.currentThread().isInterrupted()){
                Ticket ticket = new Ticket();
                ticketCollection.RemoveTicket(ticket);
                Thread.sleep(customerRetrievalRate);
            }
        }catch(InterruptedException e){
            System.out.println("The thread is interrupted. Stopping thread.");
            Thread.currentThread().interrupt();
        }
    }
}
