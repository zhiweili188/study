package lzw.example.spring.docker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import lzw.example.spring.docker.entity.User;

@Mapper
public interface UserMapper {
	User select(@Param("id")int id);
	User selectMulti(@Param("list")List<Integer> ids);
}
