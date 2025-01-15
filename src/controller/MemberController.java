package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;
import util.DatabaseUtil;

@WebServlet("/members") // 서블릿 URL 매핑
public class MemberController extends HttpServlet { // HttpServlet 클래스 상속 받기 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = DatabaseUtil.getConnection()) {
            MemberDAO dao = new MemberDAO(conn);
            List<Member> members = dao.getAllMembers(); // 데이터 가져오기
            req.setAttribute("members", members); // 데이터를 요청 속성에 저장

            // JSP로 포워딩
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/memberList.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Error retrieving member list.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트에서 전달된 데이터를 가져옴
        req.setCharacterEncoding("UTF-8"); // 한글 처리
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age")); // parseInt 형변환인가 ? 뭔지 알아보기
        String job = req.getParameter("job");
        String hobby = req.getParameter("hobby");

        try (Connection conn = DatabaseUtil.getConnection()) {
            MemberDAO dao = new MemberDAO(conn);

            // Member 객체 생성 후 데이터 설정
            Member member = new Member();
            member.setName(name);
            member.setSex(sex);
            member.setAge(age);
            member.setJob(job);
            member.setHobby(hobby);

            // 데이터베이스에 등록
            int result = dao.register(member);

            if (result > 0) {
                // 등록 성공 시 리스트 페이지로 리다이렉트
                resp.sendRedirect(req.getContextPath() + "/members");
            } else {
                // 등록 실패 시 에러 페이지 또는 메시지 처리
                req.setAttribute("errorMessage", "회원 등록에 실패했습니다.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/error.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException("Error registering member.", e);
        }
    }
}
