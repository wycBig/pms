<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查看项目信息</title>
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
    当前位置:项目管理>>查看项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;查看项目信息&nbsp;</td>
</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input name="pname" value="${pro.pname}"/></td>
		<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input name="comname" value="${pro.comname}"/></td>
	</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input value="${pro.comper}"/></td>
		<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input name="empFk" value="${pro.empFk}"/></td>
	</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input name="empcount" value="${pro.empcount}">人</td>
		<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input id="starttime" name="starttime" value="${pro.starttime}"/>
			<img onclick="WdatePicker({el:'starttime'})" src="${pageContext.request.contextPath}/static/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
		</td>
	</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input id="buildtime" name="buildtime" value="${pro.buildtime}"/>
			<img onclick="WdatePicker({el:'buildtime'})" src="${pageContext.request.contextPath}/static/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
		</td>
		<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input name="cost" value="${pro.cost}"/>万</td>
	</tr>
	<tr >
		<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<select name="level">
				<option <c:if test="${pro.level == '紧急'}" >selected</c:if> value='紧急'>紧急</option>
				<option <c:if test="${pro.level == '一般'}" >selected</c:if> value='一般'>一般</option>
				<option <c:if test="${pro.level == '暂缓'}" >selected</c:if> value='暂缓'>暂缓</option>
			</select>
		</td>
		<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
		<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<input id="endtime"  name="endtime" value="${pro.endtime}"/>
			<img onclick="WdatePicker({el:'endtime'})" src="${pageContext.request.contextPath}/static/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
		</td>
	</tr>

	<tr >
		<td align="right" bgcolor="#FAFAF1" >备注：</td>
		<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea name="remark" rows=15 cols=130>
					${pro.remark}
				</textarea>
		</td>
	</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:history.go(-1)" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>