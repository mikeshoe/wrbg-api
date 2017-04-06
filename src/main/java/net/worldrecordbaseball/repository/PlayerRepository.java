package net.worldrecordbaseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.worldrecordbaseball.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
