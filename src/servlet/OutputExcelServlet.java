package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import dao.EmpDao;
import model.Emp;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/OutputExcelServlet")
public class OutputExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		// データ取得
		EmpDao dao = new EmpDao();
		Emp emp = new Emp();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		emp.setId(id);
		emp.setName(name);
		List<Emp> list = dao.searchEmp(emp);
		// 新規EXCELファイルを作成
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell;

		// ヘッダ部
		List<String> header = Arrays.asList("ID", "氏名", "入社日", "役職", "給与");
		for (int i = 0; i < header.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(header.get(i));
		}
		// データ出力
		for (int i = 0; i < list.size(); i++) {
			Emp e = list.get(i);
			row = sheet.createRow(i + 1);
			for (int j = 0; j < 5; j++) {
				cell = row.createCell(j);
				switch (j) {
				case 0:
					cell.setCellValue(e.getId());
					break;
				case 1:
					cell.setCellValue(e.getName());
					break;
				case 2:
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					cell.setCellValue(sdf.format(e.getHireDate()));
					break;
				case 3:
					cell.setCellValue(e.getGrade());
					break;
				case 4:
					cell.setCellValue(e.getSalary());
					break;

				}
			}
		}
		try {
			workbook.close();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		// EXCELのコンテントタイプを設定
		response.setContentType("application/msexcel");
		// ファイル名を設定
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String sDate = sdf.format(new Date());
		String fileName = String.format("output_%s.xls", sDate);
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		try {
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OutputExcelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

}
