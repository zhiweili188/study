package lzw.exapmle.spring.docker;

import java.util.concurrent.atomic.AtomicLong;

public class RunnableTask implements Runnable {
	private String taskName = "default-task";
	private long taskSeq;
	private static AtomicLong counter = new AtomicLong();
	
	public RunnableTask() {
		
	}
	
	public RunnableTask(String taskName) {
		this.taskName = taskName;
	}
	
	public RunnableTask(String taskName, long seq) {
		this.taskName = taskName;
		this.taskSeq = seq;
		
	}


	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+this.taskName+"-"+this.taskSeq+","+counter.incrementAndGet());

	}

}
