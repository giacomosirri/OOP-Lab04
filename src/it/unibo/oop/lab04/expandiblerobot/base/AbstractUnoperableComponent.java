package it.unibo.oop.lab04.expandiblerobot.base;

public abstract class AbstractUnoperableComponent extends AbstractComponent implements UnoperableComponent {

	public AbstractUnoperableComponent(String name, ExpandibleRobot robot) {
		super(name, robot);
	}

	public AbstractUnoperableComponent(String name) {
		super(name);
	}


}
