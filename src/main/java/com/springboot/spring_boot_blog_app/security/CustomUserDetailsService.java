package com.springboot.spring_boot_blog_app.security;

import com.springboot.spring_boot_blog_app.entity.User;
import com.springboot.spring_boot_blog_app.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String usernameOremail) throws UsernameNotFoundException {
       User user= userRepository.findByUsernameOrEmail(usernameOremail,usernameOremail)
                .orElseThrow(()->new UsernameNotFoundException("User not found with username or Email: "+ usernameOremail));

       Set<GrantedAuthority> authorities=user.getRoles().stream().map((role)->new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}
