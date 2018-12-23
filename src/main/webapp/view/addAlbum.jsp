<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#addAlbumImg").filebox({
            required: true,
            buttonText: "请选择",
            accept: "image/*"
        });
        $("#addAlbumTitle").validatebox({
            required: true
        });
        $("#addAlbumAuthor").validatebox({
            required: true
        });
        $("#addAlbumBroadcast").validatebox({
            required: true
        });
        $("#addAlbumScore").validatebox({
            required: true
        });
        $("#addAlbumBrief").validatebox({
            required: true
        });
        $("#addAlbumSub").linkbutton({
            onClick: function () {
                $("#addAlbumForm").form("submit", {
                    url: "${pageContext.request.contextPath}/album/addAlbum",
                    onSubmit: function () {
                        return $("#addAlbumForm").form("validate");
                    },
                    success: function () {
                        $("#addAlbumDialog").dialog("close");
                        $("#album").treegrid("load");
                        $.messager.show({
                            title: "系统提示",
                            msg: "添加成功"
                        });
                    }
                })
            }
        });
        $("#addAlbumReset").linkbutton({
            onClick: function () {
                $("#addAlbumForm").form("reset");
            }
        });
    });
</script>

<h2 style="color: red;text-align:center">添加专辑</h2>
<form id="addAlbumForm" method="post" enctype="multipart/form-data">
    名称：<input id="addAlbumTitle" name="title"/><br>
    作者：<input id="addAlbumAuthor" name="author"/><br>
    播音：<input id="addAlbumBroadcast" name="broadcast"/><br>
    封面：<input id="addAlbumImg" name="multipartFile"/><br>
    评分：<input id="addAlbumScore" name="score"/><br>
    详情：<input id="addAlbumBrief" name="brief"/><br>
    <a id="addAlbumSub">添加</a><a id="addAlbumReset">重置</a>
</form>