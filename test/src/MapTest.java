import org.junit.Test;

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

    @Test
    public void mao() {
        int[] arr = {5, 1, 3, 7, 9};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int test = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = test;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void IWork() {
        IdWorker idWorker = new IdWorker();
        long nextId = idWorker.nextId();
        System.out.println(nextId);

    }

    @Test
    public void string1() {
        String a = "1";
        String b = "1";
        System.out.println(a==b);
    }

    @Test
    public void string2() {
        String a = "1,2,3,6,5";
        String[] as = a.split(",");
        for (String s : as) {
            System.out.println(s);
        }


    }
}
