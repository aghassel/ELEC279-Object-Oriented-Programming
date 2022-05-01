package com.example.guessmaster;

public abstract class Entity {
	private String name;
	private com.example.guessmaster.Date born;
	private double difficulty;////

	public Entity(String name, com.example.guessmaster.Date birthDate) {
		this.name = name;
		this.born = new com.example.guessmaster.Date(birthDate); // no privacy leak
	}
	
	public Entity(String name, 
			com.example.guessmaster.Date birthDate,
			double difficulty) {
		this(name, birthDate);
		this.difficulty = difficulty;
	}

	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new com.example.guessmaster.Date(entity.born); //no privacy leak
		this.difficulty = entity.difficulty;
	}

	public String getName() {
		return name;
	}

	public com.example.guessmaster.Date getBorn() {
		return new com.example.guessmaster.Date(born);
	}
	
	public com.example.guessmaster.Date getBornRange() {
		return new com.example.guessmaster.Date(born);
	}

//	public compBirthDate(String name, Date birthDate) {
//		this.name = name;
//		this.birthDate = new Date(birthDate); //no privacy leak
//	}
//	
//	public compBirthDate(String name, Date birthDate) {
//		this.name = name;
//		this.birthDay = new Date(birthDay); //no privacy leak
//	}
	
//	public abstract String welcomeMessage();

	public String welcomeMessage() {
		return "Welcome! Let�s start the game! "+entityType();
		
	}
	
	public String closingMessage() {
		return "Congratudations! The detailed information of "
				+ "the entity you guessed is:\n"+toString();
	}
	
	public abstract String entityType();

	public abstract Entity clone();

	public String toString() {
		return "Name: "+name+"\n"+"Born at: "+born.toString()+"\n";
	}

	public int getAwardedTicketNumber() {
		return (int)Math.round(difficulty*100);
	}
	
	
}
