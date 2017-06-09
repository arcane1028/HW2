package test;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * Servlet implementation class sendJson
 */
@WebServlet("/sendJson")
public class sendJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		JsonParser parser = new JsonParser();
		String path = "E:\\workspace\\HW2\\";
		Object obj = parser.parse(new FileReader(path+"myJson.json"));
	
		JsonObject jsonObject = (JsonObject) obj;
		JsonArray data = jsonObject.getAsJsonArray("data");
		JsonArray label=new JsonArray();
		JsonArray close=new JsonArray();
		//int close[] = new int[data.size()];
		//System.out.println(data);
		for(int i=0;i<data.size();i++){
			JsonObject tmp = (JsonObject)data.get(i);//인덱스 번호로 접근해서 가져온다.

			label.add(tmp.get("date"));
			close.add(Double.parseDouble(tmp.get("close").getAsString()));
			//close[i]=Integer.parseInt(tmp.get("close").getAsString());
			//System.out.println(label.get(i));
			//System.out.println(Double.parseDouble(close.get(i).getAsString() ) );
			
		}
		//System.out.println(label);
		//System.out.println(close);
		request.setAttribute("label", label);
		request.setAttribute("close", close);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/chart.jsp");
		rd.forward(request, response);
	}

}
