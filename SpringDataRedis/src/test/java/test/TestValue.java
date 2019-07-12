package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext-redis.xml")
public class TestValue {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() {
        redisTemplate.boundValueOps("name").set("itcast");
    }

    @Test
    public void getValue() {
        String str = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(str);
    }

    @Test
    public void deleteValue() {
        redisTemplate.delete("name");
        ;
    }

    @Test
    public void setValue1() {
        redisTemplate.boundSetOps("nameset").add("曹操");
        redisTemplate.boundSetOps("nameset").add("刘备");
        redisTemplate.boundSetOps("nameset").add("孙权");
    }

    @Test
    public void getValue1() {
        Set members = redisTemplate.boundSetOps("nameset").members();
        System.out.println(members);
    }


    @Test
    public void deleteValue1() {
        redisTemplate.boundSetOps("nameset").remove("孙权");
    }

    @Test
    public void deleteAllValue() {
        redisTemplate.delete("nameset");
    }

    @Test
    public void testSetValue1() {
        redisTemplate.boundListOps("namelist1").rightPush("刘备");
        redisTemplate.boundListOps("namelist1").rightPush("关羽");
        redisTemplate.boundListOps("namelist1").rightPush("张飞");
    }

    @Test
    public void testGetValue1() {
        List list = redisTemplate.boundListOps("namelist1").range(0, 10);
        System.out.println(list);
    }

    @Test
    public void testSetValue2() {
        redisTemplate.boundListOps("namelist2").leftPush("刘备");
        redisTemplate.boundListOps("namelist2").leftPush("关羽");
        redisTemplate.boundListOps("namelist2").leftPush("张飞");
    }

    @Test
    public void testGetValue2() {
        List list = redisTemplate.boundListOps("namelist2").range(0, 10);
        System.out.println(list);
    }

    @Test
    public void testSearchByIndex() {
        String s = (String) redisTemplate.boundListOps("namelist1").index(1);
        System.out.println(s);
    }

    @Test
    public void testRemoveByIndex() {
        redisTemplate.boundListOps("namelist1").remove(2, "张飞");
    }


    @Test
    public void testSetValue() {
        redisTemplate.boundHashOps("namehash").put("a", "唐僧");
        redisTemplate.boundHashOps("namehash").put("b", "悟空");
        redisTemplate.boundHashOps("namehash").put("c", "八戒");
        redisTemplate.boundHashOps("namehash").put("d", "沙僧");
    }

    @Test
    public void testGetKeys(){
        Set s = redisTemplate.boundHashOps("namehash").keys();
        System.out.println(s);
    }
    @Test
    public void testGetValues(){
        List values = redisTemplate.boundHashOps("namehash").values();
        System.out.println(values);
    }



    @Test
    public void testGetValueByKey(){
        Object object = redisTemplate.boundHashOps("namehash").get("b");
        System.out.println(object);
    }

    @Test
    public void testRemoveValueByKey(){
        redisTemplate.boundHashOps("namehash").delete("c");
    }



    @Test
    public void testRemoveValueByKey1(){
        redisTemplate.delete("namehash");
    }
}




