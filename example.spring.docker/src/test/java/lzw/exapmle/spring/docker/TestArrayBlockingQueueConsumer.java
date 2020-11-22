package lzw.exapmle.spring.docker;

import java.util.concurrent.TimeUnit;

import lzw.example.spring.docker.entity.User;

public class TestArrayBlockingQueueConsumer {
	public static void main(String[] args) {

		TestArrayBlockingQueueConsumer c = new TestArrayBlockingQueueConsumer();
		//c.testPeek();
		//c.testPoll();
		c.testPollWithTime();
		//c.testTake();
	}
	
	public  void testTake() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		
		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);

		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=get");
			for (int i = 0; i < 100; i++) {
				System.out.println("#loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				User user = null;
				try {
					user = testArrayBlockingQueue.queue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("#result=" + user);
			}
			System.out.println("end operation=get");
		});
		//testArrayBlockingQueue.pool.shutdown();
	}
	
	public  void testPoll() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		
		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);

		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=get");
			for (int i = 0; i < 100; i++) {
				System.out.println("#loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				User user = null;
					user = testArrayBlockingQueue.queue.poll();
				System.out.println("#result=" + user);
			}
			System.out.println("end operation=get");
		});
		//testArrayBlockingQueue.pool.shutdown();
	}
	
	public  void testPollWithTime() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		
		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);

		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=get");
			for (int i = 0; i < 100; i++) {
				System.out.println("#loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				User user = null;
					try {
						user = testArrayBlockingQueue.queue.poll(1000, TimeUnit.NANOSECONDS);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("#result=" + user);
			}
			System.out.println("end operation=get");
		});
		//testArrayBlockingQueue.pool.shutdown();
	}
	
	public  void testPeek() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		
		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);

		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=get");
			for (int i = 0; i < 100; i++) {
				System.out.println("#loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				User user = null;
					user = testArrayBlockingQueue.queue.peek();
				System.out.println("#result=" + user);
			}
			System.out.println("end operation=get");
		});
		//testArrayBlockingQueue.pool.shutdown();
	}
}
