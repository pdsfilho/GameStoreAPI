package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		
		//TODO
		//Not null ID validation
		
		return new GameDTO(result);
	}
	
	@Transactional
	public List <GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List <GameMinDTO> gameDto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return gameDto;
	}

}
