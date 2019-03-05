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
 * FileName: FaultVo
 * Author:   Childwanwan
 * Date:     2019/3/4 18:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FaultVo {
	@Id
	private String id;
	private String name;
	private Date createDate;
	private String influenceSystem;
	private Integer branch;
	private String description;
	private String username;
	private Integer status;
	private String url;
	private String toUsername;
}
