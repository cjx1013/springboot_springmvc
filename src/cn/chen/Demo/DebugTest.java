package cn.chen.Demo;

import java.util.HashMap;
import java.util.Map;

public class DebugTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("zs", "22");
        map.put("ls", "23");
        map.put("we", "24");

        String ls = map.get("ls");
        System.out.println(ls);

    }
}
