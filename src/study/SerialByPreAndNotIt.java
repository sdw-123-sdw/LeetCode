package study;

import java.nio.file.NotDirectoryException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SerialByPreAndNotIt
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/20 22:29
 * @Version 1.0
 */
public class SerialByPreAndNotIt {
    // 序列化
    public static String serialByPre(Node node) {
        if(node == null) {
            return "#_";
        }
        String res = node.value + "_";
        res += serialByPre(node.left);
        res += serialByPre(node.right);
        return res;
    }

    // 反序列化；
    public static Node reconByPreString(String preStr) {
        String[] value = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != value.length; i++) {
            queue.add(value[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if(value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
