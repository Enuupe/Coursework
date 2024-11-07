package lk.coursework.version1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketCollection extends Configuration{
    // define variables
    private static TicketCollection instance;
    private Queue<Ticket> tickets = new LinkedList<>(); // to store ticket information
    private int maxTicketCapacity;
    private int totalTickets;
    private int soldTickets;
    private final Lock lock = new ReentrantLock();
    private Map<String, Double> Eventprices = new HashMap<>(); // to store the prices according to the event

    // constructor
    TicketCollection() {
        super();
    }

    public static TicketCollection getInstance() {
        if (instance == null) {
            instance = new TicketCollection();
        }
        return instance;
    }

    public synchronized boolean addTicket(Ticket ticket) {

        lock.lock();
        try {
            if (tickets.size() < maxTicketCapacity) {
                tickets.add(ticket);
                System.out
                        .println("The ticket " + ticket.getticket_id() + "for :" + ticket.getEventName() + " is added");
                totalTickets++;
                return true;
            } else {
                System.out.println("The ticket cannot be added because the capacity is exceeded.");
                return false;
            }

        } finally {
            lock.unlock();
        }
    }

    public synchronized Ticket RemoveTicket() {

        lock.lock();
        try {
            if (!tickets.isEmpty()) {
                Ticket ticket = tickets.poll();
                System.out.println("The ticket is here: " + ticket.getticket_id() + " for event: "
                        + ticket.getEventName() + " for: Rs." + ticket.getprice());
                soldTickets++;
                Eventprices.merge(ticket.getEventName(), ticket.getprice(), Double::sum);
                return ticket;
            } else {
                System.out.println("There are no more tickets. ");
                return null;
            }
        } finally {
            lock.unlock();
        }
    }

    public void salesReport() {
        System.out.println("Total Tickets in the pool: " + totalTickets);
        System.out.println("Total Tickets sold: " + soldTickets);
        System.out.println("Tickets remaining: " + (totalTickets - soldTickets));

        System.out.println("SALES REPORT: ");
        for (Map.Entry<String, Double> entry : Eventprices.entrySet()) {
            System.out.println("Event: " + entry.getKey() + " Total Price of sold tickets: " + entry.getValue());
        }
    }

}
