package com.hyh.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.service.IndexService;

@RequestMapping("Index")
public class IndexController extends BaseController {

	@Autowired
	private IndexService indexService;

	public void index() throws ServletException, IOException {
        indexService.test();
        display("Index/index.jsp");
	}

    public void newsContent() throws ServletException, IOException {
        display("Index/newsContent.jsp");
    }

}
