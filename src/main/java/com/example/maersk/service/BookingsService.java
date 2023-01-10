package com.example.maersk.service;


import com.example.maersk.domain.isAvailable;
import com.example.maersk.domain.AvailableSpace;
import com.example.maersk.domain.Bookings;
import com.example.maersk.repo.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookingsService {

    @Autowired
    private BookingsRepo bookingsRepo;
    private WebClient webclient = WebClient.create("http://localhost:8080/api/bookings");

    public void initializeBooking(List<Bookings> bookings){
        Flux<Bookings> saveBookings = bookingsRepo.saveAll(bookings);
        saveBookings.subscribe();
    }

    public Mono<AvailableSpace> getBookingAvailability(){
        return webclient.get().uri("/checkavailable").retrieve().bodyToMono(AvailableSpace.class);
    }

    public Mono<isAvailable> getIsAvailable(){
        isAvailable availableSpace = new isAvailable();
        if(getBookingAvailability().block().getSpaces()>0){
            availableSpace.setAvailable(true);
        }else{
            availableSpace.setAvailable(false);
        }
        return Mono.just(availableSpace);
    }

    public Mono<Bookings> saveBookings(Bookings bookings){
        return bookingsRepo.save(bookings);
    }

}
