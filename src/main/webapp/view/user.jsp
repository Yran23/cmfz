<%@page pageEncoding="UTF-8" %>

<meta charset="utf-8">
<meta name="content-type" content="text/html;">
<!-- 引入 ECharts 文件 -->
<script src="../js/echarts.min.js;"></script>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持明法洲app活跃用户'
        },
        tooltip: {},
        legend: {
            data: ['天数']
        },
        xAxis: {
            data: ["7天", "15天", "30天", "90天", "半年", "一年"]
        },
        yAxis: {},
        series: [{
            name: '天数',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    // 异步加载统计信息
    $.post("${pageContext.request.contextPath }/user/queryUserCount", function (data) {
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption({
            /*            xAxis: {
                            data: data.intervals
                        },*/
            series: [{
                // 根据名字对应到相应的系列
                name: '活跃用户',
                data: data
            }]
        });
    }, "json");
</script>
