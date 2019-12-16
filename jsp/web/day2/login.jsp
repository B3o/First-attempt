<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/3
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--使用jquery 引入jquery文件--%>
    <script src="../js/jquery-3.0.0.min.js"></script>
</head>
<body>
<%--action = "数据提交到服务器的位置"
    method = "请求方式"
    get/post区别
    enctype = "传值方式" application/x-www-form-urlencoded 默认值 代表传递的值都是String
    multipart/form-data  代表传递的是附件形式--%>
<%--表单语义化 让表单的元素更有意义
    指定类的引用  用.
    指向是项目其他资源  用/
    相对路径:相对我原来的路径,去定位目标文件
    绝对路径:从项目的根目录开始定位目标文件
            (/项目前缀 项目名/包名/文件名)
--%>
<form action="/jsp/day2/show.jsp" method="get">
    <fieldset style="width: 300px;">
        <legend>登陆</legend>
        <label for="un">用户: </label><input type="text" id = "un" name="un"><br>
        <label for="pw">密码: </label><input type="password" id = "pw" name="pw">
        <input type="submit" value="登陆" onclick="test()">
    </fieldset>
</form>

</body>
<script type="text/javascript">

    /*
    <input type = "text">
    <input type = "text" class="c1">
    <input type = "text" id = "">
    * 交集获取元素的公共部分 由两部分构成 第一部分一定标签选择器
    * 第二部分可以类 可以是id选择器
    * */
    function test() {
        var text = document.getElementById("un");
        // text.innerHTML 没有内容
        // text.value 输入的信息

    }
</script>
</html>
