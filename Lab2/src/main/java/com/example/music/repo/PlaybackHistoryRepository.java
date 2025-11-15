package com.example.music.repo;

import com.example.music.model.PlaybackHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaybackHistoryRepository extends JpaRepository<PlaybackHistory, Long> {
    List<PlaybackHistory> findTop100ByUserIdOrderByPlayedAtDesc(Long userId);
}