package com.shivbhakt.shivbhakt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer contactId;
    private String title;
    private Integer  contactNo;
    private String  contactEmail;
    private String  instaId;
    private String contactDescription;
}
