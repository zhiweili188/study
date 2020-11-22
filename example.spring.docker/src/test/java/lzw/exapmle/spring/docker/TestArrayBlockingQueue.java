package lzw.exapmle.spring.docker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lzw.example.spring.docker.entity.User;

public class TestArrayBlockingQueue {
	 static ArrayBlockingQueue<User> queue = new ArrayBlockingQueue<>(10) ;
	 static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
	 static ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.NANOSECONDS, workQueue);
	public static void main(String[] args) {
		
	}
	
	class WorkerTask implements Runnable {
		private String operation;
		private ArrayBlockingQueue<User> queue;

		public WorkerTask(String operation, ArrayBlockingQueue<User> queue) {
			this.operation = operation;
			this.queue = queue;
		}

		@Override
		public void run() {
			System.out.println("start operation="+this.operation);
			this.op();
			System.out.println("end operation="+this.operation);
			
			
		}
		
		private void op() {
			for(int i=0; i<100; i++) {
				User user = new User();
				user.setId(i);
				System.out.println("loop:"+i+",queue size="+queue.size());
				boolean b = queue.offer(user);
				System.out.println("result="+b);
			}
		}
		
	}
}
