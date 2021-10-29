package it.unibo.oop.lab04.expandiblerobot.base;

public class AtomicBattery extends AbstractComponent {

	private static final double ENERGY_CONSUMPTION = 18;
	
	public AtomicBattery(String name, ExpandibleRobot robot) {
		super(name, robot);
	}
	
	public AtomicBattery(String name) {
		super(name);
	}

	public void switchOn() {
		if (this.isConnected() && this.getRobot().getBatteryLevel() < 0.5) {
			super.switchOn();
		}
	}

	public double getEnergyConsumption() {
		return AtomicBattery.ENERGY_CONSUMPTION;
	}

	protected void differentiateAction() {
		this.getRobot().changeBatteryLevel(100);
	}

}
