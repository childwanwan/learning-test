package com.sitech.learning.test.service;

import com.sitech.learning.test.vo.FaultVo;

import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IFaultService
 * Author:   Childwanwan
 * Date:     2019/3/5 10:57
 * Description: fault接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface IFaultService {
	/**
	 * 查询所有Fault，返回List<FaultVo>
	 *
	 * @return
	 */
	List<FaultVo> queryFault();

	/**
	 * 分页查询所有Fault，返回List<FaultVo>
	 *
	 * @return
	 */
	List<FaultVo> queryFaultByPage(Integer first);

	/*
	 * @Author:Childwanwan
	 * @Description:插入数据
	 * @Para:* @param null
	 * @data:2019/3/5  13:49
	 */
	int insertFault(FaultVo faultVo);


	/*
	 * @Author:Childwanwan
	 * @Description:更新故障单，转派功能
	 * @Para:* @param null
	 * @data:2019/3/5  14:21
	 */
	int updateFault(FaultVo faultVo);


	/*
	 * @Author:Childwanwan
	 * @Description:转派功能,返回数据到项目经理,修改故障单的数据状态
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	int updateFaultByCoder(FaultVo faultVo);

	/*
	 * @Author:Childwanwan
	 * @Description:根据id查询对象
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	FaultVo queryFaultById(FaultVo faultVo);

	/*
	 * @Author:Childwanwan
	 * @Description:模糊查询对象
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	List<FaultVo> queryFaultByCondition(Date dateBegin, Date dateEnd,
										int branch, String name);
}
