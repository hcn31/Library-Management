<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  HttpSession session1 = request.getSession(false);
  if (session1 == null || session1.getAttribute("login") == null)     request.getRequestDispatcher("/index.jsp").forward(request, response);

%>
