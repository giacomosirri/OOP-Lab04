package it.unibo.oop.lab04.expandiblerobot.base;

import it.unibo.oop.lab04.robot.base.*;
import java.util.*;

public class ExpandibleRobot extends BaseRobot implements ExpandibleRobotInterface{
	
	private final Set<Component> components;

	public ExpandibleRobot(String robotName, Set<Component> comp) {
		super(robotName);
		this.components = comp;
		for (Component c : this.components) {
			c.setRobot(this);
		}
	}

	public ExpandibleRobot(String robotName) {
		super(robotName);
		this.components = null;
	}
	
	public String getName() {
		return this.getName();
	}

	public Set<Component> getComponents() {
		return this.components;
	}
	
	public void addComponent(Component c) {
		this.components.add(c);
		for (Component comp : this.components) {
			comp.setRobot(this);
		}
	}
	
	public void putAllInMotion() {
		for (final Component c : components) {
			if (c.isSwitchedOn()) {
				c.executeAction();
			}
		}
	}
	
	public String toString() {
		String s = "Components: ";
		for (Component c : components) {
			s = s + c + ", ";
		}
		return s = s + " battery level: " + this.getBatteryLevel() + " position: " + 
				"(" + this.getPosition().getX() + "," + this.getPosition().getY() + ")";
	}

}
