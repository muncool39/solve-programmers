SELECT USER_ID, NICKNAME, 
CONCAT_WS(" ", CITY, STREET_ADDRESS1, STREET_ADDRESS2) AS "전체주소",
CONCAT_WS("-", LEFT(TLNO, 3), MID(TLNO, 4, 4), RIGHT(TLNO, 4)) AS "전화번호"
FROM USED_GOODS_USER
WHERE USER_ID IN
(SELECT WRITER_ID 
 FROM USED_GOODS_BOARD
 GROUP BY WRITER_ID
 HAVING COUNT(BOARD_ID) >= 3
)
ORDER BY USER_ID DESC