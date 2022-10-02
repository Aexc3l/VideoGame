package model;

public class VideoGameController {
	private Quality quality;
	private Player[] players ;
	private Level[] levels;
	private Treasure[] treasures;
	private Enemy[] enemies;

	public static int maxPosX = 0;

	public static int maxPosY = 0;
//______________________________________________________________________________________________________________________________________________________________
	public VideoGameController(int resolution) {

		this.players = new Player[20];
		this.treasures = new Treasure[50];
		this.enemies = new Enemy[25];
		this.levels = new Level[10];
		this.quality = Quality.values()[resolution];

				switch (resolution) { 
    		case 0:
    			maxPosX = 640;
				maxPosY = 480;
     		break;
   			case 1:
   				maxPosX = 960;
				maxPosY = 540;
     		break; 
    		case 2:
    			maxPosX = 1280;
				maxPosY = 720;
     		break;
     	    case 3:
				maxPosX = 1920;
				maxPosY = 1080;
     		break;
    		case 4:
				maxPosX = 2560;
				maxPosY = 1440;
     		break;    		
     		case 5:
     			maxPosX = 3840;
				maxPosY = 2160;
     		break;  
     		case 6:
     			maxPosX = 7680;
				maxPosY = 4320;
     		break;
 		}

	}
//______________________________________________________________________________________________________________________________________________________________
	public void createLevels() {

		int number = 1;

		int levelComplexity = 1;

		double requiredScore = 10;

		for (int i = 0; i < levels.length; i++) {

			Level newLevel = new Level(number,levelComplexity,requiredScore);

			if (levels[i] == null) {

				levels[i] = newLevel;
				number++;
				requiredScore = requiredScore + 10;
			}
		}		
	}
//______________________________________________________________________________________________________________________________________________________________
	public String showAllLevels() {

		String allLevels = "";

		for (int i = 0; i < levels.length; i++) {

			if (levels[i] != null) {

				allLevels += levels[i].toString();
			}

		}
		return allLevels;
	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean registerPlayer(String playerNickName, String playerName, double playerScore, int availableLives, int initialLevel) {

		Player newPlayer = new Player(playerNickName, playerName, playerScore, availableLives, levels[initialLevel]);

		for (int i = 0; i < players.length; i++) {

			if (players[i] == null) {

				players[i] = newPlayer;
				return true;
			}
		}
		return false;
	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean registerTreasures(String trName,String imageURL, double awardScore, int locatedLevel, int treasInLevl) {
		
		for (int i = 0; i < treasures.length; i++ ) {
			if (treasures[i] == null) {
				Treasure newTreasure = new Treasure( trName, imageURL, awardScore);
				treasures[i] = newTreasure;
			}
			for (int j = 0; j < treasInLevl ; j++ ) {
				if (levels[locatedLevel] != null) {
						levels[locatedLevel-1].addTreasure(treasures[j], maxPosX, maxPosY);
						treasures[j].setLocatedLevel(levels[locatedLevel-1]);
						return true;
				}
			}
		}
		return false;
	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean registerEnemy(String enName, int enType, double loseScore, double winScore) {

		Enemy newEnemy = new Enemy( enName, enType, loseScore, winScore);

		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] == null) {

				enemies[i] = newEnemy;
				return true;
			}
		}
		return false;
	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean checkNickNameDisponibility(String playerNick) {

		for (int i = 0; i < players.length; i++) {
			if (players[i] == null) {
			 return true;	
			}else {
				Player pl = players[i];			
				if (pl.getNickName().equals(playerNick)) {
					return false;
				}
			}
		}
		return false;
	}
//______________________________________________________________________________________________________________________________________________________________
	public String showAllPlayers() {

		String allplayers = "";

		for (int i = 0; i < players.length; i++) {

			if (players[i] != null) {

				allplayers += players[i].toString();
			}

		}
		return allplayers;

	}
//______________________________________________________________________________________________________________________________________________________________
	public String showAllTreasures() {

		String alltreasures = "";

		for (int i = 0; i < treasures.length; i++) {

			if (treasures[i] != null) {

				alltreasures += treasures[i].toString();
			}

		}
		return alltreasures;
	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean checkNameExistence(String playerNick) {
		
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
			 		Player pl = players[i];			
				if (pl.getNickName().equals(playerNick)) {
					return true;
				}
			}
		}

		return false;

	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean checkEnemyNameExistence(String eNName) {
		
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
			 		Enemy eN = enemies[i];			
				if (eN.getEnName().equals(eNName)) {
					return true;
				}
			}
		}

		return false;

	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean checkEnemyNameDisponibility(String enemyName) {

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] == null) {
			 return true;	
			}else {
				Enemy eN = enemies[i];			
				if (eN.getEnName().equals(enemyName)) {
					return false;
				}
			}
		}
		return false;
	}
//______________________________________________________________________________________________________________________________________________________________
	public String showAllEnemies() {

		String allenemies = "";

		for (int i = 0; i < enemies.length; i++) {

			if (enemies[i] != null) {

				allenemies += enemies[i].toString();
			}

		}
		return allenemies;

	}
//______________________________________________________________________________________________________________________________________________________________
	public void modifyPlayerScore(String playerNick, double newScore) {

		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
			 		Player pl = players[i];			
				if (pl.getNickName().equals(playerNick)) {
					pl.setScore(newScore);
					for (int j = 0; j < levels.length; j++) {
						if (pl.getScore() >= levels[j].getRequiredScore()) {
							pl.setActuaLevel(levels[j]);
						}
					}
				}
			}			
		}
	}
//______________________________________________________________________________________________________________________________________________________________
	public double searchMissingScore(String playerNick) {
 	double msgsum =  0;
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
			 		Player pl = players[i];
			 	if (pl.getNickName().equals(playerNick)) {
			 		for (int j = 0; j < levels.length; j++ ) {
						if (pl.getScore() < levels[j].getRequiredScore()) {
							return msgsum = levels[j].getRequiredScore() - pl.getScore(); 
						}	
					}	
		 		}
			}
		}
		return msgsum; 	
	}
//______________________________________________________________________________________________________________________________________________________________
	public boolean addEnemyToLevel(String eNName, int eNLvl) {

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
			 		Enemy eN = enemies[i];			
				if (eN.getEnName().equals(eNName)) {		
					if (levels[eNLvl] != null) {
						levels[eNLvl].addEnemy(eN, maxPosX, maxPosY);
						enemies[i].setLocatedLevel(levels[eNLvl]);

							return true;
					}
				}
			}
		}
		return false;
	}
//_________________________________________________________________________________________________________________________________________________________________________________________	
}