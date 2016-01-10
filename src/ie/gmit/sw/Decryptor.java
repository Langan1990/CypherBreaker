package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable{
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	
	
	public void run() {
		RailFence rf = new RailFence();
		String plainText = rf.decrypt(cypherText, key);
		//Get the score
		
		Resultable r = null;
		try{
			queue.put(r);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	public Decryptor(BlockingQueue<Resultable> queue, String cypherText){
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
	}
	
	

}
