public abstract class Entity {
	private String name;
	private Date born;
	private double difficulty; // either 0 or 1

	// empty parameters
	public Entity() {
		name = "N/A";
		born = new Date();
		difficulty = 1;
	}
		
	public Entity(String name, Date birthDate, double difficulty) {
		this.name = name;
		this.born = new Date(birthDate); // no privacy leak
		this.difficulty = difficulty;
	}

	// clone
	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born); // no privacy leak
		this.difficulty = entity.difficulty;
	}

	

	public String getName() {
		return name;
	}

	public Date getBorn() {
		return new Date(born);
	}

	// difficulty accessor
	public double getDifficulty() {
		return difficulty;
	}

	public String toString() {
		return "Name: " + name + "\n" + "Born at: " + born.toString() + "\n" + difficulty + "\n";
	}

	// determines # tickets
	public Integer getAwardedTicketNumber() {
		return (int) difficulty * 100;
	}

	// abstract that returns entity type
	public abstract String entityType();

	// abstract that clones entities
	public abstract Entity clone();

	// introduction message
	public String welcomeMessage() {
		return ("Welcome! Let's start the game! This entity is a " + entityType());
	}

	// closing message
	public String closingMessage() {
		return ("Congratulations! The detailed information of the entity you guess is: \n" + toString());
	}
}
