package com.shivbhakt.shivbhakt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name="Role")
    private Role role;

//    @Override
//    public SimpleGrantedAuthority extends GrantedAuthority> getAuthorities() {
////        List<SimpleGrantedAuthority> authorities=this.role.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
////        return authorities;
//        SimpleGrantedAuthority authorities= new SimpleGrantedAuthority(role.name);
//        return authorities;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<Role> EXPECTED_LIST = Arrays.asList(Role.Normal, Role.Admin);
//        String strings = EXPECTED_LIST.stream()
//                .map(n -> String.valueOf(n))
//                .collect(Collectors.joining("-", "{", "}"));
//        List<SimpleGrantedAuthority> authorities= Collections.singletonList(new SimpleGrantedAuthority(strings));
//        Collection<SimpleGrantedAuthority> collection = new SimpleGrantedAuthority(EXPECTED_LIST);
        SimpleGrantedAuthority authorities=new SimpleGrantedAuthority(role.name());
        return Collections.singleton(authorities);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}


