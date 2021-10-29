package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.Set;

public class Arm extends AbstractOperableComponent {
	
	private static final double ENERGY_CONSUMPTION = 2.5;
	
	private boolean grabbing;

	public Arm(String name, Set<Command> commands) {
		super(name, commands);
	}
	
	public Arm(String name) {
		super(name);
	}

	public double getEnergyConsumption() {
		return Arm.ENERGY_CONSUMPTION;
	}

	public boolean isGrabbing() {
		return this.grabbing;
	}
	
	private boolean pick() {
		if (!this.isGrabbing()) {
			this.grabbing = true;
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean drop() {
		if (this.isGrabbing()) {
			this.grabbing = false;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean executeAction(Command command) {
		if (command.equals(new Command("pick", 1))) {
			this.finalOp(this.pick());
		}
		if (command.equals(new Command("drop", 2))) {
			this.finalOp(this.drop());
		}
		return false;
	}

}
