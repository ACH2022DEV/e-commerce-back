package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.entities.ERole;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.entities.RoleEntity;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.repository.RoleRepository;
import com.pfa.ecommerce.security.jwt.JwtUtils;
import com.pfa.ecommerce.security.payload.request.LoginRequest;
import com.pfa.ecommerce.security.payload.request.SignupRequest;
import com.pfa.ecommerce.security.payload.response.JwtResponse;
import com.pfa.ecommerce.security.payload.response.MessageResponse;
import com.pfa.ecommerce.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonneRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
// La méthode generateJwtCookie permet d'encapsuler le jwt dans un cookie HTTP only :
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        PersonneEntity user = PersonneEntity.builder()
                .nom(signUpRequest.getNom())
                .prenom(signUpRequest.getPrenom())
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .password(encoder.encode(signUpRequest.getPassword()))
                .build();

        String strRole = signUpRequest.getRole();
        RoleEntity role;

        if (strRole == null) {
            RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role = userRole;
        } else {
            switch (strRole) {
                case "admin":
                    RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    role = adminRole;

                    break;
                case "gerant":
                    RoleEntity gerantRole = roleRepository.findByName(ERole.ROLE_GERANT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    role = gerantRole;

                    break;
                default:
                    RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    role = userRole;
            }
        }

        user.setRole(role);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
