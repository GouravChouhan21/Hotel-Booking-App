package com.marriott_hotel.Marriott_Hotel.services.Interfac;
import com.marriott_hotel.Marriott_Hotel.dto.LoginRequest;
import com.marriott_hotel.Marriott_Hotel.dto.Response;
import com.marriott_hotel.Marriott_Hotel.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
