package net.worldrecordbaseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.worldrecordbaseball.model.GameSummary;


public interface GameSummaryRepository extends JpaRepository<GameSummary, Long> {

}
