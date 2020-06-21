import java.util.PriorityQueue;

import sun.misc.Queue;




public class Semaphore {
	
	static PriorityQueue<Integer> read_q=new PriorityQueue<Integer>();
	static PriorityQueue<Integer> write_q=new PriorityQueue<Integer>();
	static PriorityQueue<Integer> print_q=new PriorityQueue<Integer>();
	static PriorityQueue<Integer> input_q=new PriorityQueue<Integer>();

	
	static int sema_read=1;
	static int read_count=0;
	
	 
	static int sema_write=1;
	static int write_count=0;
	
	static int sema_print=1;
	static int print_count=0;
	
	static int sema_input=1;
	static int input_count=0;
	 
	// Process P= new Process();
	 
	
	//////////READ//////////////
	public void semReadWait(int sema){
		int c=read_count++;
	if(sema==1)
		sema_read=0;
	else{
		read_q.add(c);
	while(read_q.contains(c)){}
	}
	}
	
	
	public void semReadPost(int sema) throws InterruptedException{
		if(read_q.isEmpty())
			sema_read=1;
		else
			read_q.remove();
			
		
	}
	
	
	///////////////////////////////////////////////
	
	///////////PRINT//////////////////////
	
	public void semPrintWait(int sema) throws InterruptedException{
		int c=print_count++;
		
		if(sema==1)
			sema_print=0;
		
		else{

			
			print_q.add(c);
	    while(print_q.contains(c)){}
	    	
	    
	
		
		}
			
	}
	
	public void semPrintPost(int sema) throws InterruptedException{
		
		if(print_q.isEmpty())
			sema_print=1;
		else{
			print_q.remove();
		
		}
	}
	
	///////////////////////////////////
	
	/////////WRITE//////////////////////////
	
	public void semWriteWait(int sema) throws InterruptedException{
		int c=write_count++;
		
		if(sema==1)
			sema_write=0;
		
		else{

			
			write_q.add(c);
	    while(write_q.contains(c)){}
	    	
	    
	
		
		}
			
	}
	
	
	
	public void semWritePost(int sema) throws InterruptedException{
		
		if(write_q.isEmpty())
			sema_write=1;
		
		else{
			write_q.remove();
		
		}
	}

	//////////////////////////////////////////////////
	
	/////////////////INPUT//////////////////////
	public void semInputWait(int sema) throws InterruptedException{
		int c=input_count++;
		
		if(sema==1)
			sema_input=0;
		
		else{

			
			input_q.add(c);
	    while(input_q.contains(c)){}
	    	
	    
	
		
		}
			
	}
	
	
	
	public void semInputPost(int sema) throws InterruptedException{
		
		if(input_q.isEmpty())
			sema_input=1;
		
		else{
			input_q.remove();
		
		}
	}
	
	////////////////////////////////////////////
	
	public static void main(String [] args) throws InterruptedException{
	}
	
	
}

