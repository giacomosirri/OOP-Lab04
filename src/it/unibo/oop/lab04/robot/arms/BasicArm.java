package it.unibo.oop.lab04.robot.arms;

public class BasicArm {

	static final double CONSUMPTION_FOR_PICKUP = 1.5;
	static final double CONSUMPTION_FOR_DROPDOWN = 0.8;
	
	private final String name;
	private boolean grabbing;
	
	public BasicArm(String name) {
		this.name = name;
	}
	
	public boolean isGrabbing() {
		return this.grabbing;
	}

	public void pickUp() {
		if (!this.isGrabbing()) {
			this.grabbing = true;
		}
	}
	
	public void dropDown() {
		this.grabbing = false;
	}
	
	public double getConsumptionForPickUp() {
		return BasicArm.CONSUMPTION_FOR_PICKUP;
	}

	public double getConsumptionForDropDown() {
		return BasicArm.CONSUMPTION_FOR_DROPDOWN;
	}
	
	public String toString() {
		return name + "is grabbing an object: " + isGrabbing();
	}
}
