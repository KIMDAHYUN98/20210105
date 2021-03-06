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
		String eid = request.getParameter("eid");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobId");
		
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(Integer.parseInt(eid));
		vo.setFirstName(fName);
		vo.setLastName(lName);
		vo.setEmail(email);
		vo.setJobId(jobId);
		
		EmpDAO dao = new EmpDAO();
		EmployeeVO v = dao.updateEmp(vo);
		
		String result = "<result>";
		result += "<empId>" + v.getEmployeeId() + "</empId>";
		result += "<fName>" + v.getFirstName() + "</fName>";
		result += "<lName>" + v.getLastName() + "</lName>";
		result += "<email>" + v.getEmail() + "</email>";
		result += "<phoneNumber>" + v.getPhoneNumber() + "</phoneNumber>";
		result += "<hireDate>" + v.getHireDate() + "</hireDate>";
		result += "<jobId>" + v.getJobId() + "</jobId>";
		result += "<salary>" + v.getSalary() + "</salary>";
		
		result += "</result>";
		
		response.getWriter().append(result);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
