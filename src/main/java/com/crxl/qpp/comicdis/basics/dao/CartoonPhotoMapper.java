package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.CartoonPhoto;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonPhotoVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartoonPhotoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonPhoto record);

    int insertSelective(CartoonPhoto record);

    CartoonPhoto selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonPhoto record);

    int updateByPrimaryKey(CartoonPhoto record);

    //查询漫画列表
    Page<CartoonPhoto> selectCartoonPhotoByDistributor(@Param("cartoonid")String cartoonid, @Param("cartoonsetid")String cartoonsetid);

    //生成推广文案
    Page<CartoonPhoto> generateCover(@Param("cartoonid")String cartoonid, @Param("sort")int sort);
}