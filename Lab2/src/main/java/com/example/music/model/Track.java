package com.example.music.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tracks")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Track {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(name = "duration_ms")
    private Long durationMs;

    @Column(name = "path_or_url", nullable = false, columnDefinition = "TEXT")
    private String pathOrUrl;

    @Column(columnDefinition = "JSON")
    private String metadata; // json string with tags, genre etc.
}
