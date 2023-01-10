// package com.example.maersk;

// import static org.mockito.Mockito.times;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.UUID;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.reactive.server.WebTestClient;

// import com.example.maersk.service.BookingsService;

// import reactor.core.publisher.Mono;

// import com.example.maersk.domain.AvailableSpace;
// import com.example.maersk.domain.Bookings;
// import com.example.maersk.domain.ContainerType;
// import com.example.maersk.domain.isAvailable;

// public class BookingsControllerTest {

//     @MockBean
//     BookingsService bookingsService;

//     @Autowired
//     private WebTestClient webTestClient;

//     @Test
//     void isAvailable() {
//         isAvailable isAvailable = new isAvailable();
//         isAvailable.setAvailable(true);

//         Mockito.when(bookingsService.getIsAvailable()).thenReturn(Mono.just(isAvailable));

//         webTestClient.get().uri("/api/bookings/checkavailable").exchange().expectStatus().isOk()
//                 .expectBodyList(Bookings.class);

//         Mockito.verify(bookingsService, times(1)).getBookingAvailability();
//     }


//     @Test
//     void checkAvailable(){
//         AvailableSpace availableSpace = new AvailableSpace();
//         availableSpace.setSpaces(10);
//         Mockito.when(bookingsService.getBookingAvailability()).thenReturn(Mono.just(availableSpace));

// 		webTestClient.get().uri("/api/bookings/checkavailable").exchange().expectStatus().isOk()
// 				.expectBodyList(AvailableSpace.class);

// 		Mockito.verify(bookingsService, times(1)).getBookingAvailability();

//     }


//     @Test
// 	void save() {
//         UUID uuid = UUID.randomUUID();
// 		Bookings bookings = new Bookings();
//         bookings.setId(uuid);
// 		bookings.setContainerSize(5);
// 		bookings.setContainerType(ContainerType.DRY);
// 		bookings.setOrigin("test");
// 		bookings.setDestination("Test");
// 		bookings.setQuantity(5);
// 		bookings.setTimeStamp(new Date());
        
//         webTestClient.post().uri("/api/bookings").body(Mono.just(bookings), Bookings.class).exchange().expectStatus().isOk();
// 	}


// }
