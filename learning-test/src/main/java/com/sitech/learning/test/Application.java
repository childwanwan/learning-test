package com.sitech.learning.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Application
 * Author:   Childwanwan
 * Date:     2019/3/4 14:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@SpringBootApplication
//@MapperScan("com.sitech.learning.test.dao.UserDao")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
