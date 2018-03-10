package cn.edu.fjnu.dyparse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class DyParseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DyParseServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = request.getParameter("url");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(url == null){
			url = "http://www.es123.com/ssc/";
			/*out.print("Error");
			out.flush();
			out.close();
			return;*/
		}
		
		 WebClient wc = new WebClient();  
		 //wc.getOptions().setUseInsecureSSL(true);  
		 wc.getOptions().setJavaScriptEnabled(true); // 启用JS解释器，默认为true  
		 wc.getOptions().setCssEnabled(true); // 禁用css支持  
		 wc.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常  
		 wc.getOptions().setTimeout(30000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
		 wc.close();
		 HtmlPage page =  wc.getPage(url);
		 out.print(page.asXml());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
