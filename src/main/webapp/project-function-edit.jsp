<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑功能信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
        $(function () {
            //获取到公司名字
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/pro/getComName",
                success:function (cus) {
                    $(cus).each(function (index,item) {
                        var option = "<option value='"+item.pid+"' >"+item.pname+"</option><>";
                        $("#getComName").append(option);
                    })
                }
            })
           /* //获取到项目经理
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/emp/getJiLi",
                success:function (cus) {
                    $(cus).each(function (index,item) {
                        var option = "<option value='"+item.eid+"'>"+item.ename+"</option><>";
                        $("#getJILi").append(option);
                    })
                }
            })*/
        })
        //获取到公司负责人
        function getconAnal(id) {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/cus/getComPerson/"+id,
                success:function (msg) {
                    $("#proLeader").val(msg.companyperson);
                }
            })
        }
        //提交表单
        function commit() {
            $("#forms").submit();
        }
	</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>编辑功能信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2">

	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑功能&nbsp;</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select id="getComName" onchange="getconAnal(this.value)" >
					<option value=1>农业银行自助管理系统</option>
				</select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">选择需求：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select>
					<option value=1>帐户管理需求分析</option>
				</select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">选择模块：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select>
					<option value=1>帐户管理模块</option>
				</select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">功能名称：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input value="添加帐户功能"/>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select>
					<option>高</option>
					<option>中</option>
					<option>低</option>
					<option>暂缓</option>
				</select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<textarea rows=10 cols=130>
					管理农行帐户信息
				</textarea>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<textarea rows=15 cols=130>
					帐户管理各功能的详细详细信息如下
				</textarea>
			</td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" >备注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea rows=10 cols=130>暂无</textarea>
			</td>
		</tr>


		<tr bgcolor="#FAFAF1">
		<td height="28" colspan=4 align=center>
			&nbsp;
			<a href="project-function.jsp" class="coolbg">保存</a>
			<a href="project-function.jsp" class="coolbg">返回</a>
		</td>
		</tr>
		</table>

	</form>
</body>
</html>