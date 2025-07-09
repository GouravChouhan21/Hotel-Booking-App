package com.marriott_hotel.Marriott_Hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import com.marriott_hotel.Marriott_Hotel.entity.Booking;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;

    private List<BookingDTO> bookings = new ArrayList<>();
}

