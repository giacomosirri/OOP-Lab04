package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.*;

public class TestMyRobot {

	public static void main(String[] args) {
		
		Set<Component> comp = new HashSet<>();
		comp.add(new AtomicBattery("battery"));
		comp.add(new BordersNavigator("navigator"));
		var robot = new ExpandibleRobot("Jack", comp);
		System.out.println(robot);
		
	}

}
