package com.example.music.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "playback_history")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PlaybackHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id")
    private Track track;

    @Column(name = "played_at", nullable = false)
    private Instant playedAt = Instant.now();

    @Column(name = "position_ms")
    private Integer positionMs;

    @Column(length = 50)
    private String source; // "local" or "stream"
}