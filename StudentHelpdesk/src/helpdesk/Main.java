package helpdesk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TicketManager manager = new TicketManager();

        int choice;
        int ticketId = 1;

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("       STUDENT HELPDESK");
            System.out.println("================================");
            System.out.println("1. Create Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Search Ticket");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. Close Ticket");
            System.out.println("6. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:

            	int userId;

            	while (true) {

            	    System.out.print("Enter User ID: ");

            	    userId = scanner.nextInt();
            	    scanner.nextLine();

            	    if (userId > 0) {
            	        break;
            	    }

            	    System.out.println("Invalid User ID. Please enter a positive number.");
            	}

                String title;

                	while (true) {

                	    System.out.print("Enter ticket title: ");
                	    title = scanner.nextLine();

                	    if (!title.trim().isEmpty()) {
                	        break;
                	    }

                	    System.out.println("Title cannot be empty. Please enter a valid title.");
                	}

                	String description;

                	while (true) {

                	    System.out.print("Enter description: ");
                	    description = scanner.nextLine();

                	    if (!description.trim().isEmpty()) {
                	        break;
                	    }

                	    System.out.println("Description cannot be empty. Please enter a valid description.");
                	}
                    System.out.println("Select Category:");
                    System.out.println("1. Academics");
                    System.out.println("2. Fees");
                    System.out.println("3. Hostel");
                    System.out.println("4. Transport");
                    System.out.println("5. Technical");
                    System.out.println("6. Other");

                    int categoryChoice;

                    while (true) {

                        System.out.print("Enter category choice: ");

                        categoryChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (categoryChoice >= 1 && categoryChoice <= 6) {
                            break;
                        }

                        System.out.println("Invalid category choice. Please enter 1 to 6.");
                    }

                    String category;

                    switch (categoryChoice) {

                        case 1:
                            category = "Academics";
                            break;

                        case 2:
                            category = "Fees";
                            break;

                        case 3:
                            category = "Hostel";
                            break;

                        case 4:
                            category = "Transport";
                            break;

                        case 5:
                            category = "Technical";
                            break;

                        case 6:
                            category = "Other";
                            break;

                        default:
                            category = "Other";
                            System.out.println("Invalid category. Category set to Other.");
                    }

                    System.out.println();
                    System.out.println("Select Priority:");
                    System.out.println("1. Low");
                    System.out.println("2. Medium");
                    System.out.println("3. High");

                    int priorityChoice;

                    while (true) {

                        System.out.print("Enter priority choice: ");

                        priorityChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (priorityChoice >= 1 && priorityChoice <= 3) {
                            break;
                        }

                        System.out.println("Invalid priority choice. Please enter 1 to 3.");
                    }

                    String priority;

                    switch (priorityChoice) {

                        case 1:
                            priority = "Low";
                            break;

                        case 2:
                            priority = "Medium";
                            break;

                        case 3:
                            priority = "High";
                            break;

                        default:
                            priority = "Medium";
                            System.out.println("Invalid priority. Priority set to Medium.");
                    }

                    Ticket ticket = new Ticket(
                            ticketId,
                            userId,
                            title,
                            description,
                            category,
                            priority
                    );

                    manager.addTicket(ticket);

                    System.out.println("Ticket ID: " + ticketId);

                    ticketId++;

                    break;

                case 2:

                    manager.viewAllTickets();

                    break;

                case 3:

                	int searchId;

                	while (true) {

                	    System.out.print("Enter ticket ID to search: ");

                	    searchId = scanner.nextInt();

                	    if (searchId > 0) {
                	        break;
                	    }

                	    System.out.println("Invalid ticket ID. Please enter a positive number.");
                	}

                	manager.searchTicket(searchId);

                    break;

                case 4:

                	int updateId;

                	while (true) {

                	    System.out.print("Enter ticket ID: ");

                	    updateId = scanner.nextInt();
                	    scanner.nextLine();

                	    if (updateId > 0) {
                	        break;
                	    }

                	    System.out.println("Invalid ticket ID. Please enter a positive number.");
                	}

                    System.out.println("Select New Status:");
                    System.out.println("1. OPEN");
                    System.out.println("2. IN PROGRESS");
                    System.out.println("3. RESOLVED");

                    int statusChoice;

                    while (true) {

                        System.out.print("Enter status choice: ");

                        statusChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (statusChoice >= 1 && statusChoice <= 3) {
                            break;
                        }

                        System.out.println("Invalid status choice. Please enter 1 to 3.");
                    }

                    String status;

                    switch (statusChoice) {

                        case 1:
                            status = "OPEN";
                            break;

                        case 2:
                            status = "IN PROGRESS";
                            break;

                        case 3:
                            status = "RESOLVED";
                            break;

                        default:
                            status = "OPEN";
                            System.out.println("Invalid status. Status set to OPEN.");
                    }

                    manager.updateTicketStatus(updateId, status);
                    break;

                case 5:

                	int closeId;

                	while (true) {

                	    System.out.print("Enter ticket ID to close: ");

                	    closeId = scanner.nextInt();

                	    if (closeId > 0) {
                	        break;
                	    }

                	    System.out.println("Invalid ticket ID. Please enter a positive number.");
                	}

                    manager.closeTicket(closeId);

                    break;

             
                case 6:

                    System.out.println("Thank you for using Student Helpdesk!");
                    scanner.close();
                    return;
                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
   
    
}
