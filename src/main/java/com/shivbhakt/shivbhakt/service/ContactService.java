package com.shivbhakt.shivbhakt.service;

import com.shivbhakt.shivbhakt.payload.ContactDto;

public interface ContactService {
    ContactDto createContact(ContactDto contactDto);
    ContactDto updateContact(ContactDto contactDto,Integer contactId);
    ContactDto getContact(Integer contactId);
    void  deleteContact(Integer contactId);
}
