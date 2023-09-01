package com.shivbhakt.shivbhakt.entity;

import com.shivbhakt.shivbhakt.payload.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
    private String jwtToken;
    private  String username;
    private UserDto user;
}
