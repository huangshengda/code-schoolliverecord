package com.codyy.slr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.dao.TestDao1;

@Service
public class TestService {

	@Autowired
	private TestDao1 testDao1;
	
	public List<String> getNames(){
		return testDao1.getNames();
	}
}
