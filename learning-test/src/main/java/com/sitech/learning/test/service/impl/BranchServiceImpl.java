package com.sitech.learning.test.service.impl;

import com.sitech.learning.test.dao.BranchDao;
import com.sitech.learning.test.service.IBranchService;
import com.sitech.learning.test.vo.BranchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BranchServiceImpl
 * Author:   Childwanwan
 * Date:     2019/3/5 11:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class BranchServiceImpl implements IBranchService {
	@Autowired
	private BranchDao branchDao;
	@Override
	public List<BranchVo> queryBranch() {
		return branchDao.queryBranch();
	}
}
