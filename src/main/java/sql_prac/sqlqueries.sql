// 동명 동물 수 찾기   
SELECT NAME,
COUNT(NAME) AS COUNT
FROM ANIMAL_INS
GROUP BY 1
HAVING COUNT > 1
ORDER BY NAME

//아픈 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = "Sick"

//상위 n개 레코드
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 5

//최솟값 찾기
SELECT MIN(DATETIME) AS "시간"
FROM ANIMAL_INS

//젊은 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION <> "Aged"
ORDER BY ANIMAL_ID

//여러 기준으로 정렬하기
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC

//이름에 el이 들어가는 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE "%EL%"
AND ANIMAL_TYPE = "DOG"
ORDER BY NAME

//나이정보 x 회원수 구하기
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE IS NULL

//가장 비싼 상품 구하기
SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT

//null처리
SELECT ANIMAL_TYPE, IF(NAME IS NULL, 'No name' ,NAME) AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

//경기도에 위치한 식품창고 목록 출력하
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IF(FREEZER_YN IS NULL, 'N', FREEZER_YN) AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '%경기%'
ORDER BY WAREHOUSE_ID

//DATETime date로
SELECT ANIMAL_ID, NAME, SUBSTR(DATETIME, 1, 10) AS "날짜"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

// 흉부외과 또는 일반외과 의사 목록 출력
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC

// 가격이 제일 비싼 식품의 정보 출력하기
SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
LIMIT 1

//이름이 없는 동물의 아이디
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL

//조건에 맞는 회원수 구하기
SELECT COUNT(1) AS USERS
FROM USER_INFO
WHERE AGE BETWEEN 20 AND 29 AND JOINED LIKE '%2021%'

//중성화 여부
SELECT ANIMAL_ID, NAME,
CASE WHEN SEX_UPON_INTAKE LIKE '%Neutered%' then 'O'
when SEX_UPON_INTAKE LIKE '%Spayed%' then 'O'
else 'X' end '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

//카테고리별 상품 개수
SELECT SUBSTR(PRODUCT_CODE, 1, 2) AS CATEGORY,
COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY 1
ORDER BY CATEGORY

//고양이와 개는 몇마리
SELECT ANIMAL_TYPE,
COUNT(*) AS count
FROM ANIMAL_INS
GROUP BY 1
ORDER BY ANIMAL_TYPE

//입양시각 구하기
SELECT HOUR(DATETIME) as HOUR,
count(*) as COUNT
from animal_outs
where hour(datetime) between 9 and 19
GROUP BY 1
ORDER BY HOUR(DATETIME)

//진료과별 총 예약 횟수 출력하기
SELECT MCDP_CD AS "진료과코드",
count(*) as "5월예약건수"
from appointment
where extract(YEAR_MONTH from apnt_ymd) = '202205'
group by 1
order by 2 asc, 1 asc

// 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
select car_type, count(1) as CARS
from car_rental_company_car
where options regexp '통풍시트|열선시트|가죽시트'
group by 1
order by 1 asc

//오랜 기간 보호한 동물(1)
SELECT a.name, a.datetime
from animal_ins a left join animal_outs b on a.animal_id = b.animal_id
where b.datetime is null
order by a.datetime
limit 3

//카테고리 별 도서 판매량 집계하기
SELECT CATEGORY, sum(sales) as TOTAL_SALES
from book a inner join book_sales b on a.book_id = b.book_id
where extract(YEAR_MONTH from b.sales_date) = '202201'
group by 1
order by 1 asc

//상품 별 오프라인 매출 찾기
SELECT a.PRODUCT_CODE,
(a.price * sum(b.sales_amount)) as SALES
from product a inner join offline_sale b on a.product_id = b.product_id
group by 1
order by 2 desc, 1 asc

//있었는데요 없었습니다
SELECT a.animal_id, a.name
from animal_ins a inner join animal_outs b on a.animal_id = b.animal_id
where a.datetime > b.datetime
order by a.datetime asc

//오랜 기간 보호한 동물(2)
SELECT a.animal_id, a.name
from animal_ins a inner join animal_outs b on a.animal_id = b.animal_id
order by b.datetime - a.datetime desc
limit 2
