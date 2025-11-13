package com.example.music.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=100)
    private String username;

    @Column(unique=true)
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(nullable=false)
    private String role; // "ROLE_USER", "ROLE_ADMIN" або "GUEST"

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlists;
}