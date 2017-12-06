DROP TABLE JEJU;

CREATE TABLE JEJU(
TEMANO NUMBER NOT NULL,
SORTNAME VARCHAR2(100) NOT NULL,
TITLE VARCHAR2(1000) NOT NULL,
XMAP NUMBER NOT NULL,
YMAP NUMBER NOT NULL,
ADDR VARCHAR2(3000),
PHONE VARCHAR2(50),
HOMEPAGE VARCHAR2(500),
DESCRIPTION LONG
);

SELECT * FROM JEJU;

INSERT INTO JEJU VALUES(001,'해안산책로','추자 올레 18-1코스',33.95192482446921,126.3076414353371,'제주특별자치도 제주시 추자면 묵리 산133',NULL,NULL,'추자도는 하나의 섬이 아니다. 사람이 사는 네 개의 섬과 아무도 살지 않는 서른 여덟 개의 섬이 추자도라는 하나의 이름으로 모여 있다. 바다에 떠 있는 첩첩산중. 겹겹이 보이는 섬의 봉우리들은 섬이 아니라 깊은 산중에 들어와 있는 듯한 기묘한 감각을 느끼게 한다. 산봉우리들 아래 끝없이 펼쳐진 푸른 바다. 추자도는 발길을 이어갈 때마다, 눈길을 달리할 때마다 바다와 산이 어우러진 새로운 풍광을 쏟아낸다. 추자도의 두 섬, 상추자와 하추자의 봉우리들을 넘고 또 넘어 이어가는 제주올레 길은 추자도의 숨은 풍광을 모두 들춰내 보여준다. 고즈넉한 숲길을 바다에서 만나는 특별한 기쁨은 추자도의 한 봉우리를 넘은 후, 다시 새로운 봉우리에 오르는 힘을 기꺼이 내어줄 것이다.')