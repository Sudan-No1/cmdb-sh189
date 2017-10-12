package cn.ct.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ct.dao.UserDao;
import cn.ct.service.UserService;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

}
