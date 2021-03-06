package com.sitech.learning.test.action;

import com.sitech.learning.test.service.IBranchService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BranchAction
 * Author:   Childwanwan
 * Date:     2019/3/5 11:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
public class BranchAction {
	@Autowired
	private IBranchService branchService;

	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/branch/test", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> test() {
		System.out.println("test branch");
		JSONObject returnJson = new JSONObject();
		returnJson.put("data",branchService.queryBranch());
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}
}
