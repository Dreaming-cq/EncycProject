package com.threadnew.dao;

import com.threadnew.pojo.Encyc;
import com.threadnew.pojo.EncycSolr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncycDao {
    //插入爬取的数据
    @Insert("insert into encyc(title,content,type) values(#{title},#{content},#{type})")
    public  void add(Encyc encyc);
    @Select("select * from encyc where id=1" )
    public Encyc get();
    //查询数据库中的所有数据
    @Select("select id,title,content from encyc")
    public List<EncycSolr> getAll();
}
