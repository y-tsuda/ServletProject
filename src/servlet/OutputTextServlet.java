package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.binding.StringFormatter;

import dao.EmpDao;
import model.Emp;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/OutputTextServlet")
public class OutputTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputTextServlet() {
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
		EmpDao dao = new EmpDao();
		Emp emp = new Emp();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		emp.setId(id);
		emp.setName(name);
		List<Emp> list = dao.searchEmp(emp);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String sDate = sdf.format(new Date());
		String fileName = String.format("output_%s.txt", sDate);
		File file = new File(getServletContext().getRealPath("files/" + fileName));
		file.createNewFile();
		// コンテントタイプ設定
		response.setContentType("application/octet-stream;charset=utf-8");
		// ヘッダー設定
		response.setHeader("Content-Disposition", "filename=\"" + fileName + "\"");

		FileInputStream in = new FileInputStream(file);
		PrintWriter os = response.getWriter();
		try {
			
			// データ出力
			for(Emp e:list) {
				String line = e.getId() + "," + e.getName()+ "," + e.getHireDate() + "," + e.getGrade() + "," + e.getSalary() + "\n";
				os.write(line);
			}
			
		} finally {
			// 終了処理
			if (in != null) {

				try {
					in.close();
				} catch (IOException e) {
				}
			}

			if (os != null) {

				os.close();

			}
		}
		
	}

}
