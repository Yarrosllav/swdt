package com.example.music.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "playlist_items",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"playlist_id", "position"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PlaylistItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

    @Column(nullable = false)
    private Integer position;

    @Column(name = "added_at", nullable = false)
    private Instant addedAt = Instant.now();
}
