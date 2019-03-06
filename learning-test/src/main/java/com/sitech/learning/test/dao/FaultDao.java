package com.sitech.learning.test.dao;

import com.sitech.learning.test.vo.DealFaultVo;
import com.sitech.learning.test.vo.FaultVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

	/**
	 * 分页查询所有Fault，返回List<FaultVo>
	 *
	 * @return
	 */
	List<FaultVo> queryFaultByPage(Integer first);

	/*
	 * @Author:Childwanwan
	 * @Description:插入语句
	 * @Para:* @param null
	 * @data:2019/3/5  13:48
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
	List<FaultVo> queryFaultByCondition(@Param("dateBegin") Date dateBegin,@Param("dateEnd") Date dateEnd,
										@Param("branch") int branch,@Param("name") String name);


	/*
	 * @Author:Childwanwan
	 * @Description:根据id更新对象
	 * @Para:* @param null
	 * @data:2019/3/5  14:42
	 */
	int updateFaultById(FaultVo faultVo);


}
