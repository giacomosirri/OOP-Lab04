package it.unibo.oop.lab04.expandiblerobot.base;

import it.unibo.oop.lab04.robot.base.*;

public class BordersNavigator extends AbstractComponent {

	private static final double ENERGY_CONSUMPTION = 1.2;
	
	private Position2D direction = new RobotPosition(1,0);

	public BordersNavigator(String name) {
		super(name);
	}

	public void switchOn() {
		if (this.isConnected()) {
			super.switchOn();
		}
	}
	public double getEnergyConsumption() {	
		return BordersNavigator.ENERGY_CONSUMPTION;
	}

	protected void differentiateAction() {
		Position2D p = this.getRobot().getField().getPosition();
		while (this.isSwitchedOn()) {
			if (this.checkDirection()) {
				p = p.sumVector(direction);
			}
			else {
				direction = setNewDirection();
			}
		}
	}

	private boolean checkDirection() {
		var pos = new RobotPosition(0,0);
		pos.sumVector(new RobotPosition(this.direction.getX() + this.getRobot().getField().getPosition().getX(),
				this.direction.getY() + this.getRobot().getField().getPosition().getY()));
		return this.isWithinWorld(pos);
	}

    private boolean isWithinWorld(final Position2D p) {
        final var x = p.getX();
        final var y = p.getY();
        return x >= RobotEnvironment.X_LOWER_LIMIT && x <= RobotEnvironment.X_UPPER_LIMIT && 
        		y >= RobotEnvironment.Y_LOWER_LIMIT && y <= RobotEnvironment.Y_UPPER_LIMIT;
    }
    
    private Position2D setNewDirection() {
    	return new RobotPosition(0,1);
    }
}
