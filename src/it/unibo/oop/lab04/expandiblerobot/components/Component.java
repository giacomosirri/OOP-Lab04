package it.unibo.oop.lab04.expandiblerobot.components;

import it.unibo.oop.lab04.expandiblerobot.base.ExpandibleRobot;

public interface Component {
	
	String getName();
	
	boolean isSwitchedOn();
	
	void switchOn();
	
	void switchOff();
	
	boolean isConnected();
	
	ExpandibleRobot getRobot();
	
	void setRobot(ExpandibleRobot robot);
	
	double getEnergyConsumption();

	double executeAction();
	
}
