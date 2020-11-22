package lzw.example.spring.docker.entity;

import java.util.ArrayList;
import java.util.List;

public class TestClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Address a = new Address();
		a.setCity("深圳");
		User u = new User();
		u.setId(1);;
		u.setRealName("tom");
		u.setAddress(a);
		
		List<Address> list = new ArrayList<>();
		Address add1 = new Address();
		add1.setCity("guangdong");
		list.add(add1);
		u.setList(list);
		
		/*try {
			User b = (User)u.clone();
			System.out.println(b.equals(u));
			System.out.println(b.getRealName());
			System.out.println(b.getAddress().getCity());
			System.out.println(b.getList().get(0).getCity());
			b.getList().get(0).setCity("123");
			System.out.println(u.getList().get(0).getCity());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
