<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/jsp/js/jquery-3.0.0.min.js" type="text/javascript"></script>
</head>
<body>
<%--展示表中所有数据---控制层发送请求--service-dao--%>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <c:forEach var="p" items="${list}">
    <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.age}</td>
    </tr>
    </c:forEach>
</table>
[当前页:${pageIndex}/总页数:${totalPage}]
<c:if test="${pageIndex gt 1}">
    <a href="/jsp/show?pageIndex=1">首页</a>
    <a href="/jsp/show?pageIndex=${pageIndex-1}">上一页</a>
</c:if>
<c:if test="${pageIndex le 1}">首页 上一页</c:if>
<c:if test="${pageIndex lt totalPage}">
    <a href="/jsp/show?pageIndex=${pageIndex+1}">下一页</a>
    <a href="/jsp/show?pageIndex=${totalPage}">尾页</a>
</c:if>
<c:if test="${pageIndex ge totalPage}">下一页 尾页</c:if>

<p>

<input type="text" id="page" size="2">页<button>跳转</button>
</p>
<p>
切换每页条数(默认为5)
<select>                 <!--保存 上一次 选择页数当做默认值-->
    <option  value="5" <c:if test="${pageCount eq 5}">selected</c:if>  >5</option>
    <option value="10" <c:if test="${pageCount eq 10}">selected</c:if> >10</option>
    <option value="15" <c:if test="${pageCount eq 15}">selected</c:if> >15</option>
    <option value="20" <c:if test="${pageCount eq 20}">selected</c:if> >20</option>
</select>
</p>
</body>
</html>
<script>
    $("button").click(function(){
        var page=$("#page").val();
        if(page<=0){  //如果输入的是负数  默认为1
            page=1;
        }
        if(page>${totalPage}){ //如果超过总页数 默认为总页数
            page=${totalPage};
        }
        //js实现页面跳转方式   get方式
        location.href='/jsp/show?pageIndex='+page;
    })
    //域改变事件  onchange
    $("select").change(function(){
       var count= $(this).val();
       location.href='/jsp/show?pageCount='+count;
    })
</script>