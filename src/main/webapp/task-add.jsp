<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>创建任务</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:任务管理>>创建任务
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" name="form2" action="${pageContext.request.contextPath}/usual/addTask" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="selectPro" onchange="getNeed(this.value)">
			<option value=1>请选择</option>

		</select>-
		<select id="geNeedd" onclick="parseModel(this.value)" >
			<option value=1>请选择</option>

		</select>-
		<select id="getModel" onclick="getfunc(this.value)" >
			<option value=1>请选择</option>

		</select>-
		<select name="funFk" id="getFunction" >
			<option value=1>请选择</option>

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="tasktitle" /></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="start" name="starttime" />
		<img onclick="WdatePicker({el:'start'})" src="${pageContext.request.contextPath}/static/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="end" name="endtime" />
		<img onclick="WdatePicker({el:'end'})" src="${pageContext.request.contextPath}/static/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="getPerson" name="empFk" >
			<option value=1>请选择</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="level" >
			<option value="高" >高</option>
			<option value="中" >中</option>
			<option value="低" >低</option>
			<option value="暂缓" >暂缓</option>
		</select>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea name="remark" rows=10 cols=130></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
</td>
</tr>
</table>

</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/pro/getNeedPro",
            success:function (pro) {
                $(pro).each(function (index,item) {
                    var option = "<option value='"+item.pid+"' >"+item.pname+"</option>";
                    $("#selectPro").append(option);
                })
            }
        })
    })
	//获取员工列表
    $(function () {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/usual/getPerson",
            success:function (pro) {
                $(pro).each(function (index,item) {
                    var option = "<option value='"+item.eid+"' >"+item.ename+"</option>";
                    $("#getPerson").append(option);
                })
            }
        })
    })
    function getNeed(pid) {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/mod/gettitle/"+pid,
            success:function (anal) {
                $("#geNeedd > option").remove();
                var option = "<option selected  value='"+anal.id+"' >"+anal.title+"</option>"
                $("#geNeedd").append(option);
            }
        })
    }
    function parseModel(id){
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/mod/getModel/"+id,
            success:function (mod) {
                $("#getModel > option").remove();
                $(mod).each(function (index,item) {
                    var option = "<option selected  value='"+item.id+"' >"+item.modname+"</option>"
                    $("#getModel").append(option);
                })
            }
        });
    }
    function getfunc(id){
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/usual/getFunction/"+id,
            success:function (mod) {
                $("#getFunction > option").remove();
                $(mod).each(function (index,item) {
                    var option = "<option selected  value='"+item.id+"' >"+item.functionname+"</option>"
                    $("#getFunction").append(option);
                })
            }
        });
    }

   function commit() {
        $("#form2").submit();
    }
</script>
</html>