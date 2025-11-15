package com.example.music.repo;

import com.example.music.model.PlaylistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaylistItemRepository extends JpaRepository<PlaylistItem, Long> {
    List<PlaylistItem> findByPlaylistIdOrderByPosition(Long playlistId);
}