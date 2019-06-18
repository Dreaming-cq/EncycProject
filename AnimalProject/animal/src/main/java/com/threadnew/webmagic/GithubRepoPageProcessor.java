package com.threadnew.webmagic;

import com.threadnew.pojo.Encyc;
import com.threadnew.service.EncycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class GithubRepoPageProcessor implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(200);
    private static int count = 0;
    @Autowired
    private EncycService encycService;
    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {

        //加入满足条件的链接
        page.addTargetRequests(
                page.getHtml().xpath("//span[@class='sTit']/h3[@class='eTit']/a/@href").all()
        );
        page.addTargetRequests(
                page.getHtml().links().regex("http://www.aichong.cn/baike/list_2_\\d+\\.html").all()
        );
        String title=  page.getHtml().xpath("//div[@class='arcTit']/h1/text()").get();
        String content= page.getHtml().xpath("//p/text() ").all().toString();

        //获取页面需要的内容
        System.out.println("抓取的title：" +
              title
        );
        System.out.println("抓取的内容：" +
              content
        );
        if(title!=null&&content!=null) {
            Encyc encyc = new Encyc();
            encyc.setTitle(title);
            encyc.setContent(content);
            System.out.println(encyc.toString());
            encycService.add(encyc);
        }

    }

//    @Scheduled(fixedDelay = 1000 * 400)
    private void proces() {
        Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.aichong.cn/baike/").thread(5).run();
    }

}
