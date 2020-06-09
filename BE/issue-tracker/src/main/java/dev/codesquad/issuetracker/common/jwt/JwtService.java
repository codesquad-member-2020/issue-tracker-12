package dev.codesquad.issuetracker.common.jwt;

import dev.codesquad.issuetracker.common.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class JwtService {

    private final String SECRET_KEY = "secret";
    private final String AUTHORIZATION = "Authorization";

    public String createToken(String userId) {
        final String TOKEN_IDENTIFIER_NAME = "group";
        final String TOKEN_IDENTIFIER_VALUE = "code-squad";
        final int EXPIRATION_TIME = 1000 * 60 * 60 * 10;
        Map<String, Object> header = new HashMap<>();
        header.put("type", "JWT");
        header.put("Algorithm", "HS256");
        return Jwts.builder()
            .setHeader(header)
            .claim(TOKEN_IDENTIFIER_NAME, TOKEN_IDENTIFIER_VALUE)
            .setSubject(userId)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new InvalidTokenException(e.getMessage());
        }
    }

    public String getUserId() {
        final String GUEST = "guest";
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .currentRequestAttributes()).getRequest();
        String token = request.getHeader(AUTHORIZATION);
        if (token != null) {
            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return claims.getBody().getSubject();
        }
        return GUEST;
    }
}
