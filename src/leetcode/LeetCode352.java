package leetcode;

import java.util.*;

/**
 * @ClassName leetcode.LeetCode352
 * @Description TODO
 * @Author: 索德文
 * @date 2021/10/9 21:27
 * @Version 1.0
 */
public class LeetCode352 {
    private static TreeSet<Integer> treeSet;
    private static LinkedList<int[][]> list;

    public LeetCode352() {
        treeSet = new TreeSet();
        list = new LinkedList();
    }

    public static void addNum(int val) {
        if(list.isEmpty()) {
            list.add(new int[][]{{val, val}});
            treeSet.add(val);
        } else if(treeSet.add(val)) {
            treeSet.remove(val);
            if ((treeSet.floor(val) != null && treeSet.floor(val) == (val - 1)) || (treeSet.ceiling(val) != null && treeSet.ceiling(val) == (val + 1))) {
                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i)[0][1] == (val - 1)) {
                        treeSet.add(val);
                        list.get(i)[0][1] = val;
                    }
                    if(list.get(i)[0][0] == (val + 1)){
                        treeSet.add(val);
                        list.get(i)[0][0] = val;
                    }
                    if(i != 0 && list.get(i)[0][0] == list.get(i - 1)[0][1]) {
                        list.get(i - 1)[0][1] = list.get(i)[0][1];
                        list.remove(i);
                    }
                }
            } else {
                if(treeSet.ceiling(val) == null) {
                    list.add(new int[][]{{val ,val}});
                } else if(treeSet.floor(val) == null) {
                    list.add(0, new int[][]{{val ,val}});
                } else {
                    Integer floor = treeSet.floor(val);
                    for (int i = 0; i < list.size(); i++) {
                        if(list.get(i)[0][1] == floor) {
                            list.add(i + 1, new int[][]{{val ,val}});
                            break;
                        }
                    }
                }
                treeSet.add(val);
            }
        } else {
            return;
        }
    }

    public static int[][] getIntervals() {
        int a[][] = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            a[i][0] = list.get(i)[0][0];
            a[i][1] = list.get(i)[0][1];
        }
        return a;
    }

    public static void main(String[] args) {
        LeetCode352 leetCode352 = new LeetCode352();
        addNum(49);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(97);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(53);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(5);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(33);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(65);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(62);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(51);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(100);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(38);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(61);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(45);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(74);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(27);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(64);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(17);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(36);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(17);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(96);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(12);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(79);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(32);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(68);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(90);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(77);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(18);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(39);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(12);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(93);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(9);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(87);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(42);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(60);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(71);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(12);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(45);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(55);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(40);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(78);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(81);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(26);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(70);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(61);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(56);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(66);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(33);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(7);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(70);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(1);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(11);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(92);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(51);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(90);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(100);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(85);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(80);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(0);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(78);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(63);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(42);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(31);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(93);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(41);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(90);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(8);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(24);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(72);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(28);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(30);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(18);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(69);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(57);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(11);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(10);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(40);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(65);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(62);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(13);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(38);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(70);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(37);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(90);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(15);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(70);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(42);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(69);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(77);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(70);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(75);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(36);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(56);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(11);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(76);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(73);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(30);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(37);
        System.out.println(Arrays.deepToString(getIntervals()));
        addNum(23);
        System.out.println(Arrays.deepToString(getIntervals()));

    }
}
