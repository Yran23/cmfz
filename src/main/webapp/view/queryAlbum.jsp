<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">


    $(function () {


        $("#albumFormId").val(ops.id);
        $("#albumFormImg").prop("src", "${pageContext.request.contextPath}" + ops.coverImg);
        $("#albumFormImg").validatebox({
            editable: false
        });
        $("#albumFormTitle").val(ops.title);
        $("#albumFormTitle").validatebox({
            editable: false
        })
        $("#albumFormAuthor").val(ops.author);
        $("#albumFormAuthor").validatebox({
            editable: false
        });
        $("#albumFormBroadcast").val(ops.broadcast);
        $("#albumFormBroadcast").validatebox({
            editable: false
        });
        $("#albumFormScore").val(ops.score);
        $("#albumFormScore").validatebox({
            editable: false
        });
        $("#albumFormBrief").val(ops.brief);
        $("#albumFormBrief").validatebox({
            editable: false
        });
        $("#albumFormPubDate").val(ops.pubDate);
        $("#albumFormPubDate").validatebox({
            editable: false
        });

    });

</script>

<form id="queryAlbumForm" method="post">
    <h2 style="color: red;text-align: center">专辑信息</h2>
    <input id="albumFormId" name="id" type="hidden"/>
    <img id="albumFormImg" name="coverImg" style="float:left" height="120px" width="100px">
    名称：<input id="albumFormTitle" name="title"/><br>
    作者：<input id="albumFormAuthor" name="author"/><br>
    播音：<input id="albumFormBroadcast" name="broadcast"/><br>
    评分：<input id="albumFormScore" name="score"/><br>
    详情：<input id="albumFormBrief" name="brief"/><br>
    发布日期：<input id="albumFormPubDate" name="pubDate"/><br>
</form>