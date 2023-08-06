package com.zdoryk.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Size(min = 2, max = 40, message = "First name length should be between 2 and 40 characters")
    private String firstName;

    @Size(min = 2, max = 40, message = "Second name length should be between 2 and 40 characters")
    private String secondName;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Pattern(regexp = "^\\+?380\\d{9}$", message = "Invalid phone number")
    @Column(unique = true)
    private String phoneNumber;

    @NotBlank
    @Size(min = 1, message = "Password should not be empty")
    private String password;

    @Column(nullable = false)
    private Boolean enabled;
}
