package com.sitech.learning.test.dao;

import com.sitech.learning.test.vo.BranchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BranchDao
 * Author:   Childwanwan
 * Date:     2019/3/5 11:35
 * Description: 分支数据管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Mapper
public interface BranchDao {
	/**
	 * 查询所有Branch，返回List<BranchVo>
	 *
	 * @return
	 */
	List<BranchVo> queryBranch();
}
