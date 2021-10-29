package it.unibo.oop.lab04.expandiblerobot.base;

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
		this.switchOff();
		if(executed) {
			return this.getEnergyConsumption();
		}
		return 0;
	}
	
	public abstract boolean executeAction();
	
	public String toString() {
		return "[Component name=" + this.name + ", switchedOn=" + this.switchedOn + ", robot=" 
				+ this.robot + "]";
	}

}
