public class Politician extends Person {
	private String party;

	// initializing constructors
	public Politician() {
		super();
		party = "N/A";
	}

	public Politician(Politician politician) {
		super(politician);
		this.party = politician.getParty();
	}

	public Politician(Person person, String party) {
		super(person);
		this.party = party;
	}

	public Politician(String name, Date birthDate, double difficulty, String gender, String party) {
		super(name, birthDate, difficulty, gender);
		this.party = party;
	}

	// modified toString
	public String toString() {
		return super.toString() + "Party: " + party + "\n";
	}

	// Party accessor
	public String getParty() {
		return party;
	}

	// clone method
	public Politician clone() {
		return new Politician(this);
	}

	// Country entity type
	public String entityType() {
		return "politician!";
	}
}