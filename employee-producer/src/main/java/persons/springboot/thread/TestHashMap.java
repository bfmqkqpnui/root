package persons.springboot.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {
    public static void main(String[] args) {
       Map<String,Object> map = new ConcurrentHashMap<String ,Object>();
       map.put("hello",1);
    }
}
