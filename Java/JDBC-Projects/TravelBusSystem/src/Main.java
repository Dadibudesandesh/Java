import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        //INITIALIZE CLASSES
        DB db = new DB();
        Passenger passenger = new Passenger();
        Bus bus = new Bus();
        Route route = new Route();
        Schedule schedule = new Schedule();
        Booking booking = new Booking();
        Scanner scanner = new Scanner(System.in);

        // CALLING THE METHODS
        db.createConnection();

        while (true) {
            System.out.println("\n==============| BUS TRAVEL AGENCY |==============");
            System.out.println(" 1] ------> ADD PASSENGER");
            System.out.println(" 2] ------> VIEW PASSENGERS");
            System.out.println(" 3] ------> UPDATE PASSENGERS");
            System.out.println(" 4] ------> ADD BUS");
            System.out.println(" 5] ------> VIEW BUSES");
            System.out.println(" 6] ------> UPDATE BUSES");
            System.out.println(" 7] ------> ADD ROUTE");
            System.out.println(" 8] ------> VIEW ROUTES");
            System.out.println(" 9] ------> UPDATE ROUTES");
            System.out.println("10] ------> ADD SCHEDULE");
            System.out.println("11] ------> VIEW SCHEDULES");
            System.out.println("12] ------> UPDATE SCHEDULES");
            System.out.println("13] ------> BOOK TICKET");
            System.out.println("14] ------> CANCEL TICKET");
            System.out.println("15] ------> VIEW BOOKING");
            System.out.println("16] ------> EXIT");
            System.out.println("=================================================");
            System.out.print("Enter choice : ");
            int ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    passenger.addPassenger();
                    break;
                case 2:
                    passenger.getAllPassengers();
                    break;
                case 3:
                    passenger.updatePassenger();
                    break;
                case 4:
                    bus.addBus();
                    break;
                case 5:
                    bus.getAllBuses();
                    break;
                case 6:
                    bus.updateBus();
                    break;
                case 7:
                    route.addRoute();
                    break;
                case 8:
                    route.getAllRoutes();
                    break;
                case 9:
                    route.updateRoute();
                    break;
                case 10:
                    schedule.addSchedule();
                    break;
                case 11:
                    schedule.getAllSchedules();
                    break;
                case 12:
                    schedule.updateSchedules();
                    break;
                case 13:
                    booking.bookTicket();
                    break;
                case 14:
                    booking.cancelTicket();
                    break;
                case 15:
                    booking.getAllBooking();
                    break;
                case 16:
                    exit(1);
                default:
                    System.out.println("Enter valid choice!!!!!!!");
                    break;
            }

        }
    }
}