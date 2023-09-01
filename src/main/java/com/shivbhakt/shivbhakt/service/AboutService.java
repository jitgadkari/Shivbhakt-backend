package com.shivbhakt.shivbhakt.service;

import com.shivbhakt.shivbhakt.payload.AboutDto;

public interface AboutService {
    AboutDto createAbout(AboutDto aboutDto);
    AboutDto updateAbout(AboutDto aboutDto,Integer aboutId);
    AboutDto getAbout(Integer aboutId);
    void deleteAbout(Integer aboutId);

}
