package lk.coursework.version1;

import java.util.Map;
import java.util.Scanner;

import static lk.coursework.version1.Configuration.validation;

public class main {

    private static TicketCollection ticketCollection;
    private static Configuration config = new Configuration();
    private static boolean isRunning = false;
          
    public static void input(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter total amount of tickets: ");
        config.setTotalTickets(validation(in));

        System.out.println("Enter the ticket release rate: ");
        config.setTicketReleaseRate(validation(in));

        System.out.println("Enter the ticket retrieval rate of the customer: ");
        config.setCustomerRetrievalRate(validation(in));

        System.out.println("Enter the maximum ticket capacity: ");
        config.setMaxTicketCapacity(validation(in));
    }

    public static void main(String[] args){
        input();
        
        Scanner scanner = new Scanner(System.in);

        ticketCollection = new TicketCollection(config.getTotalTickets(), config.getMaxTicketCapacity());

        Thread vendorT = new Thread(new Vendor(ticketCollection, config.getTicketReleaseRate()));
        Thread customerT = new Thread(new Customer(ticketCollection, ticketCollection.getCustomerRetrievalRate()));

        while(true) {
            System.out.println("Enter a command(Start, Stop, Exit) : ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "start":
                    if(!isRunning){
                        isRunning = true;
                        vendorT.start();
                        customerT.start();
                        System.out.println("Threads are starting. ");
                    }
                    else{
                        System.out.println("Threads are already running.");
                    }
                    break;

                case "stop":
                    if(isRunning){
                        vendorT.interrupt();
                        customerT.interrupt();
                        System.out.println("Threads are stopped.");
                    }
                    else{
                        System.out.println("Threads are already stopped. ");
                    }
                    break;

                case "exit":
                    if(isRunning){
                        vendorT.interrupt();
                        customerT.interrupt();
                    }
                    System.out.println("Exiting the program.");
                    return;

                default:
                    System.out.println("Invalid command. Please enter 'Start' , 'Stop' or 'Exit' ");
            }
        }
    }
}
