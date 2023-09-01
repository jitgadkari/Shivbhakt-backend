package com.shivbhakt.shivbhakt.payload;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer contactId;
    private String title;
    private Integer  contactNo;
    private String  contactEmail;
    private String  instaId;
    private String contactDescription;
}
