package test;

import cn.itcast.pojo.TbItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
public class SolrTest {
    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void testAdd() {
        TbItem item = new TbItem();
        item.setId(1L);
        item.setBrand("华为");
        item.setCategory("手机");
        item.setGoodsId(1L);
        item.setSeller("华为 2 号专卖店");
        item.setTitle("华为 Mate9");
        item.setPrice(new BigDecimal(2000));
        solrTemplate.saveBean(item);
        solrTemplate.commit();
    }

    @Test
    public void GetFindOne() {
        TbItem item = solrTemplate.getById(1, TbItem.class);
        System.out.println(item.getPrice());
    }

    @Test
    public void delete() {
        solrTemplate.deleteById("1");
        solrTemplate.commit();
    }

    //添加100条数据
    @Test
    public void addList() {
        List<TbItem> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            TbItem item = new TbItem();
            item.setId(i + 1L);
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(i + 1L);

            item.setSeller("华为" + i + "号专卖店");
//            item.setTitle("华为 Mate" + i);
            item.setTitle("华为 Mate" + i);
//            item.setPrice(new BigDecimal(2000 + i));
            item.setPrice(new BigDecimal(2000 + i));
            list.add(item);
        }
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }

    @Test
    public void testAddList() {
        List<TbItem> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            TbItem item = new TbItem();
            item.setId(i + 1L);
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(1L);
            item.setSeller("华为 2 号专卖店");
            item.setTitle("华为 Mate" + i);
            item.setPrice(new BigDecimal(2000 + i));
            list.add(item);
        }
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }

    //编写分页查询测试代码：
    @Test
    public void pageSize() {
        Query query = new SimpleQuery("*:*");
        query.setOffset(20);
        query.setRows(20);
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        System.out.println("总记录数:" + page.getTotalElements());
        List<TbItem> list = page.getContent();
        showList(list);

    }

    //显示记录数据
    public void showList(List<TbItem> list) {
        for (TbItem item : list) {
            System.out.println(item.getTitle());
        }
    }

    //Criteria 用于对条件条件
    @Test
    public void testPageQueryMutil() {
        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_title").contains("2");
        criteria.and("item_title").contains("5");
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        System.out.println("总记录数：" + page.getTotalElements());
        List<TbItem> list = page.getContent();
        showList(list);
    }

    //删除全部数据
    @Test
    public void deleteAll() {
        Query query = new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();

    }
}


