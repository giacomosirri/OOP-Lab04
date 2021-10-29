package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.*;

public class TestMyRobot {

	public static void main(String[] args) {
		
		Set<Component> comp = new HashSet<>();
		comp.add(new AtomicBattery("battery"));
		comp.add(new BordersNavigator("navigator"));
		var robot = new ExpandibleRobot("Jack", comp);
		// two different ways to initiate an Arm
		/*Arm arm1 = new Arm("arm1", robot);
		robot.addComponents(arm1);
		arm1.addCommand(new Command("pick", 1));
		arm1.addCommand(new Command("drop", 2));
		Set<Command> commands = new HashSet<>();
		commands.add(new Command("pick", 1));
		commands.add(new Command("drop", 2));
		robot.addComponents(new Arm("arm2", robot, commands));*/
		System.out.println(robot);
		
	}

}
