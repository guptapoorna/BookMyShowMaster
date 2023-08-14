package com.fs30.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class BookingModel {

    public String movieId;
    public String date;
    public String theaterid;
    public String showid;
    public String rowid;
    public String columnid;
    public String personname;
    public String personage;
}
