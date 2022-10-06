package dev.boscolo.mktoauth.security;

import dev.boscolo.mktoauth.model.entities.User;
import dev.boscolo.mktoauth.services.UserService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtToken implements TokenEnhancer {

    private final UserService service;

    public JwtToken(UserService service) {
        this.service = service;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        User user = service.findByEmail(authentication.getName()).toEntity();

        //Criando um map e personalizando o corpo do token
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("userFirstName", user.getName());
        map.put("userLastName", user.getLastName());


        //Downcast e inserção de dados no token
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(map);

        return accessToken;
    }

}
