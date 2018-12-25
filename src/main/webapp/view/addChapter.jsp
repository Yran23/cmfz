<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#addChapterFile").filebox({
            required: true,
            buttonText: "请选择",
            accept: "audio/*"
        });
        $("#addChapterTitle").validatebox({
            required: true
        });
        $("#addChapterSub").linkbutton({
            onClick: function () {
                var row = $("#album").treegrid("getSelected");
                $("#parent_id").val(row.id)
                $("#addChapterForm").form("submit", {
                    url: "${pageContext.request.contextPath}/chapter/addChapter",
                    onSubmit: function () {
                        return $("#addChapterForm").form("validate")
                    },
                    success: function () {
                        $("#addChapterDialog").dialog("close");
                        $("#album").treegrid("load");
                        $.messager.show({
                            title: "系统提示",
                            msg: "添加成功"
                        });
                    }
                });
            }
        });
        $("#addChapterReset").linkbutton({
            onClick: function () {
                $("#addChapterReset").form("reset");
            }
        });
    })
</script>

<h2 style="color: red;text-align:center">添加章节</h2>
<form id="addChapterForm" method="post" enctype="multipart/form-data">
    <input id="parent_id" name="parent_id" type="hidden">
    名称：<input id="addChapterTitle" name="title"><br>
    上传：<input id="addChapterFile" name="audio"><br>
    <a id="addChapterSub">添加</a><a id="addChapterReset">重置</a>
</form>