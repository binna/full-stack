<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	// SELECT 결과, executeQuery()
	int cnt = 0;			// DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
%>

<%!
	// 쿼리문 준비
	final String SQL_WRITE_SELECT 
		= "SELECT * FROM test_write ORDER BY wr_uid DESC";  
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style>
table {width: 100%;}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

<%
	try {
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트랜젝션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT);
		
		rs = pstmt.executeQuery();
		out.println("쿼리 성공<br>");
%>
		<hr>
		<h2>리스트</h2>
		<table>
			<tr>
				<th>UID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
<%
			while (rs.next()) {
				out.println("<tr>");
				int uid = rs.getInt("wr_uid");
				String subject = rs.getString("wr_subject");
				String name = rs.getString("wr_name");
				int viewcnt = rs.getInt("wr_viewcnt");
				Date d = rs.getDate("wr_regdate");		// java.sql
				Time t = rs.getTime("wr_regdate");		// java.sql
				
				String regdate = "";
				if(d != null) {
					regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
							+ new SimpleDateFormat("hh:mm:ss").format(t);
				}

				out.println("<td>" + uid + "</td>");
				out.println("<td><a href='view.jsp?uid=" + uid + "'>" + subject + "</a></td>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + viewcnt + "</td>");
				out.println("<td>" + regdate + "</td>");

				out.println("</tr>");
			} // end while
%>
		
		</table>
		<br>
		<button onclick="location.href='write.jsp'">신규등록</button>
<%
	} catch(Exception e) {
		e.printStackTrace();
		// * 여기서 예외 처리, 콘솔창이나 에러 페이지를 통해 에러 확인이 가능함
		
	} finally {
		// 리소스 해제
		try {
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>

<%-- 위 트랜젝션이 마무리되면 페이지 보여주기 --%>

</body>
</html>