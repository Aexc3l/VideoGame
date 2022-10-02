package model;
import java.util.Random;

public class Level {

	private int number;
	private Complexity levelComplexity;
	private double requiredScore;
	private Enemy[] enemyList;
	private Treasure[] treasureList;
	private static Random random = new Random();

	public Level(int number, int levelComplexity, double requiredScore) {

		this.number = number;
		this.levelComplexity = Complexity.values()[levelComplexity-1];
		this.requiredScore = requiredScore;
		this.enemyList = new Enemy[25];
		this.treasureList = new Treasure[50];
	

	}

	public int getNumber(){

		return this.number;

	}

	public void setNumber(int number){
		this.number = number;

	}

	public double getRequiredScore(){

		return this.requiredScore;

	}

	public void setRequiredScore(double requiredScore){
		this.requiredScore = requiredScore;

	}

	public void setLevelComplexity(int levelComplexity){
		this.levelComplexity = Complexity.values()[levelComplexity-1];

	}

	public void addEnemy(Enemy addedEnemy, int mXPos, int mYPos) {
		boolean notAdded = true;
		int genX = 0;
		int genY = 0;

		for (int i = 0; i < enemyList.length && notAdded; i++) {
			if (enemyList[i] == null) {
				enemyList[i] = addedEnemy;
				while (notAdded) {
					genX = random.nextInt(mXPos);
					genY = random.nextInt(mYPos);
					boolean checkEnd = checkPosition( genX, genY);
					if (checkEnd) {
						addedEnemy.setPositionX(genX);
						addedEnemy.setPositionY(genY);
						notAdded = false;
					}
				}

			}
		}
	}

	public void addTreasure(Treasure addedTreasure, int mXPos, int mYPos) {
		boolean notAdded = true;
		int genX = 0;
		int genY = 0;

		for (int i = 0; i < treasureList.length && notAdded; i++) {
			if (treasureList[i] == null) {
				treasureList[i] = addedTreasure;
				while (notAdded) {
					genX = random.nextInt(mXPos);
					genY = random.nextInt(mYPos);
					boolean checkEnd = checkPosition( genX, genY);
					if (checkEnd) {
						addedTreasure.setPositionX(genX);
						addedTreasure.setPositionY(genY);
						notAdded = false;
					}
				}

			}
		}
	}

	public boolean  checkPosition(int xPos, int yPos) {

		for (int i = 0; i < enemyList.length; i++) {
			if (enemyList[i] == null ) {
			 return true;
			}else {
				Enemy eN = enemyList[i];			
				if (eN.getPositionY() == yPos) {
					return false;
				}else {
					for (int j = 0; j < treasureList.length; j++ ) {
							if (treasureList[j] == null ) {
								return true;
							}else {
								Treasure tR = treasureList[j];
								if (tR.getPositionY() == yPos) {
									return false;
								}
							}
						}
					}	
				}
			}

		for (int h = 0; h < enemyList.length; h++) {
			if (enemyList[h] == null ) {
			 return true;
			}else {
				Enemy eN = enemyList[h];			
				if (eN.getPositionX() == xPos) {
					return false;
				}else {
					for (int k = 0; k < treasureList.length; k++ ) {
							if (treasureList[k] == null ) {
								return true;
							}else {
								Treasure tR = treasureList[k];
								if (tR.getPositionX() == xPos) {
									return false;
								}
							}
						}
					}	
				}
			}

		return false;
	}

	public String toString(){
		int enemies = 0; 
		int treasures = 0;

		for (int i = 0;i < enemyList.length ; i++ ) {
			if (enemyList[i] != null) {
				enemies++;
			}
		}

		for (int i = 0;i < treasureList.length ; i++ ) {
			if (treasureList[i] != null) {
				treasures++;
			}
		}
		return 	 "\nLevel: " + number
				+"\nComplexity: " + levelComplexity
				+"\nRequired Score: " + requiredScore
				+"\n Treasures in Level: " + treasures
				+"\n Enemies in Level: " + enemies;
	}



}


