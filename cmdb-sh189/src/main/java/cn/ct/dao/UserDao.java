package cn.ct.dao;

import java.util.Map;

public interface UserDao {

	Map<String, Object> findUserByUsername(String username);

}
