package andreasjiu.ac.api_jdbc.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    //    saya buat file ini untuk membuat dan memverifikasi si token JWT

    private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 jam

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    //disini ada funsgi generatToken untuk membuat token baru dimana isinya username + waktu expired (1 jam kalau tidak salah)

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(key, SignatureAlgorithm.HS256).compact();
    }

    //lalu method yang ke 2 ada validateToken(String token) untuk memeriksa token valid atau tidak.

    public String validateToken(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException e) {
            return null;
        }
    }
}
