package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.EmpValueObject;
import model.Emp;
import dao.EmpDao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao = new EmpDao();
		String id = request.getParameter("id");
		EmpValueObject vo = dao.searchEmpById(id);
		request.setAttribute("vo", vo);
		
		// refareを確認してみる
		String ref = request.getHeader("Referer");
		System.out.println("ref:" + ref);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/edit.jsp");
		rd.forward(request, response);
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		request.setCharacterEncoding("UTF-8");
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/edit.jsp");
//		rd.forward(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		EmpValueObject vo = new EmpValueObject();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo.setName(request.getParameter("name"));
		vo.setHire_date(request.getParameter("hire_date"));
		vo.setGrade(request.getParameter("grade"));
		vo.setSalary(Integer.valueOf(request.getParameter("salary")));
		if("1".equals(request.getParameter("del_flg"))){
			vo.setDel_flg("1");
		}else{
			vo.setDel_flg("0");
		}
		EmpDao dao = new EmpDao();
		dao.updateEmp(vo);
		RequestDispatcher rd = request.getRequestDispatcher("/SearchServlet");
		rd.forward(request, response);
	}

}
