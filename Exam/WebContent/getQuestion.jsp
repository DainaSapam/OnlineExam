<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%> 
<%@page import="com.exam.DAO.QuestionsDAO"%>
<%
String question_no=request.getParameter("question_no");
String questionID = request.getParameter("question_id");
String req=request.getParameter("req");
String name=(String)session.getAttribute("name");

if(req!=null){
	if(req.equals("first")){
	String result=QuestionsDAO.getQuestion(question_no);
	System.out.println(result);
	out.print(result);
	}
	else{
		   String question_id=request.getParameter("question_id");
		    String answer=request.getParameter("answer");
		    LinkedHashMap lhm=(LinkedHashMap)session.getAttribute("all_answers");
		    
		    if(!answer.equals("undefined")){
		          
		          
		          if(lhm==null){
		              lhm=new LinkedHashMap();
		              lhm.put(question_id, answer);
		              session.setAttribute("all_answers", lhm);
		          }
		          else{
		              lhm.put(question_id, answer);
		              session.setAttribute("all_answers", lhm);
		          }
		    }
	
	}
}
else{
	String question_id=request.getParameter("question_id");
	String answer=request.getParameter("answer");
    LinkedHashMap lhm=(LinkedHashMap)session.getAttribute("all_answers");
	
	if(!answer.equals("undefined")){
		  
		  
		  if(lhm==null){
			  lhm=new LinkedHashMap();
			  lhm.put(question_id, answer);
			  session.setAttribute("all_answers", lhm);
		  }
		  else{
			  lhm.put(question_id, answer);
              session.setAttribute("all_answers", lhm);
		  }
	}
	

	String result=QuestionsDAO.getQuestion(question_no);
	out.print(result);

}
%>