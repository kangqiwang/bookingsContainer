package com.example.maersk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import com.example.maersk.domain.AvailableSpace;
import com.example.maersk.domain.Bookings;
import com.example.maersk.domain.isAvailable;
import com.example.maersk.service.BookingsService;

@Slf4j
@RestController
@RequestMapping(path = "/api/bookings")
public class BookingController {
    @Autowired
    private BookingsService bookingsService;

    
    @GetMapping("/checkAvailable")
    public Mono<AvailableSpace> getAvailableSpace(){
        return bookingsService.getBookingAvailability();
    }

   @PostMapping("/isAvailable")
   public Mono<isAvailable> getAvailableBooking(){
       return bookingsService.getIsAvailable();
   }

   @PostMapping("/save")
   public Mono<Bookings> save(@RequestBody Bookings bookings){
        return bookingsService.saveBookings(bookings);
   }
}
