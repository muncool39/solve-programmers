SELECT (CASE
        WHEN MONTH(DIFFERENTIATION_DATE) < 4 THEN "1Q"
        WHEN MONTH(DIFFERENTIATION_DATE) < 7 THEN "2Q"
        WHEN MONTH(DIFFERENTIATION_DATE) < 10 THEN "3Q"
        ELSE "4Q"
        END) AS QUARTER,
        COUNT(ID) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER