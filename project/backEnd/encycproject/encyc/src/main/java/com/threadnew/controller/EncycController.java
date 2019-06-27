package com.threadnew.controller;

import com.threadnew.pojo.EncycResult;
import com.threadnew.pojo.Page;
import com.threadnew.service.EncycService;
import com.threadnew.solr.SolrUtil;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/*
    宠物百科的搜索
 */
@RestController
public class EncycController {
    @Autowired
    private EncycService encycService;
    @Autowired
    private SolrUtil solrUtil;
    @GetMapping("/query")
    public EncycResult query(Page page) throws IOException, SolrServerException {
        //查询10条数据
        page.setCol(10);
        System.out.println("page"+page.toString());
        EncycResult  result= solrUtil.query(page);
        return result;
    }

}
