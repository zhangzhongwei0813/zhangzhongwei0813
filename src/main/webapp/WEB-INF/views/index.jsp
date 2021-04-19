<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<h1><%= "Hello World!!!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form>
    <span style="...">New User Registration</span><br/><br/>
    <span style="...">Username</span> <input type="text" name="name" required="true" style="..."><br/><br/>
    <span style="...">Password</span> <input type="password" name="password" required="true" style="..."><br/><br/>
    <span style="...">Email</span> <input type="email" name="email" required="true" style="..."><br/><br/>
    <span style="...">Gender</span>
    <span style="...">Male</span><input type="radio">
    <span style="...">female</span><input type="radio"><br/><br/>
    <span style="..."> Date of birth(yyyy-mm-dd) </span> <input type="date" pattern="yyyy-mm-dd" required="true"
                                                                style="..."><br/><br/>
    <input type="submit" value="Register" style="...">

</form>
<%@include file="footer.jsp" %>