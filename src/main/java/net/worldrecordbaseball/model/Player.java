package net.worldrecordbaseball.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	
	@ManyToOne
	@JsonIgnore
	private GameSummary gameSummary;
	
	
	private String firstName;
	private String lastName;
	private String squadName;
	private String playerNumber;
	
	//metrics
	private Long numAtBats;
	private Long numSingles;
	private Long numDoubles;
	private Long numTriples;
	private Long numHomeRuns;
	private Long numBaseOnBalls;
	private Long numStrikeouts;
	private Long numStolenBases;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public GameSummary getGameSummary() {
		return gameSummary;
	}
	public void setGameSummary(GameSummary gameSummary) {
		this.gameSummary = gameSummary;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSquadName() {
		return squadName;
	}
	public void setSquadName(String squadName) {
		this.squadName = squadName;
	}
	public Long getNumAtBats() {
		return numAtBats;
	}
	public void setNumAtBats(Long numAtBats) {
		this.numAtBats = numAtBats;
	}
	public Long getNumSingles() {
		return numSingles;
	}
	public void setNumSingles(Long numSingles) {
		this.numSingles = numSingles;
	}
	public Long getNumDoubles() {
		return numDoubles;
	}
	public void setNumDoubles(Long numDoubles) {
		this.numDoubles = numDoubles;
	}
	public Long getNumTriples() {
		return numTriples;
	}
	public void setNumTriples(Long numTriples) {
		this.numTriples = numTriples;
	}
	public Long getNumHomeRuns() {
		return numHomeRuns;
	}
	public void setNumHomeRuns(Long numHomeRuns) {
		this.numHomeRuns = numHomeRuns;
	}
	public Long getNumBaseOnBalls() {
		return numBaseOnBalls;
	}
	public void setNumBaseOnBalls(Long numBaseOnBalls) {
		this.numBaseOnBalls = numBaseOnBalls;
	}
	public Long getNumStrikeouts() {
		return numStrikeouts;
	}
	public void setNumStrikeouts(Long numStrikeouts) {
		this.numStrikeouts = numStrikeouts;
	}
	public Long getNumStolenBases() {
		return numStolenBases;
	}
	public void setNumStolenBases(Long numStolenBases) {
		this.numStolenBases = numStolenBases;
	}
	public String getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}
	public Double getBattingAverage() {
		if(this.numAtBats == 0) {
			return 0.0;
		} 
		
		Long hits = this.numSingles + this.numDoubles + this.numTriples + this.numHomeRuns;
		
		return hits.doubleValue()/this.numAtBats;
	}
	
}
