package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.Set;

public interface ExpandibleRobotInterface {

	String getName();
			
	Set<Component> getComponents();
	
	void putAllInMotion();
	
	boolean executeAction(Component component);
	
	boolean executeAction(final OperableComponent component, final Command command);

}
