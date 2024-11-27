package lk.coursework.version1;
import java.util.*;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public int getTotalTickets(){
        return totalTickets;
    }

    public int getTicketReleaseRate(){
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity(){
        return maxTicketCapacity;
    }

    public void setTotalTickets(int totalTickets){
        this.totalTickets = totalTickets;
    }

    public void setTicketReleaseRate(int ticketReleaseRate){
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate){
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity){
        this.maxTicketCapacity = maxTicketCapacity;
    }


    //validation of the inputs
    static int validation(Scanner in){
        while(true) {
            if (in.hasNextInt()) {
                int value = in.nextInt();
                if(value>0){
                    return value;
                }
            }
            else{
                in.next();
            }
            System.out.println("Input is invalid. Please enter a positive number.");
        }
    }
}
