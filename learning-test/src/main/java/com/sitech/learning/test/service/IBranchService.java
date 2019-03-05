package com.sitech.learning.test.service;

import com.sitech.learning.test.vo.BranchVo;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IBranchService
 * Author:   Childwanwan
 * Date:     2019/3/5 11:41
 * Description: 分支服务接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface IBranchService {
	/**
	 * 查询所有Branch，返回List<BranchVo>
	 *
	 * @return
	 */
	List<BranchVo> queryBranch();
}
