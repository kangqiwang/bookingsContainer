package com.example.maersk.web;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.lang.model.util.Elements.Origin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.example.maersk.domain.AvailableSpace;
import com.example.maersk.domain.BookingRef;
import com.example.maersk.domain.Bookings;
import com.example.maersk.domain.Container;
import com.example.maersk.domain.ContainerType;
import com.example.maersk.domain.isAvailable;
import com.example.maersk.service.BookingsService;
import com.example.maersk.service.ContainerService;

@RestController
@Slf4j
@RequestMapping(path = "/api/bookings")
public class BookingController {
    @Autowired
    private BookingsService bookingsService;

    @Autowired
    private ContainerService containerService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    /*
     * mock maersk.com/api/bookings/checkAvailable
     * 
     */
    @PostMapping("/checkAvailable")
    public AvailableSpace checkAvailable(@RequestBody Bookings bookings) {
        try {
            AvailableSpace availableSpace = new AvailableSpace();

            Mono<Container> cMono = containerService.findByContainerSizeAndContainerType(bookings.getContainerSize(),
                    bookings.getContainerType());

            if (cMono != null) {
                Container availCont = cMono.share().block();
                if (availCont != null) {
                    availableSpace.setSpaces(availCont.getQuantity());
                }

            } else {
                availableSpace.setSpaces(0);
            }

            return availableSpace;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PostMapping("/isAvailable")
    public isAvailable getAvailableBooking(@RequestBody Bookings bookings) {
        isAvailable isAvailable = new isAvailable();
        try {

        if ((bookings.getContainerSize() == 20 || bookings.getContainerSize() == 40)
                && (bookings.getContainerType().equals(ContainerType.DRY.toString())
                        || bookings.getContainerType().equals(ContainerType.REEFER.toString()))
                && (bookings.getOrigin().length() >= 5 && bookings.getDestination().length() <= 20)
                && (bookings.getDestination().length() >= 5 && bookings.getDestination().length() <= 20)
                && (bookings.getQuantity() >= 5 && bookings.getQuantity() <= 100)) {
            Mono<Container> cMono = containerService.findByContainerSizeAndContainerType(bookings.getContainerSize(),
                    bookings.getContainerType());
            if (cMono != null) {
                Container availCont = cMono.share().block();
                if (availCont != null) {
                    isAvailable.setAvailable(true);
                } else {
                    isAvailable.setAvailable(false);
                }
            }else{
                isAvailable.setAvailable(false);
            }
            
            return isAvailable;
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Sorry there was a problem processing your request");
        }
        } catch (Exception e) {
        e.printStackTrace();
        throw e;
        }
    }

    @PostMapping("/save")
    public BookingRef save(@RequestBody Bookings bookings) throws Exception {
        BookingRef bookingRef = new BookingRef();
        try {

            if ((bookings.getContainerSize() == 20 || bookings.getContainerSize() == 40)
                    && (bookings.getContainerType().equals(ContainerType.DRY.toString())
                            || bookings.getContainerType().equals(ContainerType.REEFER.toString()))
                    && (bookings.getOrigin().length() >= 5 && bookings.getDestination().length() <= 20)
                    && (bookings.getDestination().length() >= 5 && bookings.getDestination().length() <= 20)
                    && (bookings.getQuantity() >= 5 && bookings.getQuantity() <= 100)) {
                Flux<Bookings> bookingsFlux = bookingsService.findAll();
                if (bookingsFlux != null) {
                    if (bookingsFlux.hasElements().share().block()) {
                        Mono<Bookings> bookingsMono = bookingsFlux.last();
                        Mono<Integer> id = bookingsMono.map(Bookings::getBookingRefId);
                        Integer counter = id.share().block();
                        Integer newId = counter + 1;
                        bookings.setBookingRefId(newId);
                    }
                }

                Mono<Bookings> bookingDetail = bookingsService.save(bookings);
                Mono<Integer> refId = bookingDetail.map(Bookings::getBookingRefId);
                bookingRef.setBookingRefId(refId.share().block());

                return bookingRef;
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Sorry there was a problem processing your request");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
