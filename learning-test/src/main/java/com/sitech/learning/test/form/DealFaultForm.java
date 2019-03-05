package com.sitech.learning.test.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: DealFaultForm
 * Author:   Childwanwan
 * Date:     2019/3/5 16:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DealFaultForm {
	private String id;
	private String faultId;
	private Integer status;
	private String toUsername;
	private String url;
	private Long operateTime;
}
