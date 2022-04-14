package com.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthCustomProvider implements AuthenticationProvider {
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (username.equals("admin") && password.equals("asdffdsA1")) {
            List<SimpleGrantedAuthority> roles = Arrays.asList(
                    new SimpleGrantedAuthority("ROLE_ADMIN")
            );
            User user = new User(username, password, roles);
            return new UsernamePasswordAuthenticationToken(user, password, roles);
        }
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(UsernamePasswordAuthenticationToken.class.getName());
    }
}
