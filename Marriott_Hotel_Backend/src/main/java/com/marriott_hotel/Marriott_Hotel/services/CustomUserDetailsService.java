package com.marriott_hotel.Marriott_Hotel.services;

import com.marriott_hotel.Marriott_Hotel.repo.UserRepository;
import com.marriott_hotel.Marriott_Hotel.exception.OurException; // Custom exception
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new OurException("Username/Email not found"));
    }
}
