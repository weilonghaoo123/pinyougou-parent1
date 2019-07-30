package com.pinyougou.page.service;

/**
 * 商品详情页接口
 */
public interface ItemPageService {
    /**
     * 生成商品相亲页
     * @param goodsId
     * @return
     */
    public boolean genItemHtml(Long goodsId);

    /**
     * 删除商品详细页
     * @param goodsId
     * @return
     */
    public boolean deleteItemHtml(Long[] goodsIds);
}
