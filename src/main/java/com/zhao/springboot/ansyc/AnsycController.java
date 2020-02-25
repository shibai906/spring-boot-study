package com.zhao.springboot.ansyc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhao.json.JSONResult;
import com.zhao.springboot.entity.meal_card.Consume;
import com.zhao.springboot.entity.meal_card.Info;
import com.zhao.springboot.service.meal_card.ConsumeService;
import com.zhao.springboot.service.meal_card.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ansyc")
public class AnsycController {

    @Autowired
    ScoreService service;

    @RequestMapping(value = { "testAnsyc" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insertInfo(Info info) throws InterruptedException {

        service.sendRedPacket();
        service.sendSoce();
        return JSONResult.success();
    }


}
