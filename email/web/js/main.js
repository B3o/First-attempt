function del() {
    return confirm("确定删除吗?");
}
function checkdelAll() {
    return confirm("确定删除吗?");
}
function checkAll() {
    //    让其他复选框的选中状态   跟全选的选中状态一致
    var all = document.getElementById("all");
    var cks = document.getElementsByName("ck");
    for (var i = 0; i < cks.length; ++i) {
        cks[i].checked = all.checked;
    }
}

function flushMails(mails) {
    $("ul li").remove();
    for (var i = 0; i < mails.length; i++) {
        var id = mails[i].id;
        var title = mails[i].title;
        if (title.length > 10) {
            title = title.substr(0, 10) + "...";
        }
        var content = mails[i].content;
        if (content.length > 20) {
            content = content.substr(0, 20) + "......";
        }
        var liStr = "<li class=\"unReaded\"> <input type=\"checkbox\"  name=\"ck\" value="+ id +"/>" +
            "<a href=\"/mail?type=readMsg&mailId="+ id +"\" class=\"no_xhx\">" +
            "<b>&lt;" + title +
            "&gt;</b><p>" + content + "</p></a> " +
            "<em><a href=\"\">回信</a></em> " +
            "<em><a href=\"/mail?type=delReceive&id=" + id + "\" onclick=\"return del()\">删除</a></em></li>";
        $("ul").append(liStr);
    }
}

$(function () {
    var curRow = $("#current_row").html();
    var maxRow = $("#max_row").html();
    $("#nextPage").click(function () {
        var type = $("#fyType").val();
        var nextRow = Number(curRow) + Number(1);
        if (Number(curRow) < Number(maxRow)) {
            if ($("#fyType").val() == "default") {
                $.get("/mailRow", {"rowNum":nextRow, "type":"ajaxMails"}, function (mails) {
                    flushMails(mails);
                }, "json")
            }else if ($("#fyType").val() == "search") {
                var search = $(".searchinp").val();
                $.get("/mailRow", {"type":"search", "search":search, "rowNum":nextRow}, function (data) {
                    $("ul li").remove();
                    var mails = data.mails;
                    flushMails(mails);
                    $("#max_row").html(data.mailrownum);
                }, "json")
            }
            $("#current_row").html(Number(curRow) + Number(1));
        }
    })
    $("#fontPage").click(function () {
        var curRow = $("#current_row").html();
        var frontRow = Number(curRow) - Number(1);
        if (Number(curRow) > Number(1)) {
            if ($("#fyType").val() == "default"){
                $.get("/mailRow", {"rowNum":frontRow, "type":"ajaxMails"}, function (mails) {
                    flushMails(mails);
                }, "json")
            } else if ($("#fyType").val() == "search") {
                var search = $(".searchinp").val();
                $.get("/mailRow", {"type":"search", "search":search, "rowNum":frontRow}, function (data) {
                    $("ul li").remove();
                    var mails = data.mails;
                    flushMails(mails);
                    $("#max_row").html(data.mailrownum);
                }, "json")
            }
            $("#current_row").html(frontRow);
        }
    })
$("#searchBtn").click(function () {
    $("#fyType").val("search");
    var search = $(".searchinp").val();
    $.get("/mailRow", {"type":"search", "search":search}, function (data) {
        $("ul li").remove();
        var mails = data.mails;
        flushMails(mails);
        $("#max_row").html(data.mailrownum);
    }, "json")
})
});

