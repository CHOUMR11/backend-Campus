package tn.essat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.config.JwtRequest;
import tn.essat.config.JwtResponse;
import tn.essat.dao.IAdminRepository;  // Use IAdminRepository instead of IUserDao
import tn.essat.config.GestionToken;
import tn.essat.model.Administrateur;  // Updated to use Administrateur
import tn.essat.service.AdminService;  // Use AdminService instead of UserService

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private GestionToken token_gen;
    
    @Autowired
    private IAdminRepository dao_admin;  // Use IAdminRepository for Administrateur
    
    @Autowired
    private AdminService adminService;  // Use AdminService
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public JwtResponse signIn(@RequestBody JwtRequest request) {

        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Set the authentication in the context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Load the Administrateur by username
        Administrateur administrateur = adminService.findByUsername(request.getUsername());
        
        // Generate the token for the authenticated user
        String token = token_gen.generateToken(administrateur);
        
        // Create a JwtResponse with the generated token
        JwtResponse response = new JwtResponse(token);
        
        return response;
    }

    @PostMapping(value = "/inscription")
    public void signUp(@RequestBody Administrateur administrateur) {

        // Encrypt the password
        PasswordEncoder crypt = cryptage();
        String encryptedPassword = crypt.encode(administrateur.getPassword());
        
        // Set the encrypted password to the administrateur
        administrateur.setPassword(encryptedPassword);
        
        // Save the administrateur in the database
        dao_admin.save(administrateur);
    }

    // Bean to return the PasswordEncoder
    @Bean 
    private PasswordEncoder cryptage() {
        return new BCryptPasswordEncoder();
    }
}
