package it.unibo.oop.lab04.expandiblerobot.base;

public class Command implements CommandInterface {
	
	private final String name;
	private final int id;
	private boolean selected;
	
	public Command(String name, int id) {
		this.name = name;
		this.id = id;
		this.selected = false;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelection(boolean status) {	
		this.selected = status;
	}
}
