package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateServ")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("empId");
		id = id == null ? "0" : id;
		int employeeId = Integer.parseInt(id);
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(employeeId);

		EmpDAO dao = new EmpDAO();
		if (dao.updateEmp(vo)) {
			response.getWriter().append("<h1>OK</h1>");
		} else {
			response.getWriter().append("<h1>NG</h1>");
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
