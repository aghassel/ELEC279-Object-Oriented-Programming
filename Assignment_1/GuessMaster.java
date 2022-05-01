import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
	// instance variables definitions
	private int numberOfCandidateEntities;
	private Entity[] entities;

	// initialization of instance variables
	public GuessMaster() {
		this.numberOfCandidateEntities = 0;
		entities = new Entity[99];
	}

	// Adds entity information into array and updates count
	public void addEntity(Entity entity) {
		entities[this.numberOfCandidateEntities++] = new Entity(entity);
	}

	public void playGame() {
		Entity entity;
		entity = entities[RandomEntity()];
		Scanner scanner = new Scanner(System.in);
		boolean guess = false;
		//Asks User to play and gives game info
		System.out.println("Guess " + entity.getName() + "'s birthday!");
		System.out.println("Please enter in the following format (MM/DD/YYYY).");
		System.out.println("To quit the game, enter \"quit\"");
		
		//do-while loop until user gets correct birthdate
		do {
			String UserInput = scanner.nextLine();

			if (UserInput.equalsIgnoreCase("quit")) {
				System.out.println("Thanks for playing!");
				System.exit(0);
			}
			
			Date DateInput = new Date(UserInput);

			if (DateInput.equals(entity.getBorn())) {
				guess = true;
			}
			else if (DateInput.precedes(entity.getBorn())) {
				System.out.println("Incorrect. Try a later date");
			}
			else {
				System.out.println("Incorrect. Try an earlier date");	
				}
			
		} while(!guess);
		System.out.println("BINGO. You got it!!");
		}
	

	public int RandomEntity() {
		//generates "random" entity to choose
		Random rand = new Random();
		return rand.nextInt(numberOfCandidateEntities);
	}


	public static void main(String [ ] args){
		
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25,1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 4, 1776));
		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(usa);
		
		while(true) {
			gm.playGame();
		}
	}
}
