




package com.pfa.ecommerce.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
//import javafx.print.Collation;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.pfa.ecommerce.entities.ERole;
import com.pfa.ecommerce.entities.PersonneEntity;
import com.pfa.ecommerce.entities.RoleEntity;
import com.pfa.ecommerce.entities.dto.TokenDto;
import com.pfa.ecommerce.model.Personne;
import com.pfa.ecommerce.repository.PersonneRepository;
import com.pfa.ecommerce.repository.RoleRepository;
import com.pfa.ecommerce.security.jwt.AuthTokenFilter;
import com.pfa.ecommerce.security.jwt.JwtUtils;
import com.pfa.ecommerce.security.payload.request.LoginRequest;
import com.pfa.ecommerce.security.payload.response.JwtResponse;
import com.pfa.ecommerce.security.payload.response.MessageResponse;
import com.pfa.ecommerce.security.services.UserDetailsImpl;
import com.pfa.ecommerce.security.services.UserDetailsServiceImpl;
import com.pfa.ecommerce.services.intf.IPersonneService;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// http://localhost:8080
@RestController
@RequestMapping("/social")
@CrossOrigin(origins = "*")
//http://localhost:8080/social
class SocialController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    IPersonneService personneService;
    private PasswordEncoder passwordEncoder;

@Autowired
    AuthController authController;
    private String email;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Value("${google.id}")
    private String idClient;

    @Value("${mySecret.password}")
    private String password;
   @Autowired
     RoleRepository RoleRepository;
    @Autowired
    public SocialController(
           // UserService userService,RoleService roleService,TokenService tokenService,
            PasswordEncoder passwordEncoder) {
       /* this.userService = userService;
        this.roleService = roleService;
        this.tokenService = tokenService;*/
        this.passwordEncoder = passwordEncoder;
    }
    String name;
    String username;
    String prenom;
    //http://localhost:8080/social/google
    @PostMapping("/google")
    public ResponseEntity<?> loginWithGoogle(@RequestBody String  token, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("token"+ token);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(token);
        // Get the value associated with the key "token"
        String tokenValue = (String) jsonObject.get("token");
        System.out.println("tokenValue"+ tokenValue);
        NetHttpTransport transport = new NetHttpTransport();
        JacksonFactory factory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder ver =
                new GoogleIdTokenVerifier.Builder(transport,factory)
                        .setAudience(Collections.singleton(idClient));
        System.out.println("ver.getJsonFactory()"+ ver.getJsonFactory());
       GoogleIdToken googleIdToken = GoogleIdToken.parse(ver.getJsonFactory(), tokenValue);
        System.out.println("googleIdToken"+ googleIdToken);
        GoogleIdToken.Payload payload = googleIdToken.getPayload();
        System.out.println("payload"+ payload);
        email = payload.getEmail();
        name =  payload.get("name").toString();
        username =  payload.get("given_name").toString();
        Object familyNameObj = payload.get("family_name");
        if (familyNameObj != null) {
            prenom = familyNameObj.toString();
        } else {
            prenom = "";
        }
        System.out.println("name"+ name);
        System.out.println("email"+ email);
        Personne personne = new Personne();
        PersonneEntity personneEntity = new PersonneEntity();
        String user;
        if(personneService.ifEmailExist(email)){
            System.out.println("email  existe.");
            personneEntity = personneService.getUserByMail(email);
            response.setStatus(HttpServletResponse.SC_OK); // 200 OK
        } else {
            System.out.println("email not existe.");
             personne = createUser(email);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found
        }
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(personneEntity.getUsername());
        loginRequest.setPassword(password);
        System.out.println("loginRequest"+loginRequest);


      ResponseEntity<?> responses = authController.authenticateUser(loginRequest);
                return ResponseEntity.ok(responses);
    }

    private Personne createUser(String email) {
        if (personneRepository.existsByUsername(username)) {
           System.out.println("username already Existe.");
           return null;
        }else{
            Personne user = new Personne();
            user.setUsername(username);
            user.setNom(name);
            user.setPrenom(prenom);
            user.setEmail(email);
            RoleEntity role = new RoleEntity();
            role.setName(ERole.ROLE_USER);
            System.out.println("ROLE_USER "+  RoleRepository.findByName(ERole.ROLE_USER));
            RoleEntity roleUser = RoleRepository.findByName(ERole.ROLE_USER).get();
            user.setRole(roleUser);
            user.setPassword(passwordEncoder.encode(password));
            return personneService.save(user);
        }
    }

    //http://localhost:8080/social/facebook
    @PostMapping("/facebook")
    public void loginWithFacebook(@RequestBody TokenDto tokenDto) throws Exception {
        Facebook facebook = new FacebookTemplate(tokenDto.getToken());
        String [] data = {"email"};
        org.springframework.social.facebook.api.User user = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class,data);

        email = user.getEmail();
      /*  User userFace = new User();
        if(userService.ifEmailExist(email)){
            userFace = userService.getUserByMail(email);
        } else {
            userFace = createUser(email);
        }
        ///////////////////////////
        JwtLogin jwtLogin = new JwtLogin();
        jwtLogin.setEmail(user.getEmail());
        jwtLogin.setPassword(password);*/
        ///////////////////////////

      //  return new ResponseEntity<LoginResponse>(tokenService.login(jwtLogin), HttpStatus.OK);
    }
}



