package com.sitech.learning.test.action;

import com.sitech.learning.test.form.DealFaultForm;
import com.sitech.learning.test.form.FaultForm;
import com.sitech.learning.test.service.IDealFaultService;
import com.sitech.learning.test.service.IFaultService;
import com.sitech.learning.test.utils.CommonUtils;
import com.sitech.learning.test.vo.DealFaultVo;
import com.sitech.learning.test.vo.FaultVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FaultAction
 * Author:   Childwanwan
 * Date:     2019/3/5 10:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
public class FaultAction {
	@Autowired
	private IDealFaultService dealFaultService;
	@Autowired
	private CommonUtils commonUtils;
	@Autowired
	private IFaultService faultService;
	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/fault/test", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> test() {
		System.out.println("test fault");
		JSONObject returnJson = new JSONObject();
		returnJson.put("data",faultService.queryFault());
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/fault/get_fault_by_faultId", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getFaultById(@RequestParam("id") String id) {

		JSONObject returnJson = new JSONObject();

		FaultVo faultParam = new FaultVo();
		faultParam.setId(id);
		FaultVo faultVo = faultService.queryFaultById(faultParam);
		if (faultVo!=null){
			returnJson.put("code",1);
			returnJson.put("data",faultVo);
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
	@Transactional
	@RequestMapping(value = "/fault/post_fault", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> postError(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);
		//获取到数据，第一层的json
		//故障系统数组
		JSONArray jsonArrayParam = jsonObject.getJSONArray("influenceSystem");

		//返回的数据
		JSONObject returnJson = new JSONObject();


		//初始化数据
		FaultVo faultVo = new FaultVo();
		faultVo.setName(jsonObject.get("name").toString());
		faultVo.setCreateDate(new Date(Long.valueOf(jsonObject.get("createDate").toString())));
		faultVo.setBranch((int) jsonObject.get("branch"));
		faultVo.setDescription(jsonObject.get("description").toString());
		faultVo.setInfluenceSystem(jsonObject.get("influenceSystem").toString());
		faultVo.setUsername(jsonObject.get("username").toString());
		faultVo.setStatus(1);
		faultVo.setId(commonUtils.getUUID());
		faultVo.setUrl(jsonObject.get("url").toString());
		try {
			if (faultService.insertFault(faultVo) > 0) {
				returnJson.put("code", 1);
				returnJson.put("data",faultVo.getId());
				returnJson.put("message", "插入数据成功");
			} else {
				returnJson.put("code", 0);
				returnJson.put("message", "插入数据失败");
			}
		} catch (Exception e) {
			returnJson.put("code", -1);
			returnJson.put("message", "系统内部异常");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}


	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,项目经理转发给技术人员
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@Transactional
	@RequestMapping(value = "/fault/transfer_fault_to_coding_man", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> transferError(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);
		//获取到数据，第一层的json
		//故障系统数组
		FaultVo faultVo = new FaultVo();
		faultVo.setId(jsonObject.get("id").toString());
		faultVo.setStatus(0);
		faultVo.setToUsername(jsonObject.get("toUsername").toString());
		//返回的数据
		JSONObject returnJson = new JSONObject();
		try {
			if (faultService.updateFault(faultVo) > 0) {
				DealFaultVo dealFaultVo = new DealFaultVo();
				dealFaultVo.setId(commonUtils.getUUID());
				dealFaultVo.setFaultId(faultVo.getId());
				dealFaultVo.setStatus(0);
				dealFaultService.insertDealFault(dealFaultVo);
				returnJson.put("code", 1);
				//returnJson.put("data",faultVo.getId());
				returnJson.put("message", "转派成功");
			} else {
				returnJson.put("code", 0);
				returnJson.put("message", "转派失败");
			}
		} catch (Exception e) {
			returnJson.put("code", -1);
			returnJson.put("message", "系统内部异常");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}




	/*
	 * @Author:Childwanwan
	 * @Description:根据FKUser获取所以得错误单
	 * @Para:* @param FKUser
	 * @data:2019/2/28  20:11
	 */
	@RequestMapping(value = "/fault/get_fault", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getAllFault(@RequestParam("currentPage") Integer currentPage) {

		System.out.println("获取所有故障单");
		System.out.println(currentPage);

		//需要返回的json数据
		JSONObject returnJson = new JSONObject();

		//调用服务层，获取到相应的List集合
		List<FaultVo> list = faultService.queryFaultByPage((currentPage-1)*10);
		//System.out.println(list);
		int count = faultService.queryFault().size();
		System.out.println(count);
		if (list != null && list.size() > 0) {
			//需要返回的data,form层的数据集合
			List<FaultForm> listForm = new ArrayList<>();
			//FaultForm faultForm = new FaultForm();
			//把数据库的数据转换成form层的数据,List<FaultVo>转换成List<FaultForm>
			for (int i = 0, j = list.size(); i < j; i++) {
				FaultForm faultForm = new FaultForm();
				faultForm.setId(list.get(i).getId());
				faultForm.setName(list.get(i).getName());
				faultForm.setCreateDate(list.get(i).getCreateDate().getTime());
				faultForm.setInfluenceSystem(list.get(i).getInfluenceSystem());
				faultForm.setBranch(list.get(i).getBranch());
				faultForm.setDescription(list.get(i).getDescription());
				faultForm.setUsername(list.get(i).getUsername());
				faultForm.setStatus(list.get(i).getStatus());
				faultForm.setUrl(list.get(i).getUrl());
				faultForm.setToUsername(list.get(i).getToUsername());

				listForm.add(faultForm);
			}
			System.out.println(listForm);

			//System.out.println(listForm);
			//返回json数据添加数据
			returnJson.put("code", 1);
			returnJson.put("message", "数据获取成功");
			returnJson.put("data", listForm);
			returnJson.put("count", count);
		} else {
			returnJson.put("code", 0);
			returnJson.put("message", "数据获取失败");
		}

		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}



	/*
	 * @Author:Childwanwan
	 * @Description:根据故障单id查询所有的数据
	 * @Para:* @param FKUser
	 * @data:2019/2/28  20:11
	 */
	@RequestMapping(value = "/fault/get_all_data", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getAllData(@RequestParam("id") String id) {


		System.out.println(id);

		//需要返回的json数据
		JSONObject returnJson = new JSONObject();

		//调用服务层，获取到相应的对象
		FaultVo faultVoParm = new FaultVo();
		faultVoParm.setId(id);
		FaultVo faultVo = faultService.queryFaultById(faultVoParm);
		if (faultVo!=null) {
			FaultForm faultForm = new FaultForm();
			faultForm.setId(id);
			faultForm.setName(faultVo.getName());
			faultForm.setCreateDate(faultVo.getCreateDate().getTime());
			faultForm.setInfluenceSystem(faultVo.getInfluenceSystem());
			faultForm.setBranch(faultVo.getBranch());
			faultForm.setDescription(faultVo.getDescription());
			faultForm.setUsername(faultVo.getUsername());
			faultForm.setStatus(faultVo.getStatus());
			faultForm.setUrl(faultVo.getUrl());
			faultForm.setToUsername(faultVo.getToUsername());
			returnJson.put("fault", faultForm);
		}
		DealFaultVo dealFaultVoParm = new DealFaultVo();
		dealFaultVoParm.setFaultId(id);
		List<DealFaultVo> list = dealFaultService.queryDealFaultByFaultId(dealFaultVoParm);
		List<DealFaultForm> returnList = new ArrayList<>();
		if (list!=null&&list.size()>0) {
			for (int i=0,j=list.size();i<j;i++) {
				DealFaultForm dealFaultForm = new DealFaultForm();
				dealFaultForm.setId(list.get(i).getId());
				dealFaultForm.setFaultId(list.get(i).getFaultId());
				if (list.get(i).getOperateTime()!=null) {
					dealFaultForm.setOperateTime(list.get(i).getOperateTime().getTime());
				}
				dealFaultForm.setStatus(list.get(i).getStatus());
				if (list.get(i).getToUsername()!=null) {
					dealFaultForm.setToUsername(list.get(i).getToUsername());
				}
				if (list.get(i).getUrl()!=null) {
					dealFaultForm.setUrl(list.get(i).getUrl());
				}
				returnList.add(dealFaultForm);
			}
			returnJson.put("dealFault",returnList);
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}


	/*
	 * @Author:Childwanwan
	 * @Description:根据故障单id查询所有的数据
	 * @Para:* @param FKUser
	 * @data:2019/2/28  20:11
	 */
	@RequestMapping(value = "/fault/get_fault_by_condition", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> getfaultByCondition(@RequestBody JSONObject jsonObject) {


		System.out.println(jsonObject);

		//需要返回的json数据
		JSONObject returnJson = new JSONObject();

		Date dateBegin = null;
		Date dateEnd = null;
		Integer branch = -1;
		String name = "";
		if (jsonObject.get("dateBegin")!=null && jsonObject.get("dateEnd")!=null){
			dateBegin = new Date(Long.valueOf(jsonObject.get("dateBegin").toString()));
			dateEnd = new Date(Long.valueOf(jsonObject.get("dateEnd").toString()));
		}
		if (jsonObject.get("branch")!=null){
			branch = Integer.valueOf(jsonObject.get("branch").toString());
		}
		if (jsonObject.get("name")!=null){
			name = jsonObject.get("name").toString();
		}
		List<FaultForm> returnList = new ArrayList<>();
		List<FaultVo> list = faultService.queryFaultByCondition(dateBegin,dateEnd,branch,name);
		for (int i=0,j=list.size();i<j;i++){
			FaultForm returnFaultForm = new FaultForm();
			returnFaultForm.setId(list.get(i).getId());
			returnFaultForm.setName(list.get(i).getName());
			returnFaultForm.setCreateDate(list.get(i).getCreateDate().getTime());
			returnFaultForm.setInfluenceSystem(list.get(i).getInfluenceSystem());
			returnFaultForm.setBranch(list.get(i).getBranch());
			returnFaultForm.setDescription(list.get(i).getDescription());
			returnFaultForm.setUsername(list.get(i).getUsername());
			returnFaultForm.setStatus(list.get(i).getStatus());
			returnFaultForm.setUrl(list.get(i).getUrl());
			returnFaultForm.setToUsername(list.get(i).getToUsername());

			returnList.add(returnFaultForm);
		}
		if (returnList.size()>0){
			returnJson.put("code",1);
			returnJson.put("message","查询成功");
			returnJson.put("data",returnList);
		}else {
			returnJson.put("code",0);
			returnJson.put("message","查询不到结果");
	}
		//System.out.println(list);
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}

	/*
	 * 批准Or不批准代码
	 * */
	@Transactional
	@RequestMapping(value = "/fault/agree", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> agreeDealFault(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);
		JSONObject returnJson = new JSONObject();
		if ("1".equals(jsonObject.get("agree").toString())){
			//agree
			FaultVo faultVo = new FaultVo();
			faultVo.setId(jsonObject.get("id").toString());
			faultVo.setStatus(2);
			if (faultService.updateFaultByCoder(faultVo)>0){
				returnJson.put("code",1);
				returnJson.put("message","已批准");
			}else {
				returnJson.put("code",0);
				returnJson.put("message","批准失败");
			}
		}else {
			//disagree
			FaultVo faultVo = new FaultVo();
			faultVo.setId(jsonObject.get("id").toString());
			faultVo.setStatus(0);

			DealFaultVo dealFaultVo = new DealFaultVo();
			dealFaultVo.setFaultId(jsonObject.get("id").toString());
			dealFaultVo.setStatus(0);
			//System.out.println(dealFaultVo);
			if (faultService.updateFaultByCoder(faultVo)>0 && dealFaultService.updateDealFaultStatus(dealFaultVo)>0){
				returnJson.put("code",1);
				returnJson.put("message","已驳回");
			}else {
				returnJson.put("code",0);
				returnJson.put("message","驳回失败");
			}
		}

		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}


	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,根据id查询
	 * @Para:* @param id
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/fault/select_fault_by_id", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> selectFaultById(@RequestParam("id") String id) {
		System.out.println(id);
		JSONObject returnJson = new JSONObject();
		FaultVo faultVo = new FaultVo();
		faultVo.setId(id);
		FaultVo returnfaultVo = faultService.queryFaultById(faultVo);
		if(returnfaultVo!=null){
			returnJson.put("code",1);
			returnJson.put("message","获取数据成功");
			returnJson.put("data",returnfaultVo);
		}else {
			returnJson.put("code",0);
			returnJson.put("message","获取数据失败");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}


	/*
	 * @Author:Childwanwan
	 * @Description:根据id插入数据
	 * @Para:* @param null
	 * @data:2019/3/6  11:06
	 */
	@Transactional
	@RequestMapping(value = "/fault/update_fault", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> updateError(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);

		JSONArray jsonArrayParam = jsonObject.getJSONArray("influenceSystem");

		//返回的数据
		JSONObject returnJson = new JSONObject();


		//初始化数据
		FaultVo faultVo = new FaultVo();
		faultVo.setName(jsonObject.get("name").toString());
		faultVo.setCreateDate(new Date(Long.valueOf(jsonObject.get("createDate").toString())));
		faultVo.setBranch((int) jsonObject.get("branch"));
		faultVo.setDescription(jsonObject.get("description").toString());
		faultVo.setInfluenceSystem(jsonObject.get("influenceSystem").toString());
		faultVo.setUsername(jsonObject.get("username").toString());
		//faultVo.setStatus(1);
		faultVo.setId(jsonObject.get("id").toString());
		try {
			if (faultService.updateFaultById(faultVo) > 0) {
				returnJson.put("code", 1);
				returnJson.put("message", "修改数据成功");
			} else {
				returnJson.put("code", 0);
				returnJson.put("message", "插入数据失败");
			}
		} catch (Exception e) {
			returnJson.put("code", -1);
			returnJson.put("message", "系统内部异常");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}
}
