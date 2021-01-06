package common.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/boardList") // 최상위
public class boardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public boardList() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.getBoardList();
		
		String data = "<dataset>";
		for(BoardVO bord : list) {
			data += "<record>";
			data += "<boardNo>" + bord.getBoardNo() + "</boardNo>" +
					"<title>" + bord.getTitle() + "</title>" +
					"<content>" + bord.getContent() + "</content>" +
					"<writer>" + bord.getWriter() + "</writer>" +
					"<creationDate>" + bord.getCreationDate() + "</creationDate>";
			
				data += "</record>";
		}
		data += "</dataset>";
		response.getWriter().append(data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
