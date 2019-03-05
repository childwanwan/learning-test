package com.sitech.learning.test.service.impl;

import com.sitech.learning.test.dao.DealFaultDao;
import com.sitech.learning.test.service.IDealFaultService;
import com.sitech.learning.test.vo.DealFaultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: DealFaultServiceImpl
 * Author:   Childwanwan
 * Date:     2019/3/5 11:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class DealFaultServiceImpl implements IDealFaultService {
	@Autowired
	private DealFaultDao dealFaultDao;
	/**
	 * 查询所有Fault，返回List<FaultVo>
	 *
	 * @return
	 */
	@Override
	public List<DealFaultVo> queryDealFault() {
		//System.out.println(dealFaultDao.queryDealFault());
		return dealFaultDao.queryDealFault();
	}

	@Override
	public int insertDealFault(DealFaultVo dealFaultVo) {
		return dealFaultDao.insertDealFault(dealFaultVo);
	}

	@Override
	public int updateDealFault(DealFaultVo dealFaultVo) {
		return dealFaultDao.updateDealFault(dealFaultVo);
	}

	@Override
	public List<DealFaultVo> queryDealFaultByFaultId(DealFaultVo dealFaultVo) {
		return dealFaultDao.queryDealFaultByFaultId(dealFaultVo);
	}

	@Override
	public int updateDealFaultStatus(DealFaultVo dealFaultVo) {
		return dealFaultDao.updateDealFaultStatus(dealFaultVo);
	}


}
