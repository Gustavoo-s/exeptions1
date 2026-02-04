package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.DAYS;

public class Reservation {
    private int roomNumber;
    private Date checkIn;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat(("dd/MM/yyyy"));

    public Reservation() {
    }

    public Reservation(int roomNumber, Date checkIn, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckout() {
        return checkout;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration() {
        long diff = checkout.getTime() - checkIn.getTime();
        return DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkout) {
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", checkIn: "
                + sdf.format(checkIn)
                + " , checkout: "
                + sdf.format(checkout)
                + " ,"
                + duration()
                + " nights";
    }
}