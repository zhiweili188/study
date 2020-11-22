package lzw.exapmle.spring.docker;

import java.util.concurrent.Callable;

import lzw.example.spring.docker.entity.User;

public class CallableTask implements Callable<User> {
    private User user;
	public CallableTask(User user) {
		this.user = user;
	}
	@Override
	public User call() throws Exception {
		System.out.println("Callable task+"+ this.user);
		this.user.setUserName(this.user.getId()+this.user.getUserName());
		return this.user;
	}

}
