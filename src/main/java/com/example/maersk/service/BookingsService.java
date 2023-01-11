package com.example.maersk.service;


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
    // private WebClient webclient = WebClient.create("http://localhost:8080/api/bookings");


	public Flux<Bookings> findAll() {
		// TODO Auto-generated method stub
		return bookingsRepo.findAll();
	}

	public Mono<Bookings> save(Bookings booking) {
        // TODO Auto-generated method stub
		return bookingsRepo.save(booking);
	}


}
