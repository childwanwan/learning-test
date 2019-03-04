package com.sitech.learning.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: User
 * Author:   Childwanwan
 * Date:     2019/3/4 15:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data                                    //生成相应的get和set、toString
@Accessors(chain = true)                 //链式调用
@NoArgsConstructor                       //无参构造
@AllArgsConstructor                      //所以参数构造
public class UserVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String userPassword;
	private String phone;
	private String email;
	private String sex;
	private Date registerTime;
	private Integer roleId;

}
