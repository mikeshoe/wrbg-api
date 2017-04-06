package net.worldrecordbaseball.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.worldrecordbaseball.model.GameSummary;
import net.worldrecordbaseball.repository.GameSummaryRepository;

@RestController
@RequestMapping("api/v1")
public class GameSummaryController {

	@Autowired
	private GameSummaryRepository gameSummaryRepo;
	
	
	@RequestMapping(value="gamesummarys", method=RequestMethod.POST)
	public GameSummary create(@RequestBody GameSummary gameSummary) {
		return gameSummaryRepo.saveAndFlush(gameSummary);
	}
	
	@RequestMapping(value="gamesummarys", method=RequestMethod.GET)
	public List<GameSummary> list() {
		return gameSummaryRepo.findAll();
	}
	
	@RequestMapping(value="gamesummarys/{id}", method=RequestMethod.GET)
	public GameSummary get(@PathVariable Long id) {
		return gameSummaryRepo.findOne(id);
	}
	
	@RequestMapping(value="gamesummarys/{id}", method=RequestMethod.PUT)
	public GameSummary update(@PathVariable Long id, @RequestBody GameSummary gameSummary) {
		GameSummary existingGameSummary = gameSummaryRepo.findOne(id);
		BeanUtils.copyProperties(gameSummary, existingGameSummary);
		return gameSummaryRepo.saveAndFlush(existingGameSummary);
	}
	
	@RequestMapping(value="gamesummarys/{id}", method=RequestMethod.DELETE)
	public GameSummary delete(@PathVariable Long id) {
		GameSummary existingGameSummary = gameSummaryRepo.findOne(id);
		gameSummaryRepo.delete(existingGameSummary);
		return existingGameSummary;
	}
	

}
