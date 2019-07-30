package com.pinyougou.search.service;

import java.util.List;
import java.util.Map;

public interface ItemSearchService {
    /**
     * 搜索
     *
     * @param keywords
     * @return
     */
    public Map<String, Object> search(Map searchMap);

    /**
     * 导入数据
     */
    public void importList(List list);

    /**
     * 删除SKU数据
     * @param ids
     */
    public void deleteByGoodsId(List goodsIdList);

}

