package com.pfa.ecommerce.security.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;


}
