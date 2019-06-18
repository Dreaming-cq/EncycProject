package com.threadnew.webmagic;

import com.threadnew.pojo.Encyc;
import com.threadnew.service.EncycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/*
  自定义webmagic的pipeline：EncycPipeLine ，且其作用是保存到数据库中。
 */
@Component
public class EncycPipeline implements Pipeline {
    @Autowired
    private EncycService encycService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Encyc encyc = (Encyc) resultItems.get("encyc");
        //存入数据库中
        if (encyc != null) {
            //encycService.add(encyc);
            System.out.println(encyc.toString());
        }

    }
}
