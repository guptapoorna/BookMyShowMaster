package com.fs30.bookmyshow.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @Data annotation is combination of @Getter, @Setter, @ToString, @EqualsAndHashCode.  if we don't want all these for any Model class than
 * individual @Getter, or other annotations can be given.
 */
@Document("Movie")
@Data
@AllArgsConstructor // to have constructor with all arguments
@NoArgsConstructor // to have constructor without any arguments
public class Movie {
    /**
     * This annotation is used to ignore the respective field to send as json in response body.
     */
    @JsonIgnore
    private String id;
    /**
     * Below annotation is used to rename the field in response body.
     */
    @JsonProperty("movie_name")
    private String name;
    private String genre;
    private String language;
    private String description;
    /*
        To store YouTube trailer URL.
     */
    private String video_URL;
    /*
        To Store Movie release date
        This date is used to get latest movies to show at application loading page.
     */
    private String start_date;
    /*
        To remove the movies from theaters.
     */
    private LocalDate end_date;

    private String image_address;
    private String movieId;



}
