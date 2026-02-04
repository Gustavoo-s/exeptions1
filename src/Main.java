import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkIn.before(checkOut) ) {
            System.out.println("Error in reservation: Reservation dates for update must be future dates");
        } else {
            Reservation reservation = new Reservation(roomNumber,checkIn, checkOut);
            System.out.println("Reservation " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());
            reservation.updateDates(checkIn, checkOut);
            Date date = new Date();

            if(checkOut.before(date) ||  checkIn.before(date)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if ((!checkIn.before(checkOut))) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else {
                reservation = new Reservation(roomNumber,checkIn, checkOut);
                System.out.println("Reservation " + reservation);
            }
        }
    }
}
