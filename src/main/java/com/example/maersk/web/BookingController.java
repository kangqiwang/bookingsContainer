package com.example.maersk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.example.maersk.service.BookingsService;

@Slf4j
@RestController
@RequestMapping(path = "/api/bookings")
public class BookingController {
    @Autowired
    private BookingsService bookingsService;

    @GetMapping("")
    public String mainPage(){
        return "Hello";
    }

//    @PostMapping("/isAvailable")
//    public Mono<Tickets> getAvailableBooking(){
//        return bookingsService.getAllBookings();
//    }
//
//    @PostMapping("")
//
//    @PostMapping("/save")
//    public Mono<Tickets> save(@RequestBody )
}
