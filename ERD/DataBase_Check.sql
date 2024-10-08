# 🔎 데이터베이스 관련
drop database ra_db;
create database ra_db;
use ra_db;

# 🔎전체 테이블 보기
show tables;

select * from crew_tour_attend_seq;

# 🔎라이더 리스트 보기
select * from user;
drop table user;
delete from user;

UPDATE user set crew_id = null
WHERE user_id=1;

# 🔎권한 리스트 보기
select * from authority;
drop table authority;
delete from authority;
DESCRIBE authority;

select * from authority;

# 🔎크루 리스트 보기
drop table crew;
select * from crew;
delete from crew;
ALTER TABLE crew AUTO_INCREMENT = 1;

select * from crew_manager;
delete from crew_manager;

drop table crew_attendance;
drop table crew_schedule;
drop table crew_join_board;

drop table crew_join;
select * from crew_join;

select * from crew_manager;
drop table crew_manager;

select * from address;

# 🔎 크루 게시글 영역
show tables ;
select * from crew_board;
DESCRIBE crew_board;
delete from crew_board;
ALTER TABLE crew_board AUTO_INCREMENT = 1;

# 🔎 크루 게시글 댓글 영역
select * from crew_board_comment;
delete from crew_board_comment;
ALTER TABLE crew_board_comment AUTO_INCREMENT = 1;

# 🔎 크루 모임 참여 영역
select * from crew_tour_attend;

# 🔎 라이더 게시판 조회 영역
drop table rider_board;
drop table rider_board_comment;
select * from rider_board;
select * from rider_board_comment;
