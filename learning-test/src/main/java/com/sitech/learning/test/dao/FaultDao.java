package com.sitech.learning.test.dao;

import com.sitech.learning.test.vo.FaultVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FaultDao
 * Author:   Childwanwan
 * Date:     2019/3/5 10:58
 * Description: dao层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Mapper
public interface FaultDao {
	/**
	 * 查询所有Fault，返回List<FaultVo>
	 *
	 * @return
	 */
	List<FaultVo> queryFault();
}
