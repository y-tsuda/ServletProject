package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emp;
import dao.EmpDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int pi = 0;
	private static int si = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("pi=" +pi);
		System.out.println("si=" +si);
		EmpDao dao = new EmpDao();
		Emp emp = new Emp();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		emp.setId(id);
		emp.setName(name);
		//emp.setHireDate(request.getParameter("hire_date"));
//		emp.setSalary(request.getParameter("salary");
//		emp.setDel_flg(del_flg);
		List<Emp> list = dao.searchEmp(emp);
		request.setAttribute("empList", list);
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/search.jsp");
		rd.forward(request, response);
		pi++;
		si++;
	}
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		EmpDao dao = new EmpDao();
//		
//		List<Emp> list = dao.searchEmp();
//		request.setAttribute("empList", list);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginOk.jsp");
//		rd.forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//
//	}

}
