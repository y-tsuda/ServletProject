package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DbServlet
 */
@WebServlet("/DbServlet")
public class DbAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DbAccessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		String url = "jdbc:mysql://192.168.56.100/mydb";
		String user = "root";
		String password = "password";

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>データベーステスト</title>");
			out.println("</head>");
			out.println("<body>");
			try {
//				Class.forName("com.mysql.jdbc.Driver").newInstance();
//				conn = DriverManager.getConnection(url, user, password);
				InitialContext initialContext = new InitialContext();
	            DataSource dataSource
	                = (DataSource) initialContext.lookup("java:comp/env/jdbc/sampleDb");
	            conn = dataSource.getConnection();
				// データベースに対する処理
				Statement stmt = conn.createStatement();
				String sql = "SELECT * FROM emp";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					out.println("<p>");
					out.println("id:" + id + ", name:" + name);
					out.println("</p>");
				}
				out.println("</body>");
				out.println("</html>");
				rs.close();
				stmt.close();
			} catch (Exception e){
				e.printStackTrace();
			}
			// 例外処理
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// 例外処理
			}
		}

	}

}
