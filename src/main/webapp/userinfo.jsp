<%@ page import="com.zhangzhongwei.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Ronin
  Date: 2021/4/19
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h1> User Info</h1>
<%
    Cookie[] allCookies = request.getCookies();
    for (Cookie c : allCookies) {
        out.println("<br/>" + c.getName() + "---" + c.getValue());
    }
%>
<%
    User u = (User) request.getAttribute("user");
%>
<table>
    <tr>
        <tb>Username:</tb>
        <td><%=u.getUsername()%>/td>
    </tr>
    <tr>
        <tb>Password:</tb>
        <td><%=u.getPassword()%>/td>
    </tr>
    <tr>
        <tb>Email:</tb>
        <td><%=u.getEmail()%>/td>
    </tr>
    <tr>
        <tb>Gender:</tb>
        <td><%=u.getGender()%>/td>
    </tr>
    <tr>
        <tb>Birth Date:</tb>
        <td><%=u.getBirthDate()%>/td>
    </tr>
</table>