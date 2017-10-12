package cn.ct.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.ct.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> findUserByUsername(String username) {
		String sql = "select * from \"User\" where \"Status\" = 'A' and \"Username\" = ?;";
		return jdbcTemplate.queryForMap(sql,username);
	}

}
