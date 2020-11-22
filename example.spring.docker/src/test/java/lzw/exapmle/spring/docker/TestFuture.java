package lzw.exapmle.spring.docker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lzw.example.spring.docker.entity.User;

public class TestFuture {

	public static void main(String[] args) {
		ExecutorService s = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
		
		User user = new User();
		/*user.setId(1);
		user.setUserName("abc");
		CallableTask callable = new CallableTask(user);
		FutureTask<User> task = new FutureTask<>(callable) ;
		
		
		Future f = s.submit(task,user);
		try {
			User u = (User)f.get();
			System.out.println(u.getUserName());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(task.isDone());*/
		
		ExecutorCompletionService<User> ecs = new ExecutorCompletionService<>(s);
		/*for(int i=0;i<10;i++) {
			 user = new User();
				user.setId(i+1);
				user.setUserName("abc");
				ecs.submit(new CallableTask(user));
		}
		try {
			for(int i=0;i<10;i++) {
				Future<User> f = ecs.take();
				System.out.println(f.get().getUserName());
			}
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		List<Future<User>> res = new ArrayList<>();
		for(int i=0;i<10;i++) {
			 user = new User();
				user.setId(i+1);
				user.setUserName("abc");
				res.add(ecs.submit(new CallableTask(user)));
		}
		res.stream().forEach((f)->{
			try {
				System.out.println(f.get().getUserName());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
