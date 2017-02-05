package servlet.sub;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/OutputFileServlet")
public class OutputFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileInputStream in;
	private ServletOutputStream os;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OutputFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/outputFile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileName = "test.txt";
		try {
			// コンテントタイプ設定
			response.setContentType("application/octet-stream");
			// ヘッダー設定
			response.setHeader("Content-Disposition", "filename=\"" + fileName + "\"");
			// ダウンロードファイルの読み込み倍とストリーム作成
			in = new FileInputStream(getServletContext().getRealPath("files/" + fileName));
			// レスポンス出力バイトストリームを取得
			os = response.getOutputStream();
			// データ出力
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = in.read(buff, 0, buff.length)) != -1) {
				os.write(buff, 0, len);
			}

			String str = "うんこ";
			os.write(str.getBytes("Shift_jis"));
		} finally {
			// 終了処理
			if (in != null) {

				try {
					in.close();
				} catch (IOException e) {
				}
			}

			if (os != null) {

				try {
					os.close();
				} catch (IOException e) {
				}

			}
		}
	}
}
