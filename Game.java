import java.util.Scanner;

class Game extends Field implements IDifficulty{
	
	private int score;
	private int lives = 3;
	
	private int goldCount;
	private int rubyCount;
	private boolean isGameOver;
	
	private int difficultyLevel;
	
	private int easyHighScore;
	private int mediumHighScore;
	private int hardHighScore;
	
	private Scanner scanner = new Scanner(System.in);
	
	private void initialization() {
		score = 0;
		goldCount = 0;
		rubyCount = 0;
		lives = 3;
		totalToolKit = 7;
		isGameOver = false;
		initializeField();
	}
		
	public void play() {
	
		chooseDifficulty(scanner);
		initialization();
		printField();
		
		while (!isGameOver) {
			
			displayScore();
			validate();
        	}
        	
        	displayScore();
		
	}
	
	private void validate() {
		int digArea;
		int row;
		int coln;
		char item;
		
		if(lives > 0) {
			if (totalToolKit > 0) {
            			System.out.println("\nEnter the number to dig: ");
            			digArea = scanner.nextInt();
            				
            			if (isValidArea(digArea)) {
            				
                			row = (digArea-1) / field[0].length;
                			coln = (digArea-1) % field[0].length;
                			
                			item = field[row][coln].charAt(0);
                			if ( item != GOLD && item != RUBY && item != MINE && item != ROCK && item != DUG && item != TOOLKIT) {
 
                        			dig(row, coln);
                        					
                    			} else {
                    				System.out.println("\nThis Area is already dug!");
                			}
                		} else {
                        		System.out.println("\nEnter valid dig area");
                    		}
                			
            		} else {
                		System.out.println("\nNot enough toolkit to dig");
                		
                		isGameOver = true;
                		
                		setHighScore();
            		}
            		
            			
        	} else {
        			
        		System.out.println("\nYou are dead. Game Over!");
        		isGameOver = true;
        		setHighScore();
        	}
        	printField();
        }
	
	private void chooseDifficulty(Scanner scanner) {
	
		
			System.out.println("\n\t\t DIFFICULTY");
			System.out.println("\n\t1. EASY");
			System.out.println("\n\t2. MEDIUM");
			System.out.println("\n\t3. HARD");
			System.out.println("\n\t4. BACK");
			
			System.out.println("\nEnter Option: ");
			
			int option = scanner.nextInt();
			switch(option){
				case EASY_LEVEL:
					difficultyLevel = EASY_LEVEL;
					setDifficulty(option);
					break;
				case MEDIUM_LEVEL:
					difficultyLevel = MEDIUM_LEVEL;
					setDifficulty(option);
					break;
				case HARD_LEVEL:
					difficultyLevel = HARD_LEVEL;
					setDifficulty(option);
					break;
				case 4:
					mainMenu();
					break;
				default:
					System.out.println("\nInvalid option!");
			}
		
				
	}
	
	private void setDifficulty(int difficulty){
		switch(difficulty){
			case EASY_LEVEL:
				rockArea = new int[15];
				mineArea = new int[10];
				goldArea = new int[15];
				rubyArea = new int[15];
				toolKitArea = new int[15];
				break;
			case MEDIUM_LEVEL:
				rockArea = new int[20];
				mineArea = new int[20];
				goldArea = new int[10];
				rubyArea = new int[10];
				toolKitArea = new int[10];
				break;
			case HARD_LEVEL:
				rockArea = new int[25];
				mineArea = new int[30];
				goldArea = new int[5];
				rubyArea = new int[5];
				toolKitArea = new int[5];
				break;
			
		}
	}
	
	private void displayScore() {
		
		System.out.print("\nTotal ToolKit : " + totalToolKit);
		System.out.print("\t\tLives : " + lives);
		System.out.print("\nGold : " + goldCount);
		System.out.print("\t\t\tTotalScore : " + score);
		System.out.println("\nRuby : " + rubyCount);
	}
	

	private void setHighScore() {
    		if (isHighScore()) {
       		switch (difficultyLevel) {
            			case EASY_LEVEL:
                			easyHighScore = score;
                			System.out.println("Congratulations! You've set a new high score!");
                			break;
            			case MEDIUM_LEVEL:
                			mediumHighScore = score;
                			System.out.println("Congratulations! You've set a new high score!");
                			break;
            			case HARD_LEVEL:
                			hardHighScore = score;
                			System.out.println("Congratulations! You've set a new high score!");
               			break;
        		}
    		} 
    	}

			
	
	private void displayHighScores() {
		
		System.out.println("\nEasy : " +  easyHighScore);
		System.out.println("Medium : " +  mediumHighScore);
		System.out.println("Hard : " +  hardHighScore);

	}
	
	private boolean isHighScore() {
    		switch (difficultyLevel) {
       		case EASY_LEVEL:
            			if (score > easyHighScore) {
                			return true;
            			}
            			break;
        		case MEDIUM_LEVEL:
            			if (score > mediumHighScore) {
                			return true;
            			}
            			break;
        		case HARD_LEVEL:
            			if (score > hardHighScore) {
                			return true;
            			}
            			break;
    			}
    		return false;
	}

		
		
	
	private void dig(int row, int coln) {
    		
   		char item = digArea(Integer.parseInt(field[row][coln]));
   		
   		if(item == ROCK) {
   			System.out.println("You cannot dig in a rock area.");
   			field[row][coln] = Character.toString(ROCK);
   			
   			totalToolKit--;
   		} else if (item == MINE) {
   			
        		System.out.println("You stepped on a mine!");
        		field[row][coln] = Character.toString(MINE);
        		
        		lives--;
        		totalToolKit--;
    		} else if (item == GOLD) {
        		System.out.println("You found gold worth " + GOLD_VALUE + " gold.");
        		
        		score += GOLD_VALUE;
        		isHighScore();
        		
       	 	goldCount++;
       	 	field[row][coln] = Character.toString(GOLD);
       	 	
       	 	totalToolKit--;
    		} else if (item == RUBY) {
        		System.out.println("You found ruby worth " + RUBY_VALUE + " ruby.");
        		score += RUBY_VALUE;
        		isHighScore();
        		
        		rubyCount++;
        		field[row][coln] = Character.toString(RUBY);
        		
        		totalToolKit--;
    		}else if (item == TOOLKIT) {
        		System.out.println("You found toolkit worth " + TOOLKIT_VALUE + " toolkits.");
        		totalToolKit += TOOLKIT_VALUE;
        		field[row][coln] = Character.toString(TOOLKIT);
        		
        		totalToolKit--;
    		} else if(item == DUG){
        		System.out.println("You found nothing in this area.");
        		field[row][coln] = Character.toString(DUG);
        		
        		totalToolKit--;
    		} else {
    			System.out.println("Only you can dig adjuscent site");
    		}
    		
	}
		
		
	
	private boolean isValidArea(int digArea) {
    		if (digArea < 1 || digArea > field.length * field[0].length) {
        		return false; // Invalid area number
    		}
    
    		return true; // Valid area
	}
	
	private void exitGame(){
		System.exit(0);
	}

	private void mainMenu() {
		
		
		while(true) {
			System.out.println("\n\t\t MAIN MENU");
			System.out.println("\n\t1. Play");
			System.out.println("\n\t2. HighScores");
			System.out.println("\n\t3. Exit");
			
			System.out.println("\nEnter Option: ");
			int option = scanner.nextInt();
			
			switch(option) {
				case 1: 
					play();
					break;
				case 2:
					displayHighScores();
					break;
				case 3:
					exitGame();
				default:
					System.out.println("Invalid Option!");
			}
		}
	}
		
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.mainMenu();
	}
	
}
