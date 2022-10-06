package dev.boscolo.mktoauth.services;

import dev.boscolo.mktoauth.feignclients.UserFeignClient;
import dev.boscolo.mktoauth.model.dto.UserGetDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public UserGetDTO findByEmail(String email){
        return userFeignClient.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userFeignClient.findByEmail(username) == null ){
            throw new UsernameNotFoundException("Email not found.");
        }
        return userFeignClient.findByEmail(username).toEntity();
    }
}
