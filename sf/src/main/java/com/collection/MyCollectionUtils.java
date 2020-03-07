package com.collection;

import java.io.Serializable;
import java.util.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/19 22:50
 * @Description:
 */
public class MyCollectionUtils {


    static class UnmodifiableMap<K,V> implements Map<K,V>{

        private final Map<? extends K, ? extends V> m;
        UnmodifiableMap(Map<? extends K, ? extends V> m) {
            if (m==null)
                throw new NullPointerException();
            this.m = m;
        }
        @Override
        public int size() {
            return m.size();
        }

        @Override
        public boolean isEmpty() {
            return m.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return m.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return m.containsValue(value);
        }

        @Override
        public V get(Object key) {
            return m.get(key);
        }

        @Override
        public V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
        //transient?
        //private transient Set<K> keySet;
        private Set<K> keySet;
        @Override
        public Set<K> keySet() {
            //TODO
            if (keySet==null){
                //keySet = unmodifiableSet(m.keySet());
            }
            return keySet;
        }
        private transient Collection<V> values;
        @Override
        public Collection<V> values() {
            //TODO
            return values;
        }
        private transient Set<Map.Entry<K,V>> entrySet;
        @Override
        public Set<Entry<K, V>> entrySet() {
            //TODO
            return entrySet;
        }
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1", "2");
        Map newMap = new MyCollectionUtils.UnmodifiableMap(map);

        System.out.println(newMap.put("2", "2"));
        System.out.println(newMap.get("1"));
    }
}
