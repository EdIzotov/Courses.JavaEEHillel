<%@ page import="java.util.List" %>
<html>
    <head>
        <title>Ed's App</title>
    </head>
    <body>
        <form method="post" action="<%=request.getContextPath().concat("/usernames")%>">
            <input type="text" name="userNameComponent" />
            <input type="submit" value="Add UserName" />
        </form>
        <table>
            <%
                Object object = request.getAttribute("names");
                if (object != null) {
                    List usernames = (List) object;
                    for (Object el: usernames) {
                        %>
                        <tr><td>
                            <%=el%>
                        </td></tr>
                        <%
                    }
                }
            %>
        </table>
    </body>
</html>
