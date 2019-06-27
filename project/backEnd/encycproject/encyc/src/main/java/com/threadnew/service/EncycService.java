package com.threadnew.service;

import com.threadnew.dao.EncycDao;
import com.threadnew.pojo.Encyc;
import com.threadnew.pojo.EncycSolr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncycService {
    @Autowired
    private EncycDao encycDao;
    //添加爬取的数据
    public void add(Encyc encyc) {

        encycDao.add(encyc);
    }

    public Encyc get() {
        return encycDao.get();
    }
    //查询数据中的所有数据
    public List<EncycSolr> getAll(){
        return encycDao.getAll();
    }

}
