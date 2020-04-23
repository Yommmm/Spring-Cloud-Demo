package io.yommmm.mymybatis.mapper;

import io.yommmm.mymybatis.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByPrimaryKey(String userId);

    List<User> selectAll();
}
