package it.unibo.oop.lab04.expandiblerobot.base;

public interface CommandInterface {

	String getName();
	
	int getId();
	
	boolean isSelected();
	
	void setSelection(boolean status);
}
