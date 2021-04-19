<%--
  Created by IntelliJ IDEA.
  User: Ronin
  Date: 2021/4/19
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message") == null)) {
        out.println(request.getAttribute("message"));
    }
%>
<%
    Cookie[] allCookie = request.getCookies();
    String username = "", password = "", rememberMeVal = "";
    if (allCookie != null) {
        for (Cookie c : allCookie) {
            if (c.getName().equals("cUsername")) {
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")) {
                password = c.getValue();
            }
            if (c.getName().equals("cRememberMeVal")) {
                rememberMeVal = c.getValue();
            }

        }
    }

%>
<form method="post" action="login">
    Username:<input type="text" name="usename" value="<%=username%>"><br/>
    Password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%rememberMeVal.equals("1")?checked:""%>checked/>RememberMe<br/>
    <input type="submit" value="Submit"/>
</form>
<%@include file="footer.jsp" %>
