package com.sitech.learning.test.service;

import com.sitech.learning.test.vo.DealFaultVo;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IDealFaultService
 * Author:   Childwanwan
 * Date:     2019/3/5 11:23
 * Description: 处理故障单业务接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface IDealFaultService {
	/**
	 * 查询所有DealFault，返回List<DealFaultVo>
	 *
	 * @return
	 */
	List<DealFaultVo> queryDealFault();

	/*
	 * @Author:Childwanwan
	 * @Description:转派功能插入相应的数据
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	int insertDealFault(DealFaultVo dealFaultVo);


	/*
	 * @Author:Childwanwan
	 * @Description:转派功能,返回数据到项目经理
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	int updateDealFault(DealFaultVo dealFaultVo);

	/*
	 * @Author:Childwanwan
	 * @Description:根据fault_id查询
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	List<DealFaultVo> queryDealFaultByFaultId(DealFaultVo dealFaultVo);

	/*
	 * @Author:Childwanwan
	 * @Description:根据fault_id更新状态
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	int updateDealFaultStatus(DealFaultVo dealFaultVo);
}
