package study.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName IPO
 * @Description 利益最大化
 * @Author: 索德文
 * @date 2021/11/25 21:49
 * @Version 1.0
 */
class Node {
    public int p;
    public int c;
    public  Node(int p, int c) {
        this.p = p;
        this.c = c;
    }
}
public class IPO {
    // 最小成本排序
    public class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    // 最大利润排序
    public class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    /**
     *
     * @param k 最多做几个项目
     * @param w 初始资金
     * @param profits 每个项目的利润
     * @param capital 每个项目的成本
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        // 将所有项目先锁进小根堆中
        for (int i = 0; i < profits.length; i++) {
            minCostQ.add(new Node(profits[i], capital[i]));
        }
        for (int i = 0; i < k; i++) { // 进行k轮
            // 能力所及的项目，全解锁
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}
