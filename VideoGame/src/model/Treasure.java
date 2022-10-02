package model;

public class Treasure {

	private String trName;
	private String imageURL;
	private double awardScore;
	private int xPosition;
	private int yPosition;
	private Level locatedLevel;

	public Treasure(String trName,String imageURL, double awardScore) {

		this.trName = trName;
		this.imageURL = imageURL;
		this.awardScore = awardScore;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.locatedLevel = locatedLevel;

	}

	public String getTrName() {

		return trName;

	}

	public void setTrName(String trName) {
		this.trName = trName;

	}

	public String getImageURL() {

		return imageURL;

	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;

	}

	public double getAwardScore() {

		return awardScore;

	}

	public void setAwardScore(double awardScore) {
		this.awardScore = awardScore;

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

		return "\nTreasure Info"
				+ "\nName: " + trName
				+ "\nImage URL: " + imageURL
				+ "\nScore Given to The Player: " + awardScore
				+ "\nLocated Level: " + locatedLevel.getNumber()
				+ "\nPositions: " + xPosition + " x " + yPosition
				+ "\n";
	}

}
