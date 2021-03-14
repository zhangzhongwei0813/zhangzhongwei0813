<%--
  Created by IntelliJ IDEA.
  User: Ronin
  Date: 2021/3/14
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="http://www.ecjtu.jx.cn/">go to ecjtu</a></br><!--method is GET-->
<from method="post"><!--what ie method when we use from?--><!--its GET ,why? default is GET,from data is added in the URL, u can see>
<-- its better to use POST in from , data in not added in the URL-->
    Name :<input type="text" name="name"></br>
    ID :<input type="next" name="id"></br>
    <input type="submit" value="send data to server"/>
</from>>


</body>
</html>
