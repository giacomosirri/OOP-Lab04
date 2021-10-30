package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.Set;

public interface ExpandibleRobotInterface {

	String getName();
			
	Set<Component> getComponents();
	
	void putAllInMotion();
	
	void executeAction(Component component);
	
	void executeAction(final OperableComponent component, final Command command);

}
