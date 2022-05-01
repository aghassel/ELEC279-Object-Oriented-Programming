public class Country extends Entity {
	private String capital;

	//initializing constructors
	public Country() {
		super();
		capital = "N/A";
	}

	public Country(Country country) {
		super(country);
		capital = country.getCapital();
	}
	
	public Country(Entity entity, String capital) {
		super(entity);
		this.capital = capital;
	}
	
	public Country(String name, Date birthDate, double difficulty, String capital) {
		super(name, birthDate, difficulty);
		this.capital = capital;
	}
	
	//modified toString
	public String toString() {
		return (super.toString() + "Capital: " + capital + "\n");
	}
	
	// capital accessor
	public String getCapital( ) {
		return capital;
	}
	
	//clone method
	public Country clone() {
		return new Country(this);
	}
	
	//Country entity type
	public String entityType() {
		return "country!";
	}
}