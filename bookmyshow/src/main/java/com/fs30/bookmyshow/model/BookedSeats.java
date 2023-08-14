package com.fs30.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookedSeats {
    public String rowid;
    public String columnid;
}
