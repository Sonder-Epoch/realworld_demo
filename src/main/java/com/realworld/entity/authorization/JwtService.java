package com.realworld.entity.authorization;

import com.realworld.entity.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface JwtService {
    String toToken(User user);

    Optional<String> getSubFromToken(String token);
}
