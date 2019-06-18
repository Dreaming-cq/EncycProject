package com.threadnew.service;

import com.threadnew.dao.EneycDao;
import com.threadnew.pojo.Encyc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncycService {
    @Autowired
    private EneycDao eneycDao;
    public void add(Encyc encyc){
        eneycDao.add(encyc);
    }
    public Encyc get(){
        return eneycDao.get();
    }
}
