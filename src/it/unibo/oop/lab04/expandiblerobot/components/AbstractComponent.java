package it.unibo.oop.lab04.expandiblerobot.components;

import it.unibo.oop.lab04.expandiblerobot.base.ExpandibleRobot;

public abstract class AbstractComponent implements Component {
	
	private final String name;
	private boolean switchedOn;
	private ExpandibleRobot robot;
	
	public AbstractComponent(String name, ExpandibleRobot robot) {
		this.name = name;
		this.switchedOn = false;
		this.robot = robot;
	}
	
	public AbstractComponent(String name) {
		this(name, null);
	}
	
	public String getName() {
		return this.name;
	}

	public boolean isSwitchedOn() {
		return this.switchedOn == true;
	}
	
	public void switchOn() {
		if(!this.isSwitchedOn() && this.isConnected()) { // si accende solo se è connesso a qualche robot
			this.switchedOn = true;
		}
	}
	
	public void switchOff() {
		this.switchedOn = false;
	}
	
	public boolean isConnected() {
		return this.robot != null;
	}

	public ExpandibleRobot getRobot() {
		return this.robot;
	}
	
	public void setRobot(ExpandibleRobot robot) {
		if(!this.isConnected()) { // si può connettere solo ad un robot alla volta
			this.robot = robot;
		}
	}
	
	public abstract double getEnergyConsumption();
	
	protected double finalOp(boolean executed) {
		if (executed) {
			return this.getEnergyConsumption();
		}
		return 0;
	}
	
	public abstract double executeAction();
	
	public String toString() {
		return "[Component name=" + this.getName() + ", switchedOn=" + this.isSwitchedOn() + ", robot=" 
				+ this.getRobot() + "]";
	}

}
