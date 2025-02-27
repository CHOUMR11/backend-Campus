package tn.essat.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import tn.essat.model.Administrateur;
import tn.essat.service.AdminService;  // Corrected to use AdminService

public class Filter extends OncePerRequestFilter {

    @Value("${auth.header}")
    private String TOKEN_HEADER;

    @Autowired
    private AdminService adminService;  // Autowire AdminService

    @Autowired
    private GestionToken tokenGen;  // Autowire the token generation service

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String token = request.getHeader(TOKEN_HEADER);
        final SecurityContext securityContext = SecurityContextHolder.getContext();

        if (token != null && securityContext.getAuthentication() == null) {
            String username = tokenGen.getUserNameFromToken(token);
            if (username != null) {
                Administrateur administrateur = adminService.findByUsername(username);  // Use AdminService to load the user
                if (administrateur != null && tokenGen.isTokenValid(token, administrateur)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            administrateur,
                            null,
                            administrateur.getAuthorities());  // Ensure that getAuthorities is defined for Administrateur
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);  // Continue the filter chain
    }
}
