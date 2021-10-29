package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.*;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

	private static final double BATTERY_CONSUMPTION_FOR_CARRYING = 0.6;
	
	private final BasicArm arm1;
	private final BasicArm arm2;
	private int carriedItems;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
		this.arm1 = new BasicArm("arm1");
		this.arm2 = new BasicArm("arm2");
	}

	public boolean pickUp() {
		if(arm1.isGrabbing() && arm2.isGrabbing()) {
			return false;
		} else {
			if(!arm1.isGrabbing()) {
				arm1.pickUp();
			}
			else {
				arm2.pickUp();
			}
			this.carriedItems++;
			super.consumeBattery(BasicArm.CONSUMPTION_FOR_PICKUP);
			return true;
		}
	}

	public boolean dropDown() {
		if (!arm1.isGrabbing() && !arm2.isGrabbing()) {
			return false;
		} else {
			if (arm1.isGrabbing()) {
				arm1.dropDown();
			}
			else {
				arm2.dropDown();
			}
			this.carriedItems--;
			super.consumeBattery(BasicArm.CONSUMPTION_FOR_DROPDOWN);
			return true;
		}
	}

	public int getCarriedItemsCount() {
		return this.carriedItems;
	}
		
    protected double getBatteryRequirementForMovement() {
        return MOVEMENT_DELTA_CONSUMPTION + 
        		BATTERY_CONSUMPTION_FOR_CARRYING * this.getCarriedItemsCount();
    }
}
