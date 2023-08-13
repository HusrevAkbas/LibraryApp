package app.library.utilities.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtTokenManager {
    @Autowired
    private JwtEncoder encoder;
    @Autowired
    private JwtDecoder decoder;

    public String generateToken(Authentication auth){
        Instant now = Instant.now();

        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        final long VALIDITY_TIME_AS_SECONDS = 60 * 60 * 24 * 7;
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(VALIDITY_TIME_AS_SECONDS))
                .subject(auth.getName())
                .claim("roles", scope)
                .build();

        return encoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
}
