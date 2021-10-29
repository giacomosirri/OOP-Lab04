package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.Set;

public interface ExpandibleRobotInterface {

	String getName();
			
	Set<Component> getComponents();
	
	void executeAction(Component component);

	void putAllInMotion();

}
