package lzw.exapmle.spring.docker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lzw.example.spring.docker.entity.User;

class TestThreadPoolExecutor {
	ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
	RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
	ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.MILLISECONDS, workQueue, Executors.defaultThreadFactory(), handler);
	AtomicLong seq = new AtomicLong(10);

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		executor.awaitTermination(100000, TimeUnit.MILLISECONDS);
		printInfo();
	}

	@Test
	void test() {
		for(int i=0;i<20;i++) {
			executor.submit(new RunnableTask());
			printInfo();
			
		}
		
	}
	
	@Test
	void testScheduled() {
		 ScheduledThreadPoolExecutor exe = new ScheduledThreadPoolExecutor(2, Executors.defaultThreadFactory(), handler);
		 
		 //exe.execute(new RunnableTask());
		 for(int i=0;i<20;i++) {
		 exe.schedule(new RunnableTask("scheduleTask",seq.incrementAndGet()), 10, TimeUnit.MILLISECONDS);
		 exe.schedule(new RunnableTask("scheduleTask",seq.incrementAndGet()), 20, TimeUnit.MILLISECONDS);
		 exe.schedule(new RunnableTask("scheduleTask",seq.incrementAndGet()), 40, TimeUnit.MILLISECONDS);
		 }
		
	}
	
	
	void printInfo() {
		System.out.println("getPoolSize="+executor.getPoolSize()+",getTaskCount="+executor.getTaskCount()+",getActiveCount="+executor.getActiveCount()
		+",getCompletedTaskCount="+executor.getCompletedTaskCount());
		System.out.println("workQueue.size()="+workQueue.size());
	}

}
