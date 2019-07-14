import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("id", 2);
        map.put("name", 2);
        Map map1 = new HashMap();
        map1.put("id", 2);
        map1.put("name", 2);
        List<Map> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        System.out.println(list);
        System.out.println("---------------------");


        List<Map> mapList = new ArrayList<>();
        mapList.add(map);
        mapList.add(map1);
        System.out.println(mapList);
        System.out.println("----------------");
        System.out.println("---------------");
        System.out.println("---------------");
        int w = list.indexOf("e");
        System.out.println(w);
        System.out.println("---------------------------");
        System.out.println("---------------------------");


    }
}
