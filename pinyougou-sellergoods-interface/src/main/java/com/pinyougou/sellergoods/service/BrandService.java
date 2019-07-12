package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<TbBrand> findAll();

    /**
     * 品牌分页
     *
     * @param pageNum  当前页码
     * @param pageSize 每页显示条数
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 新增品牌
     *
     * @param tbBrand
     */
    public void add(TbBrand tbBrand);

    /**
     * 更加id查找
     */
    public TbBrand findOne(Long id);

    /**
     * 修改品牌
     */
    public void update(TbBrand tbBrand);

    public void delete(Long[] ids);

    /**
     * 模糊分页查询
     */
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize);

    /**
     * 返回下拉列表
     * @return
     */
    public List<Map> selectOptionList();


}
