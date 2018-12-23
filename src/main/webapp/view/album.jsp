<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    var ops;
    $(function () {
        var toolbar = [{
            iconCls: 'icon-search',
            text: "专辑详情",
            handler: function () {
                ops = $("#album").treegrid("getSelected");
                if (ops && ops.children) {
                    $("#queryAlbumDialog").dialog({
                        href: "${pageContext.request.contextPath}/view/queryAlbum.jsp"
                    });
                    $("#queryAlbumDialog").dialog("open");
                }
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-add',
            handler: function () {
                $("#addAlbumDialog").dialog({
                    href: "${pageContext.request.contextPath}/view/addAlbum.jsp"
                });
                $("#addAlbumDialog").dialog("open");
            }
        }, '-', {
            text: "添加音频",
            iconCls: 'icon-add',
            handler: function () {
                alert('帮助按钮')
            }
        }, '-', {
            text: "音频下载",
            iconCls: 'icon-undo',
            handler: function () {
                $("#dg").edatagrid("saveRow")

            }
        }]

        $('#album').treegrid({
            method: "get",
            url: '${pageContext.request.contextPath}/album/queryAllAlbum',
            idField: 'id',
            treeField: 'title',
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
            columns: [[
                {field: 'title', title: '名字', width: 1},
                {field: 'duration', title: '时长', width: 1},
                {field: 'size', title: '大小', width: 1},
                {field: 'uploadDate', title: '上传时间', width: 1},
            ]],

        });
        $("#queryAlbumDialog").dialog({
            title: "专辑详情",
            height: 270,
            width: 380,
            closed: true,
            modal: true
        });
        $("#addAlbumDialog").dialog({
            title: "添加专辑",
            height: 270,
            width: 380,
            closed: true,
            modal: true
        });

    })

</script>

<table id="album"></table>
<div id="queryAlbumDialog"/>
<div id="addAlbumDialog"/>