package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteEmp")
public class DeleteEmpserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteEmpserv() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 지정한 id 값을 통해 삭제
		// localhost/AjaxWeb/deleteEmp ? empId = 210, 페이지 호출해서 210 값을 넘겨줌
		String id = request.getParameter("empId"); 
		// 만약 id 값이 null 값이면 0 값을 넣어준다
		id = id == null ? "0" : id;
		int employeeId = Integer.parseInt(id); // id가 String 타입이기 때문에 int 타입으로 변환해준다. 
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(employeeId);
		
		EmpDAO dao = new EmpDAO();
		
		if(dao.deleteEmp(vo)) {
			response.getWriter().append("<h1>OK</h1>");
		}else {
			response.getWriter().append("<h1>NG</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
