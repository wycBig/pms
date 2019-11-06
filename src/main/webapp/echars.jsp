
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 600px;height:400px;"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" >
    $(function () {
        var keys = [];
        var values = [];
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/echart/data",
            success:function (msg) {
                for(key in msg){
                    keys.push(key);
                    values.push(msg[key]);
                }
                var myechars = echarts.init(document.getElementById('main'));
                var option = {
                    title: {
                        text: 'ECharts 入门示例'
                    },
                    tooltip: {},
                    legend: {
                        data:['销量'],
                        left:'center'
                    },
                    xAxis: {
                        data:keys
                    },
                    yAxis: {},
                    series: [{
                        name: '销量',
                        type: 'bar',
                        data: values
                    }]
                };
                myechars.setOption(option);
            }
        })
    });

</script>
</html>
