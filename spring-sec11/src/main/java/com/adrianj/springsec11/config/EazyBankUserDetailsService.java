package com.adrianj.springsec11.config;

import com.adrianj.springsec11.db.entities.CustomerEntity;
import com.adrianj.springsec11.db.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    // Here is where the Authentication details are got. UserDetails is got from the db.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customer = customerRepository.findByEmail(username).orElseThrow(() -> new
                UsernameNotFoundException("User details not found for the user: " + username));
        // get authorities
        List<GrantedAuthority> authorities = customer.getAuthorityEntities().stream()
                .map(it->new SimpleGrantedAuthority(it.getName()))
                .collect(Collectors.toUnmodifiableList());
        return new User(customer.getEmail(), customer.getPwd(), authorities);
    }
}