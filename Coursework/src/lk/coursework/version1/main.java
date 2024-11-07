package lk.coursework.version1;

import java.util.Scanner;

import static lk.coursework.version1.Configuration.validation;

public class main {

    private static TicketCollection ticketCollection;
    private static Configuration config = new Configuration();

    public static void input(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter total amount of tickets: ");
        config.setTotalTickets(Configuration.validation(in));

        System.out.println("Enter the ticket release rate: ");
        config.setTicketReleaseRate(Configuration.validation(in));

        System.out.println("Enter the ticket retrieval rate of the customer: ");
        config.setCustomerRetrievalRate(Configuration.validation(in));

        System.out.println("Enter the maximum ticket capacity: ");
        config.setMaxTicketCapacity(Configuration.validation(in));
    }

    public static void main(String[] args){
        input();

        ticketCollection = new TicketCollection(
                config.getTotalTickets(),
                config.getMaxTicketCapacity()
        );
    }
}
