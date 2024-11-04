package lk.coursework.version1;
import java.util.*;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;


    public void input(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter total amount of tickets: ");
        this.totalTickets = validation(in);

        System.out.println("Enter the ticket release rate: ");
        this.ticketReleaseRate = validation(in);

        System.out.println("Enter the ticket retrieval rate of the customer: ");
        this.customerRetrievalRate = validation(in);

        System.out.println("Enter the maximum ticket capacity: ");
        this.maxTicketCapacity = validation(in);

    }

    //validation of the inputs
    private static int validation(Scanner in){
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
