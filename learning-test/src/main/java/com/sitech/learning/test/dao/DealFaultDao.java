package com.sitech.learning.test.dao;

import com.sitech.learning.test.vo.DealFaultVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DealFaultDao
 * Author:   Childwanwan
 * Date:     2019/3/5 11:17
 * Description: 故障单处理数据接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Mapper
public interface DealFaultDao {
	/**
	 * 查询所有DealFault，返回List<DealFaultVo>
	 *
	 * @return
	 */
	List<DealFaultVo> queryDealFault();
}
