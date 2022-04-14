<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>#[[$Title$]]#</title>
</head>
<body>

<form action="<%=request.getContextPath().concat("/welcome")%>"
      method="post">
    <input type="text" id="nameId" name="name"/>
    <input type="submit" value="add new user"/>
</form>


<%
    for (int i = 0; i < 10; i++) {
        response.getWriter().println(i);
    }


    Object obj = request.getAttribute("userList");
    if (obj != null && obj instanceof List) {
        List userList = (List) obj;
        for (Object usr : userList) {
            response.getWriter().println(usr);
        }
    }
%>
</body>
</html>
