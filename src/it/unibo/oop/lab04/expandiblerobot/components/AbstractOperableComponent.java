package it.unibo.oop.lab04.expandiblerobot.components;

import java.util.*;

public abstract class AbstractOperableComponent extends AbstractComponent implements OperableComponent {
	
	private Set<Command> commands;
	
	public AbstractOperableComponent(String name, Set<Command> commands) {
		super(name);
		this.commands = commands;
	}

	public AbstractOperableComponent(String name) {
		super(name);
		this.commands = new HashSet<Command>();
	}

	public boolean addCommand(Command command) {
		return this.commands.add(command);
	}

	public boolean removeCommand(Command command) {
		return this.commands.remove(command);
	}
	
 
}
