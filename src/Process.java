//import java.util.concurrent.Semaphore;


public class Process extends Thread {
	
	public int processID;
    ProcessState status=ProcessState.New;	
	
    
    Semaphore S=new Semaphore();
	
    
    

	public Process() {
	
	}
    
	public Process(int m) {
		processID = m;
	}
	@Override
	public void run() {
	
	
		switch(processID)
		{
		case 1:try {
				process1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}break;
		case 2:try {
				process2();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}break;
		case 3:try {
				process3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
		case 4:try {
				process4();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
	    case 5:try {
				process5();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
		}
		
		System.out.println(getProcessState(this));
		
		
	
	
	}
	
	

	
	
	
	private void process1() throws InterruptedException  {
		S.semInputWait(S.sema_input);
		 S.semReadWait(S.sema_read);
		  S.semPrintWait(S.sema_print);
		 
		OperatingSystem.printText("Enter File Name: ");
	
		
		
		OperatingSystem.printText(OperatingSystem.readFile(OperatingSystem.TakeInput()));
		
		
		S.semPrintPost(S.sema_print);
		S.semReadPost(S.sema_read);
		S.semInputPost(S.sema_input);
		setProcessState(this,ProcessState.Terminated);
		
		
		
		}
	
	
	private void process2() throws InterruptedException {
		S.semInputWait(S.sema_input);
		  S.semWriteWait(S.sema_write);
		  S.semPrintWait(S.sema_print);
		  
		
		OperatingSystem.printText("Enter File Name: ");
		
		
		String filename= OperatingSystem.TakeInput();
		
		
		OperatingSystem.printText("Enter Data: ");
		
		
		String data= OperatingSystem.TakeInput();
		
		
		
		OperatingSystem.writefile(filename,data);
	
		
		S.semPrintPost(S.sema_print);
		S.semWritePost(S.sema_write);
		S.semInputPost(S.sema_input);
		setProcessState(this,ProcessState.Terminated);
		
		}
	
	private void process3() throws InterruptedException {
		int x=0;
		S.semPrintWait(S.sema_print);
	
		while (x<301)
		{ 
			OperatingSystem.printText(x+"\n");
			x++;
		}
	
		S.semPrintPost(S.sema_print);
		setProcessState(this,ProcessState.Terminated);
	
		}
	
	private void process4() throws InterruptedException {
	
		int x=500;
		
		S.semPrintWait(S.sema_print);

		while (x<1001)
		{
			OperatingSystem.printText(x+"\n");
			x++;
		}	
	
		S.semPrintPost(S.sema_print);
		setProcessState(this,ProcessState.Terminated);
	
		}
	private void process5() throws InterruptedException {
		S.semInputWait(S.sema_input);
		S.semWriteWait(S.sema_write);
		S.semPrintWait(S.sema_print);
		
	
		OperatingSystem.printText("Enter LowerBound: ");
		
	
		String lower= OperatingSystem.TakeInput();
		
		
		OperatingSystem.printText("Enter UpperBound: ");
		
		
		String upper= OperatingSystem.TakeInput();
		
		
		int lowernbr=Integer.parseInt(lower);
		int uppernbr=Integer.parseInt(upper);
		String data="";
		
		while (lowernbr<=uppernbr)
		{
			data+=lowernbr++ +"\n";
		}
		
		
		
		
		OperatingSystem.writefile("P5.txt", data);
		
	
		S.semPrintPost(S.sema_print);
		S.semWritePost(S.sema_write);
		S.semInputPost(S.sema_input);
		setProcessState(this,ProcessState.Terminated);
	}
	
	 public static void setProcessState(Process p, ProcessState s) {
		 p.status=s;
		 if (s == ProcessState.Terminated)
		 {
			 OperatingSystem.ProcessTable.remove(OperatingSystem.ProcessTable.indexOf(p));
		 }
	}
	 
	 public static ProcessState getProcessState(Process p) {
		 return p.status;
	}
}
