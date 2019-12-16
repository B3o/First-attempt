<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/4
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="show.jsp" method="post">
    <p>用户: <input type="text" name="un"></p>
    <p>密码: <input type="password" name="pw"></p>
    <p>性别:
        <input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女
        <input type="radio" name="sex" value="保密">保密
    </p>
    <p>
        爱好:
        <input type="checkbox" name="ck" value="篮球">篮球
        <input type="checkbox" name="ck" value="外卖">外卖
        <input type="checkbox" name="ck" value="美女">美女
        <input type="checkbox" name="ck" value="睡觉">睡觉
        <input type="checkbox" name="ck" value="游戏">游戏
        <input type="checkbox" name="ck" value="手冲">手冲
    </p>
    <p>
        备注:
        <textarea name="comment" >默认值...请任意填写</textarea>
    </p>
    <p>
        生日:
        <input type="date" name="birthday">
    </p>
    <p>
        祖籍:
        <select name="city" id="">
            <option value="江西">江西</option>
            <option value="广东">广东</option>
            <option value="上海">上海</option>
        </select>
    </p>
    <p>
        上传头像:
        <input type="file" name="head">
    </p>
    <p>
        隐藏域: <input type="hidden" name="" value="">
    </p>
    <p>
        <input type="button" value="普通按钮">
        <input type="reset" value="重置按钮">
        <input type="submit" value="提交按钮">
    </p>
</form>
<a href="show.jsp?hehe=100&like=美女&birthday=2019-12-25">传递值的超链接</a>
</body>
</html>
