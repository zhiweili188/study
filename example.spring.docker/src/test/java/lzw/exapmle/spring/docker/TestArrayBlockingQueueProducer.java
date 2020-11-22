package lzw.exapmle.spring.docker;

import java.util.concurrent.TimeUnit;

import lzw.example.spring.docker.entity.User;

public class TestArrayBlockingQueueProducer {

	public static void main(String[] args) {

		TestArrayBlockingQueueProducer p = new TestArrayBlockingQueueProducer();
		//p.testAdd();
		//p.testOffer();
		p.testOfferWithTime();
		//p.testPut();
	}
	
	public  void testOffer() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);
		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=add");
			for (int i = 0; i < 100; i++) {
				User user = new User();
				user.setId(i);
				System.out.println("$loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				boolean b = testArrayBlockingQueue.queue.offer(user);
				System.out.println("$result=" + b);
			}
			System.out.println("end operation=add");
		});

		//testArrayBlockingQueue.pool.shutdown();
	}
	
	public  void testOfferWithTime() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);
		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=add");
			for (int i = 0; i < 100; i++) {
				User user = new User();
				user.setId(i);
				System.out.println("$loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				boolean b= false;
				try {
					b = testArrayBlockingQueue.queue.offer(user,1000,TimeUnit.NANOSECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("$result=" + b);
			}
			System.out.println("end operation=add");
		});

		//testArrayBlockingQueue.pool.shutdown();
	}
	
	public  void testAdd() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);
		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=add");
			for (int i = 0; i < 100; i++) {
				User user = new User();
				user.setId(i);
				System.out.println("$loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				boolean b = testArrayBlockingQueue.queue.add(user);
				System.out.println("$result=" + b);
			}
			System.out.println("end operation=add");
		});

		//testArrayBlockingQueue.pool.shutdown();
	}
	
	public  void testPut() {

		TestArrayBlockingQueue testArrayBlockingQueue = new TestArrayBlockingQueue();

		// WorkerTask addWoker = testArrayBlockingQueue.new WorkerTask("add",queue);
		testArrayBlockingQueue.pool.execute(() -> {
			System.out.println("start operation=add");
			for (int i = 0; i < 100; i++) {
				User user = new User();
				user.setId(i);
				System.out.println("$loop:" + i + ",queue size=" + testArrayBlockingQueue.queue.size());
				try {
					testArrayBlockingQueue.queue.put(user);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("$result=");
			}
			System.out.println("end operation=add");
		});

		//testArrayBlockingQueue.pool.shutdown();
	}
}
