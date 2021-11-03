package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.Set;
import it.unibo.oop.lab04.expandiblerobot.components.AbstractOperableComponent;
import it.unibo.oop.lab04.expandiblerobot.components.Command;

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
	
	public double executeAction(Command command) {
		if(this.isConnected() && this.isSwitchedOn()) {
			if (command.equals(new Command("pick", 1))) {
				return this.finalOp(this.pick());
			}
			if (command.equals(new Command("drop", 2))) {
				return this.finalOp(this.drop());
			}
		}
		return this.finalOp(false);
	}
	
	public double executeAction() {
		if(this.isConnected() && this.isSwitchedOn()) {
			if(this.isGrabbing()) {
				return this.finalOp(this.drop());
			}
			else {
				return this.finalOp(this.pick());
			}
		}
		return this.finalOp(false);
	}

}
