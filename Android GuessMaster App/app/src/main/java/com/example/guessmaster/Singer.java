package com.example.guessmaster;

public class Singer extends Person{
	private String debutAlbum;
	private com.example.guessmaster.Date debugAlbumReleaseDate;

	public Singer(String name, 
			com.example.guessmaster.Date birthDate,
			String gender, 
			String debutAlbum, 
			com.example.guessmaster.Date debugAlbumReleaseDate,
			double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.debutAlbum = debutAlbum;
		this.debugAlbumReleaseDate = new com.example.guessmaster.Date(debugAlbumReleaseDate);
	}
	
	public Singer(Singer singer) {
		super(singer);
		this.debutAlbum = singer.debutAlbum;
		this.debugAlbumReleaseDate = new com.example.guessmaster.Date(singer.debugAlbumReleaseDate);
	}
	
	public String entityType() {
		return "This entity is a Singer!";
	}
	
	public String toString() {
		return super.toString() +"Debut Album: " + debutAlbum + "\n" 
	      + "Release Date: " + debugAlbumReleaseDate.toString() + "\n";
	}
	
	public Singer clone() {
		return new Singer(this);
	}
}

