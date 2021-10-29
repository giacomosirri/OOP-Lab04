package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.*;

public abstract class AbstractOperableComponent extends AbstractComponent implements OperableComponent {
	
	private Set<Command> commands;
	private Command selectedCommand;
	
	public AbstractOperableComponent(String name, ExpandibleRobot robot, Set<Command> commands) {
		super(name, robot);
		this.commands = commands;
		this.selectedCommand = null;
	}

	public AbstractOperableComponent(String name, ExpandibleRobot robot) {
		super(name, robot);
		this.commands = new HashSet<Command>();
		this.selectedCommand = null;
	}

	public boolean selectCommand(Command command) {
		if (this.commands.contains(command)) {
			this.selectedCommand = command;
			return true;
		}
		return false;
	}

	public Command getSelectedCommand() {
		return this.selectedCommand;
	}
	
	public void setListCommand(Set<Command> commands) {
		this.commands = commands;
	}

	public boolean addCommand(Command command) {
		return this.commands.add(command);
	}

	public boolean removeCommand(Command command) {
		return this.commands.remove(command);
	}
	
	public void executeAction(Command command) {
		if (this.selectCommand(command)) {
			differentiateAction();
			this.getRobot().changeBatteryLevel(this.getEnergyConsumption());
		}
		this.switchOff();
	}
 
}
