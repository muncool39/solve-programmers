SELECT ID, FISH_NAME, LENGTH
FROM (
    SELECT ID, F.FISH_TYPE, FISH_NAME, LENGTH
    FROM FISH_INFO F
    JOIN FISH_NAME_INFO FN ON F.FISH_TYPE = FN.FISH_TYPE
) AS T
WHERE LENGTH = (
    SELECT MAX(F.LENGTH)
    FROM FISH_INFO F
    WHERE F.FISH_TYPE = T.FISH_TYPE
)
ORDER BY ID