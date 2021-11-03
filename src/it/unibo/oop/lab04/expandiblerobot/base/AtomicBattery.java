package it.unibo.oop.lab04.expandiblerobot.base;

import it.unibo.oop.lab04.expandiblerobot.components.AbstractComponent;

public class AtomicBattery extends AbstractComponent {

	private static final double ENERGY_CONSUMPTION = 18;
	
	public AtomicBattery(String name) {
		super(name);
	}


	public double getEnergyConsumption() {
		return AtomicBattery.ENERGY_CONSUMPTION;
	}

	public double executeAction() {
		if (this.isSwitchedOn() && this.isConnected() && this.getRobot().getBatteryLevel() > 0.5) {
			this.getRobot().recharge();
			return this.finalOp(true);	
		}
		else {
			return this.finalOp(false);
		}
	}

}
