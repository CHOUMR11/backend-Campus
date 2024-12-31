package tn.essat.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.essat.model.Administrateur;  // Utilisation de Administrateur ici

@Component
public class GestionToken {

    @Value("${auth.expiration}")
    private Long TOKEN_VALIDITY = 604800L;

    @Value("${auth.secret}")
    private String TOKEN_SECRET;

    // Générer un token JWT pour un administrateur
    public String generateToken(Administrateur administrateur) {
        return Jwts.builder()
                .setSubject(administrateur.getUsername())  // Utilisation de username de Administrateur
                .claim("userId", administrateur.getId())   // Utilisation ID de Administrateur
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())  // Définir la date d'expiration
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();
    }

    // Extraire le nom d'utilisateur du token
    public String getUserNameFromToken(String token) {
        Claims claims = getClaims(token);
        return claims != null ? claims.getSubject() : null;
    }

    // Générer la date d'expiration du token
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);  // Convertir en millisecondes
    }

    // Vérifier si le token est valide pour un administrateur donné
    public boolean isTokenValid(String token, Administrateur administrateur) {
        String username = getUserNameFromToken(token);
        return (username != null && username.equals(administrateur.getUsername()) && !isTokenExpired(token));
    }

    // Vérifier si le token a expiré
    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration != null && expiration.before(new Date());
    }

    // Extraire les claims du token
    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            // Log l'exception et retourner null si le token est invalide
            return null;
        }
    }

}
