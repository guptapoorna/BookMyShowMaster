package com.fs30.bookmyshow.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Genre")
public class Genre {

    private String type;
}
