package com.sitech.learning.test.action;

import com.sitech.learning.test.service.IDealFaultService;
import com.sitech.learning.test.service.IFaultService;
import com.sitech.learning.test.vo.DealFaultVo;
import com.sitech.learning.test.vo.FaultVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: DealFaultAction
 * Author:   Childwanwan
 * Date:     2019/3/5 11:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
public class DealFaultAction {
	@Autowired
	private IDealFaultService dealFaultService;
	@Autowired
	private IFaultService faultService;

	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/deal_fault/test", method = RequestMethod.GET)
	public Map<Object,Object> test() {
		Map<Object,Object> map = new HashMap<>();
		List<DealFaultVo> list = dealFaultService.queryDealFault();
		if (list.size()>0){
			map.put("code",1);
			map.put("message","数据查询成功");
			map.put("data",list);
		}else {
			map.put("code",0);
			map.put("message","数据查询失败");
		}
		//System.out.println(list);
		//returnJson.put("data",list.get(1));
		return map;
	}


	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@Transactional
	@RequestMapping(value = "/deal_fault/transfer", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> transferToManager(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);
		JSONObject returnJson = new JSONObject();
		DealFaultVo dealFaultVo = new DealFaultVo();
		dealFaultVo.setId(jsonObject.get("id").toString());
		dealFaultVo.setStatus(1);
		dealFaultVo.setToUsername(jsonObject.get("toUsername").toString());
		dealFaultVo.setUrl(jsonObject.get("url").toString());
		dealFaultVo.setOperateTime(new Date());
		if (dealFaultService.updateDealFault(dealFaultVo)>0){
			FaultVo faultVo = new FaultVo();
			faultVo.setStatus(3);
			faultVo.setId(jsonObject.get("faultId").toString());
			if(faultService.updateFaultByCoder(faultVo)>0){
				returnJson.put("code",1);
				returnJson.put("message","处理成功");
			}else {
				returnJson.put("code",-1);
				returnJson.put("message","处理失败");
			}
		}else{
			returnJson.put("code", -1);
			returnJson.put("message", "处理失败");
		}

		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}
}
