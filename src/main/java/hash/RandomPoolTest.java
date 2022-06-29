package hash;

import java.util.HashMap;

public class RandomPoolTest {
    public static class RandomPool{
        public HashMap<String,Integer> keyIndexMap;
        public HashMap<Integer,String> indexKeyMap;
        public int size;

        public RandomPool(){
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void add(String key){
            keyIndexMap.put(key,size);
            indexKeyMap.put(size++,key);
        }

        public String getRandom(){
            if (size == 0){
                return null;
            }
            int num = (int)(Math.random() * size);
            return indexKeyMap.get(num);
        }

        public void delete(String key) throws Exception {
            if (!keyIndexMap.containsKey(key)){
                throw new Exception();
            }
            int lastIndex = --size;
            String lastKey = indexKeyMap.get(lastIndex);
            int index = keyIndexMap.get(key);
            keyIndexMap.put(lastKey,index);
            indexKeyMap.put(index,lastKey);
            keyIndexMap.remove(key);
            indexKeyMap.remove(lastIndex);
        }
    }
    public static void main(String[] args) throws Exception {
        RandomPool pool = new RandomPool();
        pool.add("zuo");
        pool.add("cheng");
        pool.add("yun");


        pool.delete("zuo");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
