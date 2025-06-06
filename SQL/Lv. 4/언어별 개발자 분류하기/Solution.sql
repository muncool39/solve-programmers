WITH A_D AS (
    SELECT ID
    FROM DEVELOPERS D
    WHERE EXISTS (
        SELECT 1 FROM SKILLCODES S
        WHERE S.CATEGORY = 'Front End' AND D.SKILL_CODE & S.CODE
    ) AND EXISTS (
        SELECT 1 FROM SKILLCODES S
        WHERE S.NAME = 'Python' AND D.SKILL_CODE & S.CODE
    )
), B_D AS (
    SELECT ID
    FROM DEVELOPERS D
    WHERE EXISTS (
        SELECT 1 FROM SKILLCODES S
        WHERE S.NAME = 'C#' AND D.SKILL_CODE & S.CODE
    )
), C_D AS (
    SELECT ID
    FROM DEVELOPERS D
    WHERE EXISTS (
        SELECT 1 FROM SKILLCODES S
        WHERE S.CATEGORY = 'Front End' AND D.SKILL_CODE & S.CODE
    )
)

SELECT CASE WHEN ID IN (SELECT ID FROM A_D) THEN 'A'
            WHEN ID IN (SELECT ID FROM B_D) THEN 'B'
            WHEN ID IN (SELECT ID FROM C_D) THEN 'C'
        END AS GRADE, ID, EMAIL
FROM DEVELOPERS
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID