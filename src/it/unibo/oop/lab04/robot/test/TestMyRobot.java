package it.unibo.oop.lab04.robot.test;

import java.util.*;

import it.unibo.oop.lab04.expandiblerobot.base.Arm;
import it.unibo.oop.lab04.expandiblerobot.base.AtomicBattery;
import it.unibo.oop.lab04.expandiblerobot.base.BordersNavigator;
import it.unibo.oop.lab04.expandiblerobot.base.Command;
import it.unibo.oop.lab04.expandiblerobot.base.Component;
import it.unibo.oop.lab04.expandiblerobot.base.ExpandibleRobot;

public class TestMyRobot {

	public static void main(String[] args) {
		
		var battery = new AtomicBattery("battery");
		var navigator = new BordersNavigator("navi");
		var comp = new HashSet<Component>(List.of(battery, navigator));
		var robot = new ExpandibleRobot("Jack", comp);
		System.out.println(robot);
		var leftArm = new Arm("left", new HashSet<Command>(List.of(new Command("pick", 1), 
				new Command("drop", 2))));
		robot.addComponent(leftArm);
		leftArm.switchOn();
		robot.executeAction(leftArm, new Command("pick", 1));
		System.out.println(robot);
		robot.executeAction(leftArm);
		System.out.println(robot);
		battery.switchOn();
		battery.executeAction();
		System.out.println(robot);
		navigator.switchOn();
		navigator.executeAction();
		System.out.println(robot);
		
	}

}
