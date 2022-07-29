package leetcode;

/**
 * @ClassName leetcode.LeetCode458
 * @Description TODO
 * @Author: 索德文
 * @date 2021/11/25 9:01
 * @Version 1.0
 */
public class LeetCode458 {
    /*
    对于两个小猪，喝完毒药15min 死去，在1h最多能检验多个水桶?答案是25桶，如下图所示：

    https://mubu.com/document_image/f57dcc8a-3eb8-4830-97ec-7738301759a5-455593.jpg

    对于一只猪，可以在1h之内最多喝 4次水(60/15)，但是可以检验5个桶，如果前四次没死，说明第5个桶有毒。

    对于2只猪，现在可以让一只猪一下喝5桶水，如图所示的一只猪喝**行**的五个，一只猪喝**列**的五个，这样就可以确定哪个桶有毒。

    对于3只猪，就是三维的 5 X 5 X 5 ，可以检测125个桶；

    。。。。
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if(buckets == 1) {
            return 0;
        }
        double b = buckets;
        double bucket = minutesToTest/minutesToDie + 1;
        minutesToTest = 0;
        // 其实就是求log的过程
        while(b >= bucket){
            minutesToTest++;
            b = b / bucket;
        }
        if(buckets != 1){
            minutesToTest++;
        }
        return minutesToTest;
    }

    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        minutesToDie = minutesToTest / minutesToDie + 1;
        minutesToTest = (int) Math.ceil(Math.log(buckets) / Math.log(minutesToDie));
        return minutesToTest;
    }
}
