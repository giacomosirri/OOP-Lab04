package it.unibo.oop.lab04.robot.test;

import java.util.*;

import it.unibo.oop.lab04.expandiblerobot.base.AtomicBattery;
import it.unibo.oop.lab04.expandiblerobot.base.BordersNavigator;
import it.unibo.oop.lab04.expandiblerobot.base.Component;
import it.unibo.oop.lab04.expandiblerobot.base.ExpandibleRobot;

public class TestMyRobot {

	public static void main(String[] args) {
		
		Set<Component> comp = new HashSet<>();
		comp.add(new AtomicBattery("battery"));
		comp.add(new BordersNavigator("navigator"));
		var robot = new ExpandibleRobot("Jack", comp);
		System.out.println(robot);
		
	}

}
