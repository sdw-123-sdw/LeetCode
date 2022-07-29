package study.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Meeting
 * @Description 排会议题
 * @Author: 索德文
 * @date 2021/11/25 13:06
 * @Version 1.0
 */
public class Meeting {
    public class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public class ProgramComparator implements Comparator<Program> {

        // 返回负数的时候，第一个排在前面
        // 返回整数的时候,第二个排在前面
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public int bastArrange(Program[] programs, int timePoint) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timePoint <= programs[i].start) {
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}
