package study;

/**
 * @ClassName PaperFolding
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/21 15:33
 * @Version 1.0
 */
public class PaperFolding {
    /**
     *
     * @param i 节点的层数
     * @param n 一共有几层
     * @param down down == true 凹 down == false 凸
     */
    public static void printProcess(int i, int n, boolean down) {
        if(i > n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, n, false);
    }
}
