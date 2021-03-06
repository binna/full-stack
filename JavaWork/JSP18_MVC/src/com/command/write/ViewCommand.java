package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();	// DAO 객체 생성
		WriteDTO[] arr = null;
		
		// uid 값 받아 오기
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			// 트랜잭션 수행
			arr = dao.selectByUid(uid);
			
			// "view"란 name으로 request에 arr 값 전달
			// 즉, request에 담아서 컨트롤러에 전달되는 셈!
			request.setAttribute("view", arr);
			
		} catch(SQLException e) {
			// 만약 ConnectionPool을 사용한다면 
			// 여기서 NamingException도 catch 해야 한다.
			e.printStackTrace();
		}
		
	}

}
