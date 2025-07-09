package com.marriott_hotel.Marriott_Hotel.services.Interfac;

import com.marriott_hotel.Marriott_Hotel.dto.Response;
import com.marriott_hotel.Marriott_Hotel.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
