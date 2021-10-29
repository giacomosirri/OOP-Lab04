package it.unibo.oop.lab04.expandiblerobot.base;

public abstract class AbstractComponent implements Component {
	
	private static final double MAXIMUM_ENERGY_LEVEL = 100.0;
	
	private final String name;
	private boolean switchedOn;
	private ExpandibleRobot robot;
	private double energyLevel;
	
	public AbstractComponent(String name, ExpandibleRobot robot) {
		this.name = name;
		this.switchedOn = false;
		this.robot = robot;
		this.energyLevel = AbstractComponent.MAXIMUM_ENERGY_LEVEL;
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
		if(!this.switchedOn) {
			this.switchedOn = true;
			this.executeAction();
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
		if(!this.isConnected()) {
			this.robot = robot;
		}
	}
	
	public abstract double getEnergyConsumption();
	
	public double getEnergyLevel() {
		return this.energyLevel;
	}
	
	public void executeAction() {
		differentiateAction();
		this.switchOff();
		this.getRobot().changeBatteryLevel(this.getEnergyConsumption());
	}

	protected abstract void differentiateAction();
	
	public String toString() {
		return "[Component name=" + this.name + ", switchedOn=" + this.switchedOn + ", robot=" 
				+ this.robot + ", energyLevel=" + this.energyLevel + "]";
	}

}
