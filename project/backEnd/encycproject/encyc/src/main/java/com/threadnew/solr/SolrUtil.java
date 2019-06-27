package com.threadnew.solr;

import com.threadnew.pojo.EncycResult;
import com.threadnew.pojo.EncycSolr;
import com.threadnew.pojo.Page;
import com.threadnew.service.EncycService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
       solr的工具类
 */
@Component
public class SolrUtil {
    @Autowired
    private SolrClient solrClient;
    //
    @Autowired
    private EncycService encycService;
    //添加数据到索引库
    public void addIndexAll() throws IOException, SolrServerException {
      List<SolrInputDocument> docList=new ArrayList<>();
        //得到数据库中的数据
        List<EncycSolr> list=encycService.getAll();
        if(list!=null&&list.size()!=0){
            for (EncycSolr s:list
                 ) {
                SolrInputDocument doc=new SolrInputDocument();
                doc.addField("title",s.getTitle());
                doc.addField("content",s.getContent());
                doc.addField("id",s.getId());
                docList.add(doc);

            }

        }
        if(docList.size()!=0){
            solrClient.add(docList);
            solrClient.commit();

        }



    }
    //solr的查询
    public EncycResult query(Page page) throws IOException, SolrServerException {
        SolrQuery query=new SolrQuery();
        query.setRows(page.getCol());
        query.setStart(page.getStart());
        query.set("q","title:"+page.getTitle());
        query.setHighlight(true);
        query.addHighlightField("content");
        query.setHighlightSimplePre("<span style='color:red'>");
        query.setHighlightSimplePost("</span>");

        //发起搜索请求
        QueryResponse response = solrClient.query(query);
        // 查询结果
        SolrDocumentList docs = response.getResults();
        // 查询结果总数
        int cnt = (int)docs.getNumFound();
        EncycResult result=new EncycResult();
        List<EncycSolr> list=new ArrayList<>();
        for (SolrDocument doc : docs) {
            EncycSolr en=new EncycSolr();
            en.setId(Integer.parseInt(doc.getFieldValue("id").toString()));
            en.setTitle( doc.getFieldValue("title").toString());
            en.setContent(doc.getFieldValue("content").toString());
            list.add(en);
        }
        if(list.size()!=0){
            result.setList(list);
            result.setCount(cnt);
        }
       // solrClient.close();

        return result;
    }
}
