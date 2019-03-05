package com.sitech.learning.test.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FaultForm
 * Author:   Childwanwan
 * Date:     2019/3/5 13:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FaultForm {
	private String id;
	private String name;
	private Long createDate;
	private String influenceSystem;
	private Integer branch;
	private String description;
	private String username;
	private Integer status;
	private String url;
	private String toUsername;
}
