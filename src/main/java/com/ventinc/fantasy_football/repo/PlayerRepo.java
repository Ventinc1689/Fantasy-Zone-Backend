package com.ventinc.fantasy_football.repo;

import com.ventinc.fantasy_football.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

    List<Player> findByTeamContainingIgnoreCase(String team);
    List<Player> findByNameContainingIgnoreCase(String name);
    List<Player> findByPositionContainingIgnoreCase(String position);
    List<Player> findAllByOrderByPprDesc();
    List<Player> findByTeamContainingIgnoreCaseOrderByPprDesc(String team);
    List<Player> findByPositionContainingIgnoreCaseOrderByPprDesc(String position);
    List<Player> findAllByOrderByPprPerGameDesc();
    List<Player> findByTeamContainingIgnoreCaseOrderByPprPerGameDesc(String team);
    List<Player> findByPositionContainingIgnoreCaseOrderByPprPerGameDesc(String position);
}
