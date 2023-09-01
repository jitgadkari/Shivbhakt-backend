package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.entity.About;
import com.shivbhakt.shivbhakt.entity.Contact;
import com.shivbhakt.shivbhakt.payload.ContactDto;
import com.shivbhakt.shivbhakt.repository.ContactRepository;
import com.shivbhakt.shivbhakt.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact= this.modelMapper.map(contactDto, Contact.class);
        Contact saveContact=this.contactRepository.save(contact);
        ContactDto contactDto1=this.modelMapper.map(saveContact,ContactDto.class);
        return contactDto1;
    }

    @Override
    public ContactDto updateContact(ContactDto contactDto, Integer contactId) {
        Contact contact=this.contactRepository.findById(contactId).orElseThrow(()->new RuntimeException("contact not found with id "+contactId ));
        contact.setTitle(contactDto.getTitle());
        contact.setContactEmail(contactDto.getContactEmail());
        contact.setContactDescription(contactDto.getContactDescription());
        contact.setInstaId(contactDto.getInstaId());
        contact.setContactNo(contactDto.getContactNo());
        ContactDto contactDto1=this.modelMapper.map(contact,ContactDto.class);

        return contactDto1;
    }

    @Override
    public ContactDto getContact(Integer contactId) {
        Contact contact =this.contactRepository.findById(contactId).orElseThrow(()->new RuntimeException("contact not found with id "+contactId));
        ContactDto contactDto=this.modelMapper.map(contact,ContactDto.class);

        return contactDto;
    }
    @Override
    public void deleteContact(Integer contactId) {
        Contact contact = this.contactRepository.findById(contactId).orElseThrow(()->new RuntimeException("about section not found with this Id"+contactId));
        this.contactRepository.delete(contact);
    }
}
