package lzw.example.spring.docker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lzw.example.spring.docker.entity.User;
import lzw.example.spring.docker.mapper.UserMapper;

@Service
public class UserService {
	 @Autowired
	    UserMapper userMapper;
	    public User select(int id){
	    	List<Integer> ids = new ArrayList<>();
	    	for(int i=0;i<20;i++) {
	    		ids.add(i);
	    	}
	    	userMapper.selectMulti(ids);
	        return new User();
	    }
}
