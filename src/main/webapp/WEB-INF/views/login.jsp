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
<form method="post" action="login">
    Username:<input type="text" name="usename"></br>
    Password:<input type="password" name="password"></br>
    <input type="submit" value="Submit"/>
</form>
<%@include file="footer.jsp" %>
