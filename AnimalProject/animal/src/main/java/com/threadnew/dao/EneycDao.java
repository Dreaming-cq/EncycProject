package com.threadnew.dao;

import com.threadnew.pojo.Encyc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface EneycDao {
    @Insert("insert into encyc(title,content,type) values(#{title},#{content},#{type})")
    public  void add(Encyc encyc);
    @Select("select * from encyc where id=1" )
    public Encyc get();
}
