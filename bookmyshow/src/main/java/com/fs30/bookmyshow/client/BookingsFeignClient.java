package com.fs30.bookmyshow.client;

import com.fs30.bookmyshow.model.BookingModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("TheaterDetails")
public interface BookingsFeignClient {
    @RequestMapping(method = RequestMethod.POST, value="/bookmyshow/booktickets", consumes = "application/json")
    String getBookingDetails(@RequestBody BookingModel bookingModel);

}
