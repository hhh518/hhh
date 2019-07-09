package com.pinyougou.service.manager;

import com.pinyougou.bean.TbBrand;
import com.pinyougou.bean.entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<TbBrand> findAll();

    public PageResult findPage(int pageNuM,int pageSize);

    public void add(TbBrand tbBrand);

    public TbBrand findOne(long id);

    public void update(TbBrand brand);

    public void delete(Long[] ids);

    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);

    public List<Map> selectOptionList();
}
