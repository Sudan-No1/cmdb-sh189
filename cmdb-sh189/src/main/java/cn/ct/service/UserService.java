package cn.ct.service;

import java.util.Map;

public interface UserService {

	Map<String, Object> findUserByUsername(String username);

}
