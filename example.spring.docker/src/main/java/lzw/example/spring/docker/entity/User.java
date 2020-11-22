package lzw.example.spring.docker.entity;

import java.util.List;

public class User implements Cloneable{
	 private Integer id;
	    private String userName;
	    private String passWord;
	    private String realName;
	    private Address address;
	    private List<Address> list;
	 
	    public List<Address> getList() {
			return list;
		}

		public void setList(List<Address> list) {
			this.list = list;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Integer getId() {
	        return id;
	    }
	 
	    public void setId(Integer id) {
	        this.id = id;
	    }
	 
	    public String getUserName() {
	        return userName;
	    }
	 
	    public void setUserName(String userName) {
	        this.userName = userName;
	    }
	 
	    public String getPassWord() {
	        return passWord;
	    }
	 
	    public void setPassWord(String passWord) {
	        this.passWord = passWord;
	    }
	 
	    public String getRealName() {
	        return realName;
	    }
	 
	    public void setRealName(String realName) {
	        this.realName = realName;
	    }
	 
	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", userName='" + userName + '\'' +
	                ", passWord='" + passWord + '\'' +
	                ", realName='" + realName + '\'' +
	                '}';

	    }


}
