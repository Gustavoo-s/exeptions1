package model.entities;

import model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.DAYS;

public class Reservation {
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static final SimpleDateFormat sdf = new SimpleDateFormat(("dd/MM/yyyy"));

    public Reservation() {
    }

    public Reservation(int roomNumber, Date checkIn, Date checkOut) throws DomainExceptions {
        if ((!checkIn.before(checkOut))) {
            throw new DomainExceptions("Reservation dates for update must be future dates");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckout() {
        return checkOut;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions {
        Date now = new Date();
        if (checkOut.before(now) || checkIn.before(now)) {
            throw new DomainExceptions(" Reservation dates for update must be future dates");
        } if ((!checkIn.before(checkOut))) {
            throw new DomainExceptions("Reservation dates for update must be future dates");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", checkIn: "
                + sdf.format(checkIn)
                + " , checkOut: "
                + sdf.format(checkOut)
                + " ,"
                + duration()
                + " nights";
    }
}