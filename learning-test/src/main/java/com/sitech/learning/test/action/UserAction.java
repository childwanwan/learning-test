package com.sitech.learning.test.action;

import com.sitech.learning.test.service.IUserService;
import com.sitech.learning.test.vo.UserVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserAction
 * Author:   Childwanwan
 * Date:     2019/3/4 15:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
public class UserAction {
	@Autowired
	private IUserService userService;
	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/user/get_user_coding", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getUserCoding() {
		System.out.println("test");
		JSONObject returnJson = new JSONObject();
		List<UserVo> list = userService.queryUser();
		if(list.size()>0){
			returnJson.put("code",1);
			returnJson.put("message","获取成功");
			returnJson.put("data",list);
		}else {
			returnJson.put("code",0);
			returnJson.put("message","获取失败");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}


	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/user/get_user_manager", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getUserManager() {
		//System.out.println("test");
		JSONObject returnJson = new JSONObject();
		List<UserVo> list = userService.queryUserManager();
		if (list.size()>0){
			returnJson.put("code",1);
			returnJson.put("data",list);
			returnJson.put("message","获取数据成功");
		}else {
			returnJson.put("code",0);
			returnJson.put("message","获取数据失败");
		}

		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}

	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> user_login(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);
		JSONObject returnJson = new JSONObject();
		UserVo userVo = new UserVo();
		userVo.setUsername(jsonObject.get("username").toString());
		userVo.setPassword(jsonObject.get("password").toString());
		UserVo returnUser = userService.queryUserByLogin(userVo);
		if (returnUser!=null){
			returnJson.put("code",1);
			returnJson.put("message","登入成功");
			returnJson.put("data",returnUser);
		}else {
			returnJson.put("code",-1);
			returnJson.put("message","登入失败");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}
}
