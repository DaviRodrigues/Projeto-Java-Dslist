package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.errors.InvalidMoveException;
import com.devsuperior.dslist.errors.ResourceNotFoundException;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		
		if (result.isEmpty()) {
			throw new ResourceNotFoundException("No games found");
		}
		
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		if (sourceIndex == destinationIndex) {
			throw new InvalidMoveException("Source and destination indexes must be different.");
		}
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		if (sourceIndex < 0 || sourceIndex > list.size() || destinationIndex < 0 || destinationIndex >= list.size()) {
			throw new InvalidMoveException("Invalid source or destination index.");
		}
		GameMinProjection sourceObj = list.get(sourceIndex);
		GameMinProjection destinationObj = list.get(destinationIndex);
		
		gameListRepository.updateBelongingPosition(listId, sourceObj.getId(), destinationObj.getId());
	}
}
