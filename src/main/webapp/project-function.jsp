<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>功能管理</title>
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
    当前位置:项目管理>>功能管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/project-function-add.jsp';" value='添加新功能' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150px'>
          <option value='0'>选择类型...</option>
          	<option value='1'>项目名称</option>
          	<option value='2'>需求名称</option>
          	<option value='3'>模块名称</option>
          	<option value='4'>功能名称</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='id'>排序...</option>
            <option value='pubdate'>添加时间</option>
            <option value='pubdate'>修改时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

    <table id="_table_list" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;功能列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">功能名称</td>
            <td width="10%">模块名称</td>
            <td width="10%">需求名称</td>
            <td width="10%">项目名称</td>
            <td width="10%">优先级</td>
            <td width="8%">添加时间</td>
            <td width="8%">修改时间</td>
            <td width="10%">操作</td>
        </tr>
        <c:forEach items="${mv}" var="func" varStatus="index" >
            <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
                <td><input name="id" type="checkbox" id="id" value="${func.id}" class="np"></td>
                <td>${index.count}</td>
                <td align="center"><a href=''><u>${func.proname}</u></a></td>
                <td align="center"><a href=''><u>${func.analysisname}</u></a></td>
                <td align="center"><a href=''><u>${func.modeleFk}</u></a></td>
                <td align="center"><a href=''><u>${func.functionname}</u></a></td>
                <td>${func.level}</td>
                <td>2015-02-03</td>
                <td>2015-06-03</td>
                <td>
                    <a href="${pageContext.request.contextPath}/func/get/${func.id}">编辑</a> |
                    <a href="${pageContext.request.contextPath}/func/getDel/${func.id}">查看详情</a>
                </td>
            </tr>
        </c:forEach>

        <tr bgcolor="#FAFAF1">
        <td height="28" colspan="12">
            &nbsp;
            <a href="javascript:selecttMessage()" class="coolbg">全选</a>
            <a href="javascript:reverseMessage()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:delectMessage()" class="coolbg">&nbsp;删除&nbsp;</a>
            <a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
        </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center"><!--翻页代码 --></td>
        </tr>
    </table>

</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
    function selecttMessage(){
        $("#_table_list").find("input").prop("checked","checked");
    }
    function reverseMessage(){
        $("#_table_list").find("input").each(function () {
            var checked = $(this).prop("checked");
            $(this).prop("checked",!checked);
        })
    }
    function delectMessage() {
        var id = "";
        $(".np:checked").each(function() {
            id = ","+$(this).val()+id;
        })
        if(id == ""){
            alert("请选择要删除的信息");
            return;
        }else{
            id = id.substring(1);
            alert(id);
        }
        if(confirm("您确定要删除吗")){
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/pro/deleteById/"+id,
                data:{
                    "_method":"delete"
                },
                success:function (msg) {
                    if(msg = 200){
                        alert("删除成功");
                        window.location.href="${pageContext.request.contextPath}/pro/getProAll"
                    }
                }
            })
        }
    }
    /* $("#sub").click(function () {
         $("#form3").submit();
     })*/
</script>
</html>