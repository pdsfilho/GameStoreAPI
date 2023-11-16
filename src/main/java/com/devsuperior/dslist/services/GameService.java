package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List <GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List <GameMinDTO> gameDto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return gameDto;
	}

}
