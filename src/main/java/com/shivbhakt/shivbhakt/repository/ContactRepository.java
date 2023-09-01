package com.shivbhakt.shivbhakt.repository;

import com.shivbhakt.shivbhakt.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
