package com.kh.mybatis.member.controller;

import java.io.IOException;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("loginUser");
		
		Member m1 = new Member (
				m.getUserNo(),
				request.getParameter("userId"),
				request.getParameter("userPwd"),
				request.getParameter("userName"),
				request.getParameter("email"),
				request.getParameter("birthday"),
				request.getParameter("gender"),
				request.getParameter("phone"),
				request.getParameter("address"),
				null,null,null
				);
		
		int result = new MemberServiceImpl().updateMember(m1);
		
		
		if(result > 0) {
			/*
			Member updateMember = new MemberServiceImpl().selectOneMember(m.getUserNo());
			request.setAttribute("loginUser", updateMember);
			request.getRequestDispatcher("views/member/mypage.jsp").forward(request, response);;
			*/
			
			session.setAttribute("alertMsg", "수정에 성공하였습니다.");
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("errorMsg", "수정에 실패하셨습니다.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
