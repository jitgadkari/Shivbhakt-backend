package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.payload.AboutDto;
import com.shivbhakt.shivbhakt.payload.ContactDto;
import com.shivbhakt.shivbhakt.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public ResponseEntity<ContactDto> createContactSection(@RequestBody ContactDto contactDto){
        ContactDto contact= this.contactService.createContact(contactDto);
        return  new ResponseEntity<>(contact, HttpStatus.CREATED);
    }
    @PutMapping("/contact/{contactId}")
    public ResponseEntity<ContactDto> updateContactSection(@RequestBody ContactDto contactDto,@PathVariable Integer contactId){
        ContactDto contactDto1= this.contactService.updateContact(contactDto,contactId);
        return  new ResponseEntity<>(contactDto1, HttpStatus.OK);
    }
    @GetMapping("/contact/{contactId}")
    public  ResponseEntity<ContactDto> getContactSection(@PathVariable Integer contactId){
        ContactDto contactDto=this.contactService.getContact(contactId);
        return  new ResponseEntity<>(contactDto,HttpStatus.OK);
    }
    @DeleteMapping("contact/{contactId}")
    public ResponseEntity<String> deleteContactSection(@PathVariable Integer contactId){
        this.contactService.deleteContact(contactId);
        return  new ResponseEntity<>("Contact section deleted with Id "+contactId,HttpStatus.OK);
    }
}
