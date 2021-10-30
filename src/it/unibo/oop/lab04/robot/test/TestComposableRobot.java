package it.unibo.oop.lab04.robot.test;

import java.util.HashSet;
import java.util.List;

import it.unibo.oop.lab04.expandiblerobot.base.Arm;
import it.unibo.oop.lab04.expandiblerobot.base.AtomicBattery;
import it.unibo.oop.lab04.expandiblerobot.base.BordersNavigator;
import it.unibo.oop.lab04.expandiblerobot.base.Command;
import it.unibo.oop.lab04.expandiblerobot.base.Component;
import it.unibo.oop.lab04.expandiblerobot.base.ExpandibleRobot;

/**
 * Utility class for testing expandible robots
 * 
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() {
    }

    public static void main(final String[] args) {

        /*
         * Write your own test.
         * 
         * You will need a robot with an atomic battery, two arms, and a
         * navigator system. Turn on the battery only when the level is below
         * 50%.
         */
		
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
		for(int i = 0; i < 100; i++) {
			navigator.executeAction();
			System.out.println(robot);	
		}

		
    }
}
