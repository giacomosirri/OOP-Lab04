package it.unibo.oop.lab04.expandiblerobot.base;

import it.unibo.oop.lab04.expandiblerobot.components.Command;
import it.unibo.oop.lab04.expandiblerobot.components.Component;
import it.unibo.oop.lab04.expandiblerobot.components.OperableComponent;
import it.unibo.oop.lab04.robot.base.BaseRobot;

import java.util.*;

public class ExpandibleRobot extends BaseRobot implements ExpandibleRobotInterface{
	
	private final Set<Component> components;

	public ExpandibleRobot(String robotName, Set<Component> components) {
		super(robotName);
		this.components = components;
		for (final Component c: this.components) {
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
	
	public void addComponent(Component component) {
		this.components.add(component);
		for (final Component c : this.components) {
			c.setRobot(this);
		}
	}
	
	public void putAllInMotion() {
		for (final Component c : components) {
			this.executeAction(c);
		}
	}

	public boolean executeAction(final OperableComponent component, final Command command) {
		if (this.isBatteryEnough(component.getEnergyConsumption()) && component.getRobot() == this) {
			this.consumeBattery(component.executeAction(command));
			return true;
		}
		return false;
	}
	
	public boolean executeAction(final Component component) {
		if (this.isBatteryEnough(component.getEnergyConsumption()) && component.getRobot() == this) {
			double energyConsumption = component.executeAction();
			if (!(component instanceof BordersNavigator)) { // viene già calcolata nella move
				this.consumeBattery(energyConsumption);
			}
			return true;
		}
		return false;
	}
	
	public String toString() {
	/*	String s = "Components: ";
		var iterator = this.components.iterator();
		while(iterator.hasNext()) {
			s = s + iterator.next();
		}*/
		return " battery level: " + this.getBatteryLevel() + " position: " + 
				"(" + this.getPosition().getX() + "," + this.getPosition().getY() + ")";
	}

}
