<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/11
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/js/jquery-3.0.0.min.js"></script>
    <title>Title</title>
</head>
<body>
<input type="text" id="myname">
<br>
<input type="submit" value="测试测试" id="myBtn">
<br>
<h1 id="resultH"></h1>

</body>
<script>
    $(function () {
        $("#myBtn").click(function () {
                var name = $("#myname").val();
                $.get("/jsp/ajaxServlet", {"username":name},function (data) {
                    // alert(data);
                    // console(data);
                    //var a=$.parseJSON(data);
                    alert(data.name);
                }, "json");
        })
    })
</script>
</html>
