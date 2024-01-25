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

//보호소에서 중성화한 동물
select c.animal_id, animal_type, name
from
(
select a.*
from animal_outs a join animal_ins b
where a.animal_id = b.animal_id
and b.sex_upon_intake like '%intact%'
) c
where c.sex_upon_outcome regexp 'Neutered|Spayed'


//조건에 맞는 도서와 저자 리스트 출력하기
SELECT a.book_id, b.author_name, date_format(a.published_date, '%Y-%m-%d') as published_date
from book a join author b
where a.author_id = b.author_id
and a.category = '경제'
order by 3 asc

//조건별로 분류하여 주문상태 출력하기
SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d') as out_date,
       case when date(out_date) <= '2022-05-01' then '출고완료'
        when date(out_date) > '2022-05-01' then '출고대기'
        else '출고미정' end '출고여부'
from food_order
order by 1 asc

//성분으로 구분한 아이스크림 총 주문량
SELECT b.ingredient_type, sum(total_order) as TOTAL_ORDER
from first_half a join icecream_info b where a.flavor = b.flavor
group by 1

//루시와 엘라 찾기
SELECT animal_id, name, sex_upon_intake
from animal_ins
where name in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
order by 1

//조건에 맞는 도서 찾기
SELECT book_id, date_format(published_date, '%Y-%m-%d') as publisehd_date
from book
where year(published_date) = 2021
  and category = '인문'

//반올림하기
SELECT round(avg(daily_fee)) as average_fee
from car_rental_company_car
where car_type = 'suv'

//조건에 맞는 사용자와 총 거래금액 조회하기
select *
from
    (
        SELECT b.user_id,
               b.nickname,
               sum(a.price) as total_sales
        from used_goods_board a inner join used_goods_user b on a.writer_id = b.user_id
        where a.status = 'done'
        group by 1
    ) a
where total_sales >= 700000
order by total_sales asc

//3월에 태어난 여성 회원 목록 출력하기
SELECT member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') as date_of_birth
from member_profile
where tlno is not null
          and gender = 'w'
          and month(date_of_birth) = '03'
order by 1 asc

//대여 기록이 존재하는 자동차 리스트 구하기
SELECT a.car_id
from car_rental_company_car a inner join car_rental_company_rental_history b on
    a.car_id = b.car_id
where a.car_type = '세단'
          and month(b.start_date) = '10'
group by 1
order by 1 desc

//가격대 별 상품 개수 구하기
SELECT floor(price / 10000) * 10000 as price_group,
       count(1) as products
from product
group by 1
order by price asc

//즐겨찾기가 가장 많은 식당 정보 출력 Window
select food_type, rest_id, rest_name, favorites
from
    (
        SELECT food_type, rest_id, rest_name, favorites, rank() over(partition by food_type order by favorites desc) ranking
        from rest_info
    )a
where ranking = 1
group by food_type
order by 1 desc

//식품분류별 가장 비싼 window
select category, price as max_price, product_name
from
    (
        SELECT category,
               price,
               product_name,
               rank() over(partition by category order by price desc) as ranking
        from food_product
        where category in ('과자', '국', '김치', '식용유')
    ) a
where ranking = 1
group by category
order by 2 desc

//5월 식품들의 총매출 조회하기
select a.product_id, a.product_name, sum(a.price * b.amount) as total_sales
from food_product a inner join food_order b on a.product_id = b.product_id
where extract(year_month from b.produce_date) = '202205'
group by 1
order by 3 desc, 1 asc

//없어진 기록 찾기
SELECT ao.animal_id, ao.name
from animal_outs ao left join animal_ins ai on ao.animal_id = ai.animal_id
where ai.animal_id is null
order by 1