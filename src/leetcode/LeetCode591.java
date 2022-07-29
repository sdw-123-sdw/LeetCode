package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName LeetCode591
 * @Description TODO
 * @Author: 索德文
 * @date 2022/5/2 10:30
 * @Version 1.0
 */
public class LeetCode591 {
    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> tags = new ArrayDeque<>();

        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                if (code.charAt(i + 1) == '/') {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 2, j);
                    if (tags.isEmpty() || !tags.peek().equals(tagname)) {
                        return false;
                    }
                    tags.pop();
                    i = j + 1;
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 1, j);
                    if (tagname.length() < 1 || tagname.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < tagname.length(); ++k) {
                        if (!Character.isUpperCase(tagname.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagname);
                    i = j + 1;
                }
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }
        return tags.isEmpty();
    }

    // 正则表达式
    public boolean isValid2(String code) {
        Matcher matcher = REGEX_TAG_WITH_OTHER.matcher(code);
        if (!matcher.matches()) {
            return false;
        }
        code = code.replaceAll("<!\\[CDATA\\[.*?]]>", "1");
        matcher = REGEX_TAG_WITH_OTHER.matcher(code);
        while (matcher.find()) {
            if (!matches(matcher.group(2))) {
                return false;
            }
            code = code.replace(matcher.group(), "");
        }
        return code.isEmpty();
    }

    private static final Pattern REGEX_TAG_WITH_OTHER = Pattern.compile("<([A-Z]{1,9})>(.*)</\\1>");
    private static final Pattern REGEX_TAG_WITHOUT_OTHER = Pattern.compile("<([A-Z]{1,9})>[^<]*?</\\1>");

    private boolean matches(String group) {
        Matcher matcher = REGEX_TAG_WITHOUT_OTHER.matcher(group);
        while (matcher.find()) {
            group = matcher.replaceAll("");
            matcher = REGEX_TAG_WITHOUT_OTHER.matcher(group);
        }
        return !group.contains("<");
    }
}
