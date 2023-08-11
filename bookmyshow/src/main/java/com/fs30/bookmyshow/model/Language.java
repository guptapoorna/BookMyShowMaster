package com.fs30.bookmyshow.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Language")
public class Language {
    private String name;
}
