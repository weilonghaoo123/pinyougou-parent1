import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("id", 2);
        map.put("name", 2);
        Map map1 = new HashMap();
        map1.put("id", 2);
        map1.put("name", 2);


        List<Map> mapList = new ArrayList<>();
        mapList.add(map);
        mapList.add(map1);
        System.out.println(mapList);
        System.out.println("----------------");


        List list = new ArrayList();
        list.add("w");
        list.add("l");
        list.add("m");
        list.add("e");
        list.add("r");
        int w = list.indexOf("e");
        System.out.println(w);
        System.out.println("---------------------------");


    }
}
