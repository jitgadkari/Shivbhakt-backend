package com.shivbhakt.shivbhakt.Security;

import com.shivbhakt.shivbhakt.entity.User;
import com.shivbhakt.shivbhakt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user=this.userRepository.findByEmail(username).orElseThrow(()->new RuntimeException("User not found with this email "+ username));
        return user;
    }
}
