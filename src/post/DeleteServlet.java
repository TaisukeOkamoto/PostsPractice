package post;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.User;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");

		//　ユーザーIDが入っている時のみユーザーを削除する
		if(idStr.isEmpty() == false) {
			int numId = Integer.parseInt(idStr);
			ArrayList<User> userList = User.DeleteUser(numId);

			request.setAttribute("userList", userList);

			Gson gson = new Gson();
			String userListJson = gson.toJson(userList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(userListJson);
			out.flush();

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
