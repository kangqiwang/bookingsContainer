package com.example.maersk.service;

import com.example.maersk.domain.Bookings;
import com.example.maersk.repo.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class BookingsService {

    @Autowired
    BookingsRepo bookingsRepo;

    public void initializeBooking(List<Bookings> bookings){
        Flux<Bookings> saveBookings = bookingsRepo.saveAll(bookings);
        saveBookings.subscribe();
    }


}
