package cn.edu.cqust.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @project: HRMS
 * @author: TFC
 * @date: 2019年6月16日 下午8:42:58
 * @desc: 遍历Set, Map, List等容器
 */
@SuppressWarnings("unused")
public class TravelCollection {

    /**
     * @desc 遍历List对象
     * @param list List类型容器
     * @param lineBreak 是否换行(true:换行 / false:不换行)
     * @return void
     */
    public static <E> void travelList(List<E> list, boolean lineBreak) {
        if (overLength(list.size()))
            return;
        StringBuilder res = new StringBuilder();
        if (!lineBreak)
            res.append("[");
        for (E e : list) {
            if (!lineBreak) res.append(e).append(", ");
            else res.append(e).append("\n");
        }
        if (!lineBreak) {
            res.delete(res.length() - 2, res.length());
            res.append("]");
        }
        System.out.println(res);
    }
    /**
     * @desc 重载travelList, 默认换行
     * @param list List类型容器
     * @return void
     */
    public static <E> void travelList(List<E> list) {
        travelList(list,true);
    }

    /**
     * @desc 遍历Map对象
     * @param map Map类型容器
     * @param lineBreak 是否换行(true:换行 / false:不换行)
     * @return void
     */
    public static <K, V> void travelMap(Map<K, V> map, boolean lineBreak) {
        if (overLength(map.size()))
            return;
        //先放入set再遍历
        Set<Map.Entry<K, V>> set = map.entrySet();
        StringBuilder res = new StringBuilder();
        if (!lineBreak)
            res.append("{ ");
        for (Map.Entry<K, V> kvEntry : set) {
            if (lineBreak) res.append("[").append(kvEntry).append("]").append("\n");
            else res.append("[").append(kvEntry).append("], ");
        }
        if (lineBreak) {
            res.delete(res.length() - 1, res.length());
        } else {
            res.delete(res.length() - 2, res.length());
            res.append(" }");
        }
        System.out.println(res);
    }
    /**
     * @desc 重载travelMap, 默认换行
     * @param map Map类型容器
     * @return void
     */
    public static <K, V> void travelMap(Map<K, V> map) {
        travelMap(map,true);
    }

    /**
     * @desc 遍历Set对象
     * @param set Set类型容器
     * @param lineBreak 是否换行(true:换行 / false:不换行)
     * @return void
     */
    public static <E> void travelSet(Set<E> set, boolean lineBreak) {
        if (overLength(set.size()))
            return;
        StringBuilder res = new StringBuilder();
        if (!lineBreak)
            res.append("[");
        for (E e : set) {
            if (!lineBreak) res.append(e).append(", ");
            else res.append(e).append("\n");
        }
        if (!lineBreak) {
            res.delete(res.length() - 2, res.length());
            res.append("]");
        }
        System.out.println(res);
    }

    /**
     * @desc 重载travelSet, 默认换行
     * @param set Set类容器
     * @return void
     */
    public static <E> void travelSet(Set<E> set) {
        travelSet(set,true);
    }


    /**
     * @desc 检查容器容量是否过大
     * @param len 容器的容量
     * @return boolean
     */
    private static boolean overLength(int len) {
        if (len > Integer.MAX_VALUE - 1) {
            System.out.println("容器的容量过大");
            return true;
        }
        return false;
    }

}
