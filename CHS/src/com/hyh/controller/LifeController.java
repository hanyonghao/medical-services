package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.service.IndexService;

import javax.servlet.ServletException;
import java.io.IOException;

@RequestMapping("Life")
public class LifeController extends BaseController {

	@Autowired
	private IndexService serviceIndex;

	public void dietary() throws ServletException, IOException {
        display("Life/dietary.jsp");
	}

    public void guidance() throws ServletException, IOException {
        display("Life/guidance.jsp");
    }

    public void movement() throws ServletException, IOException {
        display("Life/movement.jsp");
    }

    public void schedule() throws ServletException, IOException {
        display("Life/schedule.jsp");
    }

    public void reportContent() throws ServletException, IOException {
        display("Monitor/reportContent.jsp");
    }

}
