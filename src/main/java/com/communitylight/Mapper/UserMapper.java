package com.communitylight.Mapper;

import com.communitylight.Model.User;
import com.communitylight.Model.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface UserMapper {


    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);


    int insert(User record);

    int insertSelective(User record);

    List <User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("SELECT * FROM User where cookie = #{cookie}")
    User findByToken(@Param("cookie") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);


}