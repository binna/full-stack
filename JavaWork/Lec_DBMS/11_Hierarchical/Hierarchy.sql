-- 계층형 쿼리(Hierarchical Query)

SELECT * FROM t_dept2;	-- 서로의 계층관계 주목!

SELECT LPAD(dname, 10, '*') 부서명 FROM t_dept2;

-- LEVEL
SELECT dname, LEVEL 
FROM t_dept2 
CONNECT BY PRIOR dcode = pdept
START WITH dcode = 0001;

/* 
 * 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR : 각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

-- PRIOR를 다른데 주면??
SELECT dname, LEVEL 
FROM t_dept2 
CONNECT BY dcode = PRIOR pdept
START WITH dcode = 0001;

SELECT dcode, dname, pdept, LEVEL 
FROM t_dept2 
CONNECT BY dcode = PRIOR pdept
--START WITH dcode = 1005 -- s/w지원(레벨1) > 기술부(레벨2) > 사장실(레벨3)
START WITH dcode = 1011; -- 영업4팀 > 영업기획팀 > 영업부 > 사장실


SELECT LPAD(dname, LEVEL * 6, '*') 부서명 
FROM t_dept2
CONNECT BY PRIOR dcode = pdept
START WITH dcode = 0001;


--------------------------------------------------
SELECT * FROM t_emp2;

SELECT LPAD(e.name || ' ' || d.dname || ' ' || NVL(e.post, '사원'), LEVEL * 22, '-') "이름과 직급"
FROM t_emp2 e, (SELECT dname, dcode, pdept FROM t_dept2) d
WHERE e.deptno = d.dcode
CONNECT BY PRIOR e.empno = e.pempno
START WITH e.empno = 20000101;

SELECT dname, dcode, pdept FROM t_dept2;


SELECT LEVEL - 1 HR
FROM dual
CONNECT BY LEVEL <= 24









