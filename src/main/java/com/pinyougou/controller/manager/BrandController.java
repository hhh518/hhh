package com.pinyougou.controller.manager;

import com.pinyougou.bean.TbBrand;
import com.pinyougou.bean.entity.PageResult;
import com.pinyougou.bean.entity.Result;
import com.pinyougou.service.manager.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService service;
    @RequestMapping("/all")
    public List<TbBrand> getAllBrands(){
        return service.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page,int size){
       return   service.findPage(page,size);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){

        try {
            service.add(brand);
            return new Result(true,"新增品牌成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"新增品牌失败");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(long id){
        return service.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            service.update(brand);
            return new Result(true,"修改品牌成功");
        }catch (Exception e){
            e.printStackTrace();
            //日志处理
            return new Result(false,"修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            service.delete(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand,int page,int size){
        return service.findPage(brand,page,size);
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return service.selectOptionList();
    }

}
