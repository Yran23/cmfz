<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $.extend($.fn.validatebox.defaults.rules, {
            status: {
                validator: function (value) {
                    return value == "y" || value == "n";
                },
                message: "请正确填写y或n"
            },
        });
        $("#bannerDg").edatagrid({
            fit: true,
            fitColumns: true,
            url: "${pageContext.request.contextPath}/banner/selectAllBanner",
            toolbar: "#bannerBtn",
            columns: [[
                {field: "id", title: "id", width: 1},
                {field: "title", title: "标题", width: 1},
                {field: "imgPath", title: "图片路径", width: 1},
                {
                    field: "status",
                    title: "状态",
                    width: 1,
                    editor: {type: "validatebox", options: {required: true, validType: "status"}}
                },
                {field: "pubDate", title: "发布日期", width: 1},
                {field: "description", title: "描述", width: 1}
            ]],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/shouye/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>&nbsp;&nbsp;标题: ' + rowData.title + '</p>' +
                    '<p>&nbsp;&nbsp;状态: ' + rowData.status + '</p>' +
                    '<p>&nbsp;&nbsp;发布日期: ' + rowData.pubDate + '</p>' +
                    '<p>&nbsp;&nbsp;描述: ' + rowData.description + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onSave: function (idx, row) {
                $.post("${pageContext.request.contextPath}/banner/updateStatus", {
                    "id": row.id,
                    "status": row.status
                }, function () {
                });
            },
            onDestroy: function (idx, row) {
                $.post("${pageContext.request.contextPath}/banner/deleteBanner", {"id": row.id}, function () {
                });
            }
        });
        $("#bannerAdd").linkbutton({
            iconCls: "icon-add",
            onClick: function () {
                $("#bannerDialog").dialog({
                    href: "${pageContext.request.contextPath}/view/addBanner.jsp"
                });
                $("#bannerDialog").dialog("open");
            }
        });
        $("#bannerDialog").dialog({
            title: "添加轮播图",
            height: 240,
            width: 300,
            method: "GET",
            closed: true
        });
        $("#bannerDelete").linkbutton({
            iconCls: "icon-delete",
            onClick: function () {
                $("#bannerDg").edatagrid("destroyRow");
            }
        });
        $("#bannerSave").linkbutton({
            iconCls: "icon-save",
            onClick: function () {
                $("#bannerDg").edatagrid("saveRow");
            }
        });
    });

</script>

<table id="bannerDg"></table>
<div id="bannerBtn">
    <a id="bannerAdd">添加</a>

    <a id="bannerDelete">删除</a>
    <a id="bannerSave">保存</a>
</div>
<div id="bannerDialog"></div>