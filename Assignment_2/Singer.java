public class Singer extends Person {
	private String debutAlbum;
	private Date debutAlbumReleaseDate;

	// initializing constructors
	public Singer() {
		super();
		debutAlbum = "N/A";
		debutAlbumReleaseDate = new Date();
	}

	public Singer(Singer singer) {
		super(singer);
		this.debutAlbum = singer.getDebutAlbum();
		this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
	}

	public Singer(Person person, String debutAlbum, Date debutAlbumReleaseDate) {
		super(person);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
	}

	public Singer(String name, Date birthDate, double difficulty, String gender, String debutAlbum,
			Date debutAlbumReleaseDate) {
		super(name, birthDate, difficulty, gender);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
	}

	// modified toString
	public String toString() {
		return (super.toString() + "Debut Album: " + debutAlbum + "\n" + "Debut Album Release Date: "
				+ debutAlbumReleaseDate.toString() + "\n");
	}

	// DebutAlbum accessor
	public String getDebutAlbum() {
		return debutAlbum;
	}

	// clone method
	public Singer clone() {
		return new Singer(this);
	}

	// Country entity type
	public String entityType() {
		return "singer!";
	}
}