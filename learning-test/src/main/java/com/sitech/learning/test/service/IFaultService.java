package com.sitech.learning.test.service;

import com.sitech.learning.test.vo.FaultVo;

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
}
