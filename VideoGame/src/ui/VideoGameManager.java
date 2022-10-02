package ui;

import model.VideoGameController;
import java.util.Scanner;

public class VideoGameManager {

	public static Scanner scan = new Scanner(System.in);

	public static VideoGameController gameControler;

	private static boolean exit = false;

	private static int decision = 0;

	private static double initialScore = 10;

	private static int initialLives = 5;

	private static int initialLevel = 0;

	private static int registerpl = 0;

	private static int registerEn = 0;

	private static int registerTr = 0;

//_______________________________________________________________________________________________________________
	public static void mainMenu() {

		while (!exit) {
			System.out.println("\nHERE COMES A NEW CHALLENGER!"
					+ "\nSelect an option"
					+ "\n[1] Manage Players"
					+ "\n[2] Manage Enemies"
					+ "\n[3] Manage Treasures"
					+ "\n[4] See all Levels"
					+ "\n[5] Exit");

			int choice = scan.nextInt();

			switch (choice) {

				case 1:
					playerConfig();
					break;
				case 2:
					enemyConfig();
					break;
				case 3:
					treasureConfig();
					break;
				case 4:
					System.out.println(gameControler.showAllLevels());
					break;
				default:
					exit = true;
					break;
			}
		}
	}

//_________________________________________________________________________________________________________________________________________________________________________________________
	public static void vdConfig() {

		System.out.println("\nChoose a Display Resolution"
				+ "\n[1] SD (640 x 480)"
				+ "\n[2] QHD (960 x 540)"
				+ "\n[3] HD (1280 x 720)"
				+ "\n[4] FHD (1920 x 1080)"
				+ "\n[5] UHD (2560 x 1440)"
				+ "\n[6] UHD (3840 x 2160)"
				+ "\n[7] UHD 8K (7680 x 4320)");

			int resolution = scan.nextInt()-1;

			gameControler = new VideoGameController(resolution);
			gameControler.createLevels();
			mainMenu();
	}
//_________________________________________________________________________________________________________________________________________________________________________________________	
	private static void playerConfig() {
		while (!exit) {
		System.out.println("\nChoose an Option"
			+ "\n[1] Create a Player"
			+ "\n[2] See all Player"
			+ "\n[3] Modify a Player's Score"
			+ "\n[4] Go Back");
				
				decision = scan.nextInt();

			switch (decision) {
				case 1:
					registerPlayer();
					break;
				case 2:
					if (registerpl > 0) {
						System.out.println(gameControler.showAllPlayers());
					} else {
						System.out.println("You haven't registered any players yet");
					}
					break;
				case 3:
					if (registerpl > 0) {
						modifyPlayerScore();
					} else {
						System.out.println("You haven't registered any players yet");
					}
					break;
					default:
						mainMenu();
						break;}
		}
	}
//_________________________________________________________________________________________________________________________________________________________________________________________	
	private static void enemyConfig() {
		while (!exit) {
			System.out.println("\nChoose an Option"
				+ "\n[1] Create an Enemy"
				+ "\n[2] See all Enemies"
				+ "\n[3] Add a Enemy to a Level"
				+ "\n[4] Go Back");
				
				decision = scan.nextInt();

			switch (decision) {
				case 1:
					registerEnemy();
					break;
				case 2:
					if (registerEn > 0) {
						System.out.println(gameControler.showAllEnemies());
					} else {
						System.out.println("You haven't registered any enimies yet");
					}
					break;
				case 3:
					if (registerEn > 0) {
						addEnemyToLevel();
					} else {
						System.out.println("You haven't registered any enemies yet");
					}
					break;
				default:
						mainMenu();
						break;}
					}
	}
//_________________________________________________________________________________________________________________________________________________________________________________________		
	private static void treasureConfig() {
		while (!exit) {
			System.out.println("\nChoose an Option"
				+ "\n[1] Create a Treasure"
				+ "\n[2] See all Treasures"
				+ "\n[3] Go Back");
				
				decision = scan.nextInt();

			switch (decision) {
				case 1:
					registerTreasure();
					break;
				case 2:
					if (registerTr > 0) {
						System.out.println(gameControler.showAllTreasures());
					} else {
						System.out.println("You haven't registered any enemies yet");
					}
					break;
				default:
						mainMenu();
						break;}
					}
	}
//_________________________________________________________________________________________________________________________________________________________________________________________		
	private static void registerPlayer() {
	
	boolean checkDisp = false;
	String playerNickName = "";
	scan.nextLine();

		while (!checkDisp) {

		System.out.println("\nType the Player NickName");
		playerNickName = scan.nextLine();

		boolean disponibility = gameControler.checkNickNameDisponibility(playerNickName);

		if (disponibility) {
			checkDisp = true;
		}else {
			System.out.print("\nThis NickName is already taken, Please type another");
			}
		}

		System.out.println("Type Player's Name");
		String playerName = scan.nextLine();

		if (gameControler.registerPlayer(playerNickName, playerName, initialScore, initialLives, initialLevel)) {
			System.out.println("Player successfully registered");
		} else {
			System.out.println("Failed to register Player");
		}
		registerpl = registerpl + 1;
	}
//_________________________________________________________________________________________________________________________________________________________________________________________	
	private static void registerEnemy() {
	
	boolean checkEnNameDisp = false;
	String enemyName = "";
	scan.nextLine();

		while (!checkEnNameDisp) {

		System.out.println("\nType the Enemy Name");
		enemyName = scan.nextLine();

		boolean disponibility = gameControler.checkEnemyNameDisponibility(enemyName);

		if (disponibility) {
			checkEnNameDisp = true;
		}else {
			System.out.print("\nThis Enemy Name is already taken, Please type another");
			}
		}
		
		System.out.println("\nChoose the Enemy Type"
			+ "\n[1] OGRE"
			+ "\n[2] ABSTRACT"
			+ "\n[3] BOSS"
			+ "\n[4] MAGICAL");
			int enType = scan.nextInt();

		System.out.println("Type the score in case the player gets killed by the enemy");
		double loseScore = scan.nextDouble();

		System.out.println("Type the score in case the player kills the enemy");
		double winScore = scan.nextDouble();
		
		if (gameControler.registerEnemy(enemyName, enType, loseScore, winScore)) {
			System.out.println("Enemy successfully registered");
		} else {
			System.out.println("Failed to register Enemy");
		}
		registerEn = registerEn + 1;

	}
//_________________________________________________________________________________________________________________________________________________________________________________________
	private static void registerTreasure() {
	
	scan.nextLine();

		System.out.println("\nType the Treasure Name");
		String trName = scan.nextLine();

		System.out.println("\nType the Image URL");
		String imageURL = scan.nextLine();
				
		System.out.println("\nType the score in case the player founds the Treasure");
		double awardScore = scan.nextDouble();

		System.out.println("\nType the level where the treasure is located");
		int locatedLevel = scan.nextInt();

		System.out.println("\nHow many treasures will be found in level " + locatedLevel);
		int trInLvl = scan.nextInt();
		
		if (gameControler.registerTreasures(trName, imageURL, awardScore, locatedLevel, trInLvl)) {
			System.out.println("Treasure successfully registered");
		} else {
			System.out.println("Failed to register Treasure");
		}
		registerTr = registerTr + 1;
	}
//_________________________________________________________________________________________________________________________________________________________________________________________
	private static void modifyPlayerScore() {
		scan.nextLine();
		boolean modPl = false;
		String modPlayer = "";
		
			while (!modPl) {

				System.out.println("\nPlease Type the NickName of the Player");
					modPlayer = scan.nextLine();

				boolean existence = gameControler.checkNameExistence(modPlayer);
						
				if (existence) {
					modPl = true;
					}else {
						System.out.print("\nThis NickName does not exist, Please type another");
					}
				}

		System.out.println("\nPlease Type the New Score of the Player");
			double playerNewScore = scan.nextDouble();
			
			gameControler.modifyPlayerScore(modPlayer,playerNewScore);
		
		System.out.println("Score Successfully Changed");
		System.out.println("For Next Level, You Will Need: " + gameControler.searchMissingScore(modPlayer) + " points");
	}
//_________________________________________________________________________________________________________________________________________________________________________________________	
	private static void addEnemyToLevel(){
		scan.nextLine();

		boolean modEn = false;
		String eNName = "";

			while (!modEn) {

				System.out.println("Type Enemy's Name");
					eNName = scan.nextLine();

				boolean existence = gameControler.checkEnemyNameExistence(eNName);
						
				if (existence) {
					modEn = true;
					}else {
						System.out.print("\nThis Enemy does not exist, Please type another");
					}
				}		


		System.out.println("Type the Level in which you want to locate the enemy");
			int eNLvl = scan.nextInt();

		if (gameControler.addEnemyToLevel(eNName,eNLvl-1)) {
				System.out.println("Enemy successfully added");
		} else {
			System.out.println("Failed to add Enemy");
		}
	}
//_________________________________________________________________________________________________________________________________________________________________________________________	
	public static void main(String[] args) {
		vdConfig();
	}
}