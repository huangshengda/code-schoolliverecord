/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.codyy.slr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.dao.PersonMapper;
import com.codyy.slr.dao.TestMapper;
import com.codyy.slr.entity.Person;
import com.codyy.slr.entity.Test;

/**  
 * @Description: 
 * @author huangshengda  
 * @date 2018年1月17日   
 * @version  1.0
*/
@Service
public class WRService {

	@Autowired
	private TestMapper testMapper;
	@Autowired
	private PersonMapper personMapper;

	public void test() {
		Test t = new Test(1, "kls");

		Person person = personMapper.getPerson();
		testMapper.insert(t);
		System.out.println(person.getId() + "");
	}

}
