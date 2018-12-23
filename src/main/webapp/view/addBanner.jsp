<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $("#addTitle").validatebox({
            required: true
        });
        $("#addStatus").validatebox({
            required: true
        });
        $("#addDate").datebox({
            editable: false,
            required: true
        });
        $("#addDesc").validatebox({
            required: true
        })
        $("#addFile").filebox({
            buttonText: '选择文件',
            accept: "jpg,png,gif"
        });
        $("#addSub").linkbutton({
            onClick: function () {
                $("#addBannerForm").form("submit", {
                    url: "${pageContext.request.contextPath}/banner/addBanner",
                    onSubmit: function () {
                        return $("#addBannerForm").form("validate");
                    },
                    success: function () {
                        $("#bannerDialog").dialog("close");
                        $.messager.show({
                            title: "系统提示",
                            msg: "添加成功"
                        });
                    }
                });
            }
        });
        $("#addReset").linkbutton({
            onClick: function () {
                $("#addBannerForm").form("reset");
            }
        });
    });
</script>

<form id="addBannerForm" method="post" enctype="multipart/form-data">
    标题：<input id="addTitle" name="title"/><br>
    状态：<input id="addStatus" name="status"/><br>
    发布日期:<input id="addDate" name="pubDate"/><br>
    描述：<input id="addDesc" name="description"/><br>
    上传：<input id="addFile" name="file"/><br>
    <a id="addSub">提交</a><a id="addReset">重置</a>
</form>