package model;

public class Enemy {

	private String enName;
	private Types enType;
	private double loseScore;
	private double winScore;
	private int xPosition;
	private int yPosition;
	private Level locatedLevel;

	public Enemy(String enName, int enType, double loseScore, double winScore) {

		this.enName = enName;
		this.enType = Types.values()[enType-1];
		this.loseScore = loseScore;
		this.winScore = winScore;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.locatedLevel = locatedLevel;

	}

	public String getEnName() {

		return enName;

	}

	public void setEnName(String enName) {
		this.enName = enName;

	}

	public double getLoseScore() {

		return loseScore;

	}

	public void setLoseScore(double loseScore) {
		this.loseScore = loseScore;

	}

	public double getWinScore() {

		return winScore;

	}

	public void setWinScore(double winScore) {
		this.winScore = winScore;

	}

	public Level getLocatedLevel() {

		return locatedLevel;

	}

	public void setLocatedLevel(Level locatedLevel) {
		this.locatedLevel = locatedLevel;

	}

	public int getPositionX() {

		return xPosition;

	}

	public void setPositionX(int xPosition) {
		this.xPosition = xPosition;

	}

	public int getPositionY() {

		return yPosition;

	}

	public void setPositionY(int yPosition) {
		this.yPosition = yPosition;

	}

	public String toString() {

	String positions = xPosition + " x " + yPosition;
	String locLvl = "None";

		if (locatedLevel != null) {
			locLvl = locatedLevel.getNumber() + "";
		}
		
		return "\nEnemy: " + enName
				+ "\nType: " + enType
				+ "\nIn case "+ enName + " gets kill by player: " + loseScore + " points"
				+ "\nIn case " + enName + " win the player: " + winScore + " points"
				+ "\nPositions: " + positions
				+"\nLocated Level: " + locLvl
				+ "\n ";
	}

}
