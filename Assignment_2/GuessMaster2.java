import java.util.Random;
import java.util.Scanner;

public class GuessMaster2 {
	private int numOfEntities;
	private Entity[] entities;
	private int tickets;

	public GuessMaster2() {
		numOfEntities = 0;
		entities = new Entity[100];
		tickets = 0; // initialize tickets to zero
	}

	// modified add entity
	public void addEntity(Entity entity) {
		entities[numOfEntities++] = entity.clone();
	}

	public void playGame(int entityId) {
		Entity entity = entities[entityId];
		playGame(entity);
	}

	public void playGame(Entity entity) {
		// welcome message
		System.out.println("***************************");
		System.out.println(entity.welcomeMessage());
		System.out.printf("\nGuess %s's birthday\n", entity.getName());
		System.out.println("(mm/dd/yyyy)");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String answer = scanner.nextLine();
			answer = answer.replace("\n", "").replace("\r", "");

			if (answer.equals("quit")) {
				System.exit(0);
			}

			Date date = new Date(answer);

			if (date.precedes(entity.getBorn())) {
				System.out.println("Incorrect. Try a later date.");
			} else if (entity.getBorn().precedes(date)) {
				System.out.println("Incorrect. Try an earlier date.");
			} else {
				tickets = tickets + entity.getAwardedTicketNumber();
				System.out.println("You won " + entity.getAwardedTicketNumber() + " tickets in this round");
				System.out.println("The total number of tickets you have now is " + tickets);
				break;
			}
		}
		System.out.println(entity.closingMessage());
	}

	public void playGame() {
		while (true) {
			int entityId = genRandomEntityId();
			playGame(entityId);
		}
	}

	public int genRandomEntityId() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(numOfEntities);
	}

	public static void main(String[] args) {
		System.out.println("=========================\n");
		System.out.println("     GuessMaster 2.0 \n");
		System.out.println("=========================");

		Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), 0.5, "Male", "Liberal");
		Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), 0.5, "Female", "La voix du bon Dieu",
				new Date("November", 6, 1981));
		Person myCreator = new Person("myCreator", new Date("September", 1, 2000), 0.1, "Female");
		Country usa = new Country("United States", new Date("July", 4, 1776), 0.1, "Washington D.C.");

		GuessMaster2 gm = new GuessMaster2();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(myCreator);
		gm.addEntity(usa);
		gm.playGame();
	}
}
