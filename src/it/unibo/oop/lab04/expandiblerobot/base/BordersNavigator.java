package it.unibo.oop.lab04.expandiblerobot.base;

import it.unibo.oop.lab04.expandiblerobot.components.AbstractComponent;
import it.unibo.oop.lab04.robot.base.*;

public class BordersNavigator extends AbstractComponent {

	private static final double ENERGY_CONSUMPTION = 1.2;
	
	private Position2D direction = new RobotPosition(1,0);

	public BordersNavigator(String name) {
		super(name);
	}
	
	public double getEnergyConsumption() {	
		return BordersNavigator.ENERGY_CONSUMPTION;
	}

	private Position2D getDirection() {
		return new RobotPosition(this.direction.getX(), this.direction.getY());
	}
	
	private void convertDirectionIntoMovement() {
		if (this.getDirection().equals(new RobotPosition(-1, 0))) {
			this.getRobot().moveLeft();
		} else if (this.getDirection().equals(new RobotPosition(1, 0))) {
			this.getRobot().moveRight();
		} else if (this.getDirection().equals(new RobotPosition(0, -1))) {
			this.getRobot().moveDown();
		} else {
			this.getRobot().moveUp();
		}
	}
	
	public double executeAction() {
		while (this.isConnected() /*&& this.isSwitchedOn()*/) {
			if (!this.checkDirection()) {
				this.setNewDirection();
			}
			this.convertDirectionIntoMovement();
			return this.finalOp(true);
		}
		return this.finalOp(false);
	}

	private boolean checkDirection() {
		var pos = new RobotPosition(0,0);
		pos = pos.sumVector(new RobotPosition(this.direction.getX() + this.getRobot().getPosition().getX(),
				this.direction.getY() + this.getRobot().getPosition().getY()));
		return this.isWithinWorld(pos);
	}

    private boolean isWithinWorld(final Position2D p) {
        final var x = p.getX();
        final var y = p.getY();
        return x >= RobotEnvironment.X_LOWER_LIMIT && x <= RobotEnvironment.X_UPPER_LIMIT && 
        		y >= RobotEnvironment.Y_LOWER_LIMIT && y <= RobotEnvironment.Y_UPPER_LIMIT;
    }
    
    private void setNewDirection() {
    	direction = new RobotPosition(this.getDirection().getY(), -this.getDirection().getX());
    }

}
