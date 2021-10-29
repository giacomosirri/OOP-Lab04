package it.unibo.oop.lab04.expandiblerobot.base;

import java.util.Set;

public interface OperableComponent extends Component {

	void setListCommand(Set<Command> commands);
	
	boolean addCommand(Command command);
	
	boolean removeCommand(Command command);
	
	double executeCommand(Command command);

}
