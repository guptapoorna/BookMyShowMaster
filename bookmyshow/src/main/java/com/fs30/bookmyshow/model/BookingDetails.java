package com.fs30.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {
    public boolean seatsAvailable;
    public String numberofseatsavailable;
    public List<BookedSeats> bookedSeats;
}
