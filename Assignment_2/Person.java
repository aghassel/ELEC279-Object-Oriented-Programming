public class Person extends Entity {
	private String gender;

	// initializing constructors
	public Person() {
		super();
		gender = "N/A";
	}

	public Person(Person person) {
		super(person);
		this.gender = person.getGender();
	}

	public Person(Entity entity, String gender) {
		super(entity);
		this.gender = gender;
	}

	public Person(String name, Date birthDate, double difficulty, String gender) {
		super(name, birthDate, difficulty);
		this.gender = gender;
	}

	// modified toString
	public String toString() {
		return (super.toString() + "Gender: " + gender + "\n");
	}

	// gender accessor
	public String getGender() {
		return gender;
	}

	// clone method
	public Person clone() {
		return new Person(this);
	}

	// Country entity type
	public String entityType() {
		return "person!";
	}
}