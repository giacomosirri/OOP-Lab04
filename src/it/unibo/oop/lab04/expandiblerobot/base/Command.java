package it.unibo.oop.lab04.expandiblerobot.base;

public class Command implements CommandInterface {
	
	private final String name;
	private final int id;
	
	public Command(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public boolean equals(Command command) {
		return this.getName() == command.getName() && this.getId() == command.getId();
	}
	
}
