import java.util.*;

public class myStack {
    
    public MazeNode top;

    public myStack(){
	top = null;
    }

    public void push(int x, int y){
	MazeNode newTop = new MazeNode(x,y);
	newTop.setNext(top);
	top = newTop;
    }

    public void push(MazeNode n){
	n.setNext(top);
	top = n;
    }

    public MazeNode pop(){
	if (empty())
	    throw new EmptyStackException();
	MazeNode output = top;
	top = top.getNext();
	return output;
    }

    public boolean empty(){
	return (top == null);
    }

    public MazeNode peek(){
	if (empty())
	    throw new EmptyStackException();
	return top;
    }

    public String toString(){
	String s = "";
	MazeNode i = top;
	while (i.getNext() != null){
	    s += i + " --> ";
	    i = i.getNext();
	}
	return s;
    }
}
