package com.sitech.learning.test.service.impl;

import com.sitech.learning.test.dao.FaultDao;
import com.sitech.learning.test.service.IFaultService;
import com.sitech.learning.test.vo.FaultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FaultServiceImpl
 * Author:   Childwanwan
 * Date:     2019/3/5 10:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class FaultServiceImpl
implements IFaultService {
	@Autowired
	private FaultDao faultDao;
	/**
	 * 查询所有Fault，返回List<FaultVo>
	 *
	 * @return
	 */
	@Override
	public List<FaultVo> queryFault() {
		return faultDao.queryFault();
	}

	@Override
	public List<FaultVo> queryFaultByPage(Integer first) {
		return faultDao.queryFaultByPage(first);
	}

	@Override
	public int insertFault(FaultVo faultVo) {
		return faultDao.insertFault(faultVo);
	}

	@Override
	public int updateFault(FaultVo faultVo) {
		return faultDao.updateFault(faultVo);
	}

	@Override
	public int updateFaultByCoder(FaultVo faultVo) {
		return faultDao.updateFaultByCoder(faultVo);
	}

	@Override
	public FaultVo queryFaultById(FaultVo faultVo) {
		return faultDao.queryFaultById(faultVo);
	}

	@Override
	public List<FaultVo> queryFaultByCondition(Date dateBegin, Date dateEnd, int branch, String name) {
		return faultDao.queryFaultByCondition(dateBegin,dateEnd,branch,name);
	}

	@Override
	public int updateFaultById(FaultVo faultVo) {
		return faultDao.updateFaultById(faultVo);
	}


}
