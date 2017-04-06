package net.worldrecordbaseball.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.worldrecordbaseball.model.Player;
import net.worldrecordbaseball.repository.PlayerRepository;

@RestController
@RequestMapping("api/v1")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@RequestMapping(value="players", method=RequestMethod.POST)
	public Player create(@RequestBody Player player) {
		return playerRepo.saveAndFlush(player);
	}
	
	@RequestMapping(value="players/{id}", method=RequestMethod.GET)
	public Player get(@PathVariable Long id) {
		return playerRepo.findOne(id);
	}
	
	@RequestMapping(value="players", method=RequestMethod.GET)
	public List<Player> list() {
		return playerRepo.findAll();
	}
	
	@RequestMapping(value="players/{id}", method=RequestMethod.PUT)
	public Player update(@PathVariable Long id, @RequestBody Player player) {
		Player existingPlayer = playerRepo.findOne(id);
		BeanUtils.copyProperties(player, existingPlayer);
		return playerRepo.saveAndFlush(existingPlayer);
	}
	
	@RequestMapping(value="players/{id}", method=RequestMethod.DELETE)
	public Player delete(@PathVariable Long id) {
		Player existingPlayer = playerRepo.findOne(id);
		playerRepo.delete(existingPlayer);
		return existingPlayer;
	}

}
