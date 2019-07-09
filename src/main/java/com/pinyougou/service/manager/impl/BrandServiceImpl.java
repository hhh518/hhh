package com.pinyougou.service.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.bean.TbBrand;
import com.pinyougou.bean.TbBrandExample;
import com.pinyougou.bean.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.service.manager.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl  implements BrandService {
    @Autowired
    TbBrandMapper brandMapper;
    @Override
    public List<TbBrand> findAll() {
        List<TbBrand> list = new ArrayList<>(brandMapper.selectByExample(null));
        return list;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand findOne(long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand b) {
         brandMapper.updateByPrimaryKey(b);
    }

    @Override
    public void delete(Long[] ids) {

        for (Long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();

        if (brand!=null){
            if (brand.getName()!=null && brand.getName().length() > 0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if (brand.getFirstChar()!=null&& brand.getFirstChar().length() > 0){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }


}
