public class Entity {
	// define instance variables
	private String name;
	private Date born;

	public Entity(String name, Date born) {
		this.name = name;
		this.born = new Date(born); // creates copy of birth date
	}

	// clone constructor to avoid privacy leak
	public Entity(Entity clone) {
		name = clone.getName();
		born = clone.getBorn();
	}

	// Name accessor
	public String getName() {
		return name;
	}

	// Birth date accessor
	public Date getBorn() {
		return new Date(born);
	}

	// mutator method to return GuessMaster result
	public String toString() {
		return getName() + ", born on " + getBorn().toString();
	}

	// Compares both entities
	public boolean equals(Entity entity) {
		return (getName() == entity.getName() && getBorn() == entity.getBorn());
	}
}