package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging "
	        + "SET game_id = CASE "
	        + "WHEN game_id = :sourceGameId THEN :destinationGameId "
	        + "WHEN game_id = :destinationGameId THEN :sourceGameId "
	        + "END "
	        + "WHERE game_id IN (:sourceGameId, :destinationGameId) "
	        + "AND list_id = :listId")
	void updateBelongingPosition(Long listId, Long sourceGameId, Long destinationGameId);
}
