public class Ticket {
    private int count = 0;
    private int ticket_id;
    private String EventName;
    private Double price;

    public Ticket(){
        this.ticket_id = count++;
        this.EventName = EventName;
        this.price = price;
    }

    public int getticket_id(){
        return ticket_id;
    }

    public String getEventName(){
        return EventName;
    }

    public Double getprice(){
        return price;
    }

    public String getFormattedTicketId() {
        return "T" + ticket_id;
    }
}
