package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addEmp")
public class PutEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PutEmpServlet() {
        super();     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	// doGet 메소드
		
		// 사용자가 입력한 파라미터 값들을 받아오자
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobId");
		
		// 받아온 파라미터 값들을 vo에 담아보자
		EmployeeVO vo = new EmployeeVO();
		vo.setFirstName(fName);
		vo.setLastName(lName);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobId(jobId);
		
		EmpDAO dao = new EmpDAO();
		EmployeeVO v = dao.insertEmp(vo);
		
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
