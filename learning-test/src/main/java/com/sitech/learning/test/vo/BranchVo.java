package com.sitech.learning.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BranchVo
 * Author:   Childwanwan
 * Date:     2019/3/4 17:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data                                    //生成相应的get和set、toString
@Accessors(chain = true)                 //链式调用
@NoArgsConstructor                       //无参构造
@AllArgsConstructor                      //所以参数构造
public class BranchVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String branchName;
	private Date createTime;
}
