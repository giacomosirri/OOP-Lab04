package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.Set;

public class Arm extends AbstractOperableComponent {
	
	private static final double ENERGY_CONSUMPTION = 2.5;
	
	private boolean grabbing;

	public Arm(String name, ExpandibleRobot robot, Set<Command> commands) {
		super(name, robot, commands);
	}
	
	public Arm(String name, ExpandibleRobot robot) {
		super(name, robot);
	}

	public double getEnergyConsumption() {
		return Arm.ENERGY_CONSUMPTION;
	}

	public boolean isGrabbing() {
		return this.grabbing;
	}
	
	protected void differentiateAction() {
		if (this.getSelectedCommand().getName() == "pick") {
			if(!isGrabbing()) {
				this.grabbing = true;
				this.getEnergyConsumption();
			}
		} else if (this.getSelectedCommand().getName() == "drop") {
			if(isGrabbing()) {
				this.grabbing = false;
				this.getEnergyConsumption();
			}
		}
	}

}
