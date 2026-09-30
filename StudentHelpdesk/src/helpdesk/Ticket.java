package helpdesk;

public class Ticket {

    private int ticketId;
    private int userId;
    private String title;
    private String description;
    private String category;
    private String priority;
    private String status;

    public Ticket(int ticketId, int userId, String title, String description,
                  String category, String priority) {

        this.ticketId = ticketId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.status = "OPEN";
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayTicket() {

        System.out.println("------------------------------");
        System.out.println("Ticket ID   : " + ticketId);
        System.out.println("User ID     : " + userId);
        System.out.println("Title       : " + title);
        System.out.println("Description : " + description);
        System.out.println("Category    : " + category);
        System.out.println("Priority    : " + priority);
        System.out.println("Status      : " + status);
        System.out.println("------------------------------");
    }
}