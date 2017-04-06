package net.worldrecordbaseball.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class GameSummary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long inningNumber;
	private Long homeScore;
	private Long visitorScore;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="GAME_ID")
	private List<Player> players = new ArrayList<Player>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInningNumber() {
		return inningNumber;
	}

	public void setInningNumber(Long inningNumber) {
		this.inningNumber = inningNumber;
	}

	public Long getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Long homeScore) {
		this.homeScore = homeScore;
	}

	public Long getVisitorScore() {
		return visitorScore;
	}

	public void setVisitorScore(Long visitorScore) {
		this.visitorScore = visitorScore;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	

}
