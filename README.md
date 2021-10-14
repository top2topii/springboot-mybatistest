# springboot-mybatistest

## MySql message Table DDL
```sql
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `createdDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
```

## MySQL 데이터 타입과 Java 데이터 타입 비교/매칭
- https://honsal.blogspot.com/2017/04/mysql-java.html
- MySQL: datetime <-> Java: java.sql.Timestamp

## 시간 관련 주의 사항
- MySQL TZ 설정을 Asia/Seoul로 설정했기 때문에 UTC와 +9의 시간차가 있다.
- Table의 값에서는 로컬타임값으로 보이고 Query 결과는 UTC로 온다. 하여 로컬타임으로 변경해야 원하는 값을 얻을 수 있다.