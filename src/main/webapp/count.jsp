<%--
  Created by IntelliJ IDEA.
  User: Ronin
  Date: 2021/4/5
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Couter JSP</title>
</head>
<body>
<%int count=0;%>
this Page has access : <%out.println(++count);%>
</body>
</html>
