package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.entities.RoleEntity;
import org.formation.proxiBanque.security.payload.response.JwtResponse;
import org.formation.proxiBanque.security.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    UserRepository userRepository;

    @Autowired
    RoleEntity Repository;

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

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> RoleEntity s = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), RoleEntity s));
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
        PersonneEntity PersonneEntity = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        String strRoleEntity = signUpRequest.getRoleEntity();
        RoleEntity RoleEntity;

        if (strRoleEntity == null) {
            com.pfa.ecommerce.entities.RoleEntity userRoleEntity = RoleEntity
            Repository.findByName(ERoleEntity.RoleEntity _USER)
                    .orElseThrow(() -> new RuntimeException("Error: RoleEntity  is not found."));
            RoleEntity = userRoleEntity;
        } else {
            switch (strRoleEntity) {
                case "admin":
                    RoleEntity adminRoleEntity = RoleEntity Repository.findByName(ERoleEntity.RoleEntity _ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: RoleEntity  is not found."));
                    RoleEntity = adminRoleEntity;

                    break;
                case "gerant":
                    RoleEntity gerantRoleEntity = RoleEntity Repository.findByName(ERoleEntity.RoleEntity _GERANT)
                        .orElseThrow(() -> new RuntimeException("Error: RoleEntity  is not found."));
                    RoleEntity = gerantRoleEntity;

                    break;
                default:
                    RoleEntity userRoleEntity = RoleEntity Repository.findByName(ERoleEntity.RoleEntity _USER)
                        .orElseThrow(() -> new RuntimeException("Error: RoleEntity  is not found."));
                    RoleEntity = userRoleEntity;
            }
        }

        user.setRoleEntity(RoleEntity);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("PersonneEntity registered successfully!"));
    }
}
