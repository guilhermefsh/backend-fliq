package singleagency.project_fliq.services;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import singleagency.project_fliq.dto.LoginRequest;
import singleagency.project_fliq.dto.LoginResponse;
import singleagency.project_fliq.repositories.UserRepository;

import java.time.Instant;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final JwtEncoder jwtEncoder;

    private BCryptPasswordEncoder bPasswordEncoder;

    public LoginResponse authenticateUser(LoginRequest loginRequest) {

        var user = userRepository.findByEmail(loginRequest.email());

        if(user.isEmpty() || !user.get().isLoginCorret(loginRequest, bPasswordEncoder)){
            throw new BadCredentialsException("Email ou senha inválidos");
        }

        var now = Instant.now();
        var expiresIn = 300L;

        var claims = JwtClaimsSet.builder()
                .issuer("fliq")
                .subject(user.get().getUserId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(jwtValue, expiresIn);
    }

}
