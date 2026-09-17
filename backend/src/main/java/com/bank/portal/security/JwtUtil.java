package com.bank.portal.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
@Component
public class JwtUtil {
    @Value("${jwt.secret}") private String secret;
    @Value("${jwt.expiration}") private long exp;
    private Key getKey(){ return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)); }
    public String generateToken(String username){
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+exp)).signWith(getKey(), SignatureAlgorithm.HS256).compact();
    }
    public String extractUsername(String token){ return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody().getSubject(); }
    public boolean validate(String token){ try{Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token); return true;}catch(Exception e){return false;} }
}
