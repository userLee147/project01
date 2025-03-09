package com.kh.mybatis.member.controller;

import java.io.IOException;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberEnrollController
 */
@WebServlet("/insert.me")
public class MemberEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = new Member ( 
				0,
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
		int result = new MemberServiceImpl().insertMember(m);
		
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("errorMsg", "회원가입실패");
			request.getRequestDispatcher("views/common/errorPag.jsp").forward(request, response);
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
