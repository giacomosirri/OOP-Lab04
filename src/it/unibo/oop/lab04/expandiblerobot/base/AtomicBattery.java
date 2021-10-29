package it.unibo.oop.lab04.expandiblerobot.base;

public class AtomicBattery extends AbstractComponent {

	private static final double ENERGY_CONSUMPTION = 18;
	
	public AtomicBattery(String name) {
		super(name);
	}


	public double getEnergyConsumption() {
		return AtomicBattery.ENERGY_CONSUMPTION;
	}

	public boolean executeAction() {
		if (this.getRobot().getBatteryLevel() > 0.5) {
			this.getRobot().recharge();
			return true;	
		}
		else {
			return false;
		}
	}

}
