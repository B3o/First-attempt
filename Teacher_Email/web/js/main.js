$(function () {
    var curRow = $("#current_row").html();
    var maxRow = $("#max_row").html();
    $("#nextPage").click(function () {
        var nextRow = Number(curRow) + Number(1);
        if (Number(curRow) < Number(maxRow)) {
            $.get("/mailRow", {"rowNum":nextRow}, function (mails) {
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
                    var liStr = "<li class=\"unReaded\"> <input type=\"checkbox\"/><a href=\"/readMsg?mailId="+ id +"\" class=\"no_xhx\">" +
                        "<b>&lt;" + title +
                        "&gt;</b><p>" + content + "</p></a> " +
                        "<em><a href=\"\">回信</a></em> " +
                        "<em><a href=\"\">删除</a></em></li>"
                    $("ul").append(liStr);
                }
                $("#current_row").html(Number(curRow) + Number(1));
            }, "json")
        }
    });
    $("#fontPage").click(function () {
        var curRow = $("#current_row").html();
        var frontRow = Number(curRow) - Number(1);
        if (Number(curRow) > Number(1)) {
            $.get("/mailRow", {"rowNum":frontRow}, function (mails) {
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
                    var liStr = "<li class=\"unReaded\"> <input type=\"checkbox\"/><a href=\"/readMsg?mailId="+ id +"\" class=\"no_xhx\">" +
                        "<b>&lt;" + title +
                        "&gt;</b><p>" + content + "</p></a> " +
                        "<em><a href=\"\">回信</a></em> " +
                        "<em><a href=\"\">删除</a></em></li>"
                    $("ul").append(liStr);
                }
                $("#current_row").html(frontRow);
            }, "json")
        }
    });

});

