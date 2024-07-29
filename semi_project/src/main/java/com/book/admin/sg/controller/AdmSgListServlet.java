package com.book.admin.sg.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.admin.sg.dao.SgAdmDao;
import com.book.member.sg.vo.Suggestion;

// 관리자 문의사항 목록 조회

@WebServlet("/admin/sg/list")
public class AdmSgListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdmSgListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("sg_title");
        String sgStatus = request.getParameter("sgStatus"); 

        Suggestion option = new Suggestion();
        option.setSg_title(title);

        String nowPage = request.getParameter("nowPage");
        if (nowPage != null) {
            option.setNowPage(Integer.parseInt(nowPage));
        }

        option.setTotalData(new SgAdmDao().selectSgCount(option));

        String statusValue = null;
        if ("답변완료".equals(sgStatus)) {
            statusValue = "1";
        } else if ("미답변".equals(sgStatus)) {
            statusValue = "0";
        }

        List<Map<String, String>> list = new SgAdmDao().selectSgList(option, statusValue);

        request.setAttribute("paging", option);
        request.setAttribute("resultList", list);

        RequestDispatcher view = request.getRequestDispatcher("/views/admin/sg/list.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
