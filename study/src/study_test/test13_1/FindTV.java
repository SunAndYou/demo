package study_test.test13_1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindTV {
    public static void main(String[] args) {
        List<TV> list = new LinkedList<>();
        list.add(new TV("华为智慧屏电视", 4600));
        list.add(new TV("小米超薄电视", 2888));
        list.add(new TV("OnePlus TV", 3999));
        list.add(new TV("长城电视机", 1800));
        list.add(new TV("钛合金镶钻液晶电视", 888888));
        list.add(new TV("陈旧的电视", 800));
        list.add(new TV("三星智能电视", 3599));
        Iterator<TV> iter = list.iterator();
        System.out.println("排序前,链表中的数据：");
        while (iter.hasNext()) {
            TV tv1 = iter.next();
            System.out.println(tv1.name + "，价格:" + tv1.price + "元");
        }
        Collections.sort(list);
        System.out.println("排序后,链表中的数据：");
        iter = list.iterator();
        while (iter.hasNext()) {
            TV tv2 = iter.next();
            System.out.println(tv2.name + "，价格:" + tv2.price + "元");
        }
        TV tv3 = new TV("杂牌电视", 800);
        int index = Collections.binarySearch(list, tv3, null);
        if (index >= 0) {
            System.out.println(tv3.name + "和链表中" + list.get(index).name + "价格相同,都是：" + list.get(index).price + "元");
        }
    }
}
