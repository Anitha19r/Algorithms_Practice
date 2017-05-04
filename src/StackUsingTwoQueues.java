import java.util.*;
public class StackUsingTwoQueues {
	Queue <Integer> q1;
	Queue <Integer> q2;
	StackUsingTwoQueues(){
		q1= new LinkedList<Integer>();
		q2= new LinkedList<Integer>();
	}
	public void push(int data){
		if(q1.isEmpty()){
			q1.add(data);
		}
		else{
			while(!q1.isEmpty())
				q2.add(q1.remove());
			q1.add(data);
			while(!q2.isEmpty())
				q1.add(q2.remove());
		}
		
	}
	public int pop(){
		try{
		return q1.remove();
		}
		catch(Exception e){
		  throw new Qexcep("QueueEmpty"); 
		}
	}
	
	public static void main(String args[]) throws Exception{
		StackUsingTwoQueues sq = new StackUsingTwoQueues();
		/*sq.push(20);
		sq.push(30);
		sq.push(40);
		sq.push(50);
		sq.push(60);
		sq.push(70);*/
		System.out.println(sq.pop());
	}
	class Qexcep extends RuntimeException{
		Qexcep(String msg){
			super(msg);
		}
		
	}
}
