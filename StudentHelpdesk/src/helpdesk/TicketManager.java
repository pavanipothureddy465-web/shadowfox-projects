package helpdesk;

import java.util.ArrayList;

public class TicketManager {

    private ArrayList<Ticket> tickets;

    public TicketManager() {
        tickets = new ArrayList<>();
    }

    // Add a new ticket
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket added successfully.");
    }

    // View all tickets
    public void viewAllTickets() {

        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        for (Ticket ticket : tickets) {
            ticket.displayTicket();
        }
    }

    // Search ticket by ID
    public void searchTicket(int ticketId) {

        for (Ticket ticket : tickets) {

            if (ticket.getTicketId() == ticketId) {
                ticket.displayTicket();
                return;
            }
        }

        System.out.println("Ticket not found.");
    }

    // Update ticket status
    public void updateTicketStatus(int ticketId, String status) {

        for (Ticket ticket : tickets) {

            if (ticket.getTicketId() == ticketId) {

                String currentStatus = ticket.getStatus();

                if (currentStatus.equals("CLOSED")) {

                    System.out.println("Closed ticket cannot be updated.");

                    return;
                }

                if (currentStatus.equals("RESOLVED") && !status.equals("CLOSED")) {

                    System.out.println("Resolved ticket can only be closed.");

                    return;
                }

                ticket.setStatus(status);

                System.out.println("Ticket status updated successfully.");

                return;
            }
        }

        System.out.println("Ticket not found.");
    }

    // Close ticket
    public void closeTicket(int ticketId) {

        for (Ticket ticket : tickets) {

            if (ticket.getTicketId() == ticketId) {

                String currentStatus = ticket.getStatus();

                if (currentStatus.equals("OPEN")) {

                    System.out.println("Ticket must be resolved before closing.");

                    return;
                }

                if (currentStatus.equals("IN PROGRESS")) {

                    System.out.println("Ticket must be resolved before closing.");

                    return;
                }

                if (currentStatus.equals("CLOSED")) {

                    System.out.println("Ticket is already closed.");

                    return;
                }

                ticket.setStatus("CLOSED");

                System.out.println("Ticket closed successfully.");

                return;
            }
        }

        System.out.println("Ticket not found.");
    }
    public void updateTicketDetails(int ticketId, String title,
            String description, String category,
            String priority) {

for (Ticket ticket : tickets) {

if (ticket.getTicketId() == ticketId) {

ticket.setTitle(title);
ticket.setDescription(description);
ticket.setCategory(category);
ticket.setPriority(priority);

System.out.println("Ticket details updated successfully.");
return;
}
}

System.out.println("Ticket not found.");
}
}