package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;

public class CypherBreaker {
	
	private static final int MAX_QUEUE_SIZE = 100;

	private BlockingQueue<Resultable> queue;
	private String cypherText;
	
	public CypherBreaker(String cypherText){
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cypherText = cypherText;
		init();
	}
	
	public void init(){
		for (int i=2;i< cypherText.length()/2;i++){
			new Thread(new Decryptor(queue, cypherText)).start();
		}
		new Thread(new Runnable(){
			public void run(){
				while(!queue.isEmpty()){
					try{
						Resultable r = queue.take();
						
					}catch (InterruptedException e) {
						e.printStackTrace();
				}
				}	
			}
		});
	}
}
