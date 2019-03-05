package com.sitech.learning.test.service;

import com.sitech.learning.test.vo.UserVo;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IUserService
 * Author:   Childwanwan
 * Date:     2019/3/4 15:34
 * Description: 用户服务接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface IUserService {
	/**
	 * 查询所有User，返回List<User>
	 *
	 * @return
	 */
	List<UserVo> queryUser();


	/**
	 * 所有项目经理User，返回List<User>
	 *
	 * @return
	 */
	List<UserVo> queryUserManager();

	/**
	 * 登入
	 *
	 * @return
	 */
	UserVo queryUserByLogin(UserVo userVo);
}
