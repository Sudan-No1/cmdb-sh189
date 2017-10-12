package cn.ct.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ct.service.UserService;
import cn.ct.util.Ciphers;

@Controller
public class UserCotroller {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String toLogin(){
		return "login";
	}
	
	
	@RequestMapping("/baidu")
	public void toBaidu(HttpServletResponse response){
		try {
			response.sendRedirect("http://www.baidu.com");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void login(@RequestParam("username")String username,
			@RequestParam("password")String password,
			HttpServletResponse response) throws IOException{
		Map<String,Object> dbUser = userService.findUserByUsername(username);
		if(dbUser != null && !dbUser.isEmpty()){
			String dbPassword = (String)dbUser.get("Password");
			String encrypt = Ciphers.encrypt(password);
			if(dbPassword.equals(encrypt)){
				response.sendRedirect("http://www.baidu.com?username="+username);
			}else{
				response.sendRedirect("/login");
			}
		}
	}

}
