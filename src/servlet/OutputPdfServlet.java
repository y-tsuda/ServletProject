package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import model.Emp;
import model.StrEmp;
import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/OutputPdfServlet")
public class OutputPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputPdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO 自動生成されたメソッド・スタブ
    	System.out.println("test");
    }
//    /**
//     * 帳票レイアウト ファイルのパス。
//     */
//    private static final String JRXML_FILE_PATH = "/WEB-INF/resources/reports/SushiMenuReport.jrxml";
  
    /**
     * コンパイル済み帳票レイアウト ファイルのパス。
     */
    private static final String JASPER_FILE_PATH = "/WEB-INF/resources/reports/emp.jasper";
    
    /**
     * 帳票に表示する CSV ファイルのパス。
     */
    private static final String CSV_FILE_PATH = "/WEB-INF/resources/data/SushiMenuData.csv";
    
    /**
     * 静的にコンパイルされた帳票レイアウトを作成します。
     * @return 静的にコンパイルされた帳票レイアウト。
     * @throws JRException
     */
    private JasperReport createPreCompiledReport() throws JRException
    {
        ServletContext servletContext = this.getServletConfig().getServletContext();
        
        File jasperFile = new File(servletContext.getRealPath(OutputPdfServlet.JASPER_FILE_PATH));
 
        // コンパイル済み帳票レイアウトをロードします。
        JasperReport jasperReport = (JasperReport)JRLoader.loadObject(jasperFile);
        
        return jasperReport;
    }
    
    /**
     * 帳票レイアウトに設定するためのパラメーターを作成します。
     * @return 帳票レイアウトに設定するためのパラメーター。
     */
    private Map<String, Object> createParameters()
    {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        
        parameters.put("REPORT_CATCHPHRASE", "美味しいよ！");
        
        return parameters;
    }
    
    /**
     * 帳票レイアウトにバインドするためのデータ ソースを作成します。
     * データ ソース内にデータの読み込み状況を保持しているっぽいので、複数の帳票作成で使いまわすことはできない様子。
     * @return 帳票レイアウトにバインドするためのデータ ソース。
     * @throws JRException
     */
    private JRDataSource createDataSource() throws JRException
    {
        ServletContext servletContext = this.getServletConfig().getServletContext();
        
        File csvFile = new File(servletContext.getRealPath(OutputPdfServlet.CSV_FILE_PATH));
        
        JRCsvDataSource dataSource = new JRCsvDataSource(csvFile.getPath());
        
        // 1 行目をヘッダー (フィールド名) として扱います。
        dataSource.setUseFirstRowAsHeader(true);
        
        return dataSource;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
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

		List<StrEmp> eList = new ArrayList<>();
		for (Emp e:list){
			StrEmp se = new StrEmp();
			se.setId(e.getId());
			se.setName(e.getName());
			SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd");
			se.setHireDate(sd.format(e.getHireDate()));
			se.setGrade(e.getGrade());
			se.setSalary(String.valueOf(e.getSalary()));
			eList.add(se);
		}
		
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(eList);

		 try
	        {
	            // 帳票レイアウト ファイル (.jrxml) を実行時に動的にコンパイルし、帳票を作成します。
	            JasperPrint jasperPrint = JasperFillManager.fillReport(createPreCompiledReport(), this.createParameters(), ds);
	            
	            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
	    		// ファイル名を設定
	    		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
	    		String sDate = sdf.format(new Date());
	    		String fileName = String.format("output_%s.pdf", sDate);
	    		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

	            response.setContentType("application/pdf");
	            response.setContentLength(bytes.length);
	 
	            ServletOutputStream out = response.getOutputStream();
	            out.write(bytes);
	            
	            out.flush();
	            out.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
