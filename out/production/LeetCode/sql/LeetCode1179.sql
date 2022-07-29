# 如果没有聚合函数 只输出第一行 比如
# SELECT ID, (CASE WHEN MONTH='JAN' THEN REVENUE END) AS JAN_REVENUE,
# (CASE WHEN MONTH='FEB' THEN REVENUE END) AS FEB_REVENUE
# FROM DEPARTMENT GROUP BY ID
# 会输出
# +------+-------------+-------------+
# | ID   | JAN_REVENUE | FEB_REVENUE |
# +------+-------------+-------------+
# | 1    | 8000        | NULL        |
# | 2    | 7000        | NULL        |
# | 3    | NULL        | 10000       |
# +------+-------------+-------------+
# 其中 ID=1 的 FEB_REVENUE 结果不对，这是因为 ID=1 时, (CASE WHEN MONTH='FEB' THEN REVENUE END)= [NULL, 7000, NULL], 没有聚合函数会只取第一个，即NULL

SELECT id,
       SUM(CASE WHEN month='Jan' THEN revenue END) AS Jan_Revenue,
       SUM(CASE WHEN month='Feb' THEN revenue END) AS Feb_Revenue,
       SUM(CASE WHEN month='Mar' THEN revenue END) AS Mar_Revenue,
       SUM(CASE WHEN month='Apr' THEN revenue END) AS Apr_Revenue,
       SUM(CASE WHEN month='May' THEN revenue END) AS May_Revenue,
       SUM(CASE WHEN month='Jun' THEN revenue END) AS Jun_Revenue,
       SUM(CASE WHEN month='Jul' THEN revenue END) AS Jul_Revenue,
       SUM(CASE WHEN month='Aug' THEN revenue END) AS Aug_Revenue,
       SUM(CASE WHEN month='Sep' THEN revenue END) AS Sep_Revenue,
       SUM(CASE WHEN month='Oct' THEN revenue END) AS Oct_Revenue,
       SUM(CASE WHEN month='Nov' THEN revenue END) AS Nov_Revenue,
       SUM(CASE WHEN month='Dec' THEN revenue END) AS Dec_Revenue
FROM department
GROUP BY id
ORDER BY id;