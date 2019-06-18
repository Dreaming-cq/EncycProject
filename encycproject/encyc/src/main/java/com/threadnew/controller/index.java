package com.threadnew.controller;

import com.threadnew.pojo.Encyc;
import com.threadnew.pojo.EncycResult;
import com.threadnew.pojo.Page;
import com.threadnew.service.EncycService;
import com.threadnew.solr.SolrUtil;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class index {
    @Autowired
    private EncycService service;
    @Autowired
    private SolrUtil solrUtil;

    @GetMapping("/home")
    public String home() throws IOException, SolrServerException {
        Page p=new Page();
        p.setTitle("犬");
        p.setStart(0);
        p.setCol(5);
       EncycResult  result= solrUtil.query(p);
        return result.toString();
    }
}
