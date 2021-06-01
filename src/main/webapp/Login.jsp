<%--
  Created by IntelliJ IDEA.
  User: Ronin
  Date: 2021/6/7
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<h1>Login</h1>
<%
    if (request.getAttribute("message") != null) {
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="/zhangzhongwei0813_war_exploded/login">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="Username" required><br/></td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input type="password" name="password" required minlength="8"><br/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
<%@include file="footer.jsp" %>

