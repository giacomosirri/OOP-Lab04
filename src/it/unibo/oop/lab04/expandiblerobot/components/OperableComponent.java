package it.unibo.oop.lab04.expandiblerobot.components;

public interface OperableComponent extends Component {
		
	boolean addCommand(Command command);
	
	boolean removeCommand(Command command);
	
	double executeAction(Command command);

}
