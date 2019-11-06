<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>发件箱</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:信息箱>>通知公告
 </td>
	  <td>
		  <input type='button' class="coolbg np" onClick="location='notice-send.jsp';" value='发布新通告' />
	  </td>
 </tr>
</table>
</td>
</tr>
</table>
<!--  搜索表单  -->
<form id ="form3" name='form3' action='javascript:void(0)' method='get'>
	<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
		<tr bgcolor='#EEF4EA'>
			<td background='skin/images/wbg.gif' align='center'>
				<table border='0' cellpadding='0' cellspacing='0'>
					<tr>
						<td width='90' align='center'>搜索条件：</td>
						<td width='70'>
							关键字：
						</td>
						<td width='160'>
							<input id="likes" type='text' name='search_like_keyword'  style='width:120px' />
						</td>
						<td>
							&nbsp;&nbsp;<input onclick="tiJiao();return false;" id="sub" name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;发件箱&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22" id="tr2">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">标题</td>
	<td width="10%">内容</td>
	<td width="8%">发送时间</td>
	<td width="8%">操作</td>
</tr>

<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td>1</td>
	<td>项目完成的咋样?</td>
	<td align="center"><span >最近工作累不？项目完成的咋样?加油哈</span></td>
	<td>2015-02-03</td>
	<td><a >删除</a></td>
</tr>--%>


<tr bgcolor="#FAFAF1" id="insertMess" >
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center" id="dddd" >
		
	</td>
</tr>
</table>

</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(function(){
        $.ajax({
            type:'GET',
            url:'${pageContext.request.contextPath}/notice/getAll',
            success:function (msg) {
                if(msg.map.statusCode == 200) {
                    $(msg.map.page.list).each(function (index, item) {
                        var tr = "<tr class='app' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                            "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                            "\t<td>" + ((msg.map.page.pageNum - 1)*msg.map.page.pageSize+(index + 1)) + "</td>\n" +
                            "\t<td>" + item.ntitle + "</td>\n" +
                            "\t<td align=\"center\"><span >" + item.remark + "</span></td>\n" +
                            "\t<td>moment(item.ndate).format('YYYY-MM-DD')</td>\n" +
                            "\t<td><a >删除</a></td>\n" +
                            "</tr>"
                        $("#insertMess").before(tr);
                    });
                    //分页展示
                    var div = "<div id='cccc' ></div>";
                    //上一页
                    var firstPage = "<a onclick='pagePage(this.name)' href='javascript:void(0)'  name='" + msg.map.requestURI + "?pageNum=1+ msg.map.paramVal' >首页</a> &nbsp;";
                    var prePage = "<a onclick='pagePage(this.name)' href='javascript:void(0)' name='" + msg.map.requestURI + "?pageNum=" + (msg.map.page.pageNum - 1)+ msg.map.paramVal  + "' >上一页</a>&nbsp;";
                    var nextPage = "<a onclick='pagePage(this.name)' href='javascript:void(0)' name='" + msg.map.requestURI + "?pageNum=" + (msg.map.page.pageNum + 1)+ msg.map.paramVal  + "' >下一页</a>&nbsp;";
                    var endPage = "<a onclick='pagePage(this.name)' href='javascript:void(0)' name='" + msg.map.requestURI + "?pageNum=" + (msg.map.page.pages)+ msg.map.paramVal + "' >尾页</a>";

                    var page = "";
                    $(msg.map.page.navigatepageNums).each(function (index,item) {
                       /* if(msg.map.page.pageNum = pageNum){*/
                            page = page + "<a onclick='pagePage(this.name)' href='javascript:void(0)' name'"+ msg.map.requestURI+"?pageNum="+item+ msg.map.paramVal+"'>"+item+"页</a>&nbsp;"
						/*}
                        if(msg.map.page.pageNum = pageNum){
                            page = page + "<a href='"+ msg.map.requestURI+"?pageNum="+item+"'>"+item+"页</a>"
                        }*/

                    })

                    $(div).append(firstPage).append(prePage).append(page).append(nextPage).append(endPage).appendTo($("#dddd"))
                }
            }
        })
    });
    function pagePage(path) {
        $.ajax({
            type:'GET',
            url:path,
            success:function (msg) {
                if(msg.map.statusCode == 200) {
                    $(".app").remove();
                    $(msg.map.page.list).each(function (index, item) {
                        var tr = "<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                            "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                            "\t<td>" + ((msg.map.page.pageNum - 1)*msg.map.page.pageSize+(index + 1)) + "</td>\n" +
                            "\t<td>" + item.ntitle + "</td>\n" +
                            "\t<td align=\"center\"><span >" + item.remark + "</span></td>\n" +
                            "\t<td>2015-02-03</td>\n" +
                            "\t<td><a >删除</a></td>\n" +
                            "</tr>"
                        $("#insertMess").before(tr);
                    });
                }
            }
        })
    }
    function tiJiao() {
        var val1 = $("#likes").val();

		/*var fordate = new FormData();
		fordate.append("search_status",val);
		fordate.append("search_like_keyword",val1);
*/
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/notice/getAll",
			data:{"search_like_keyword":val1},
			success:function (msg) {
                $(".app").remove();
                $("#cccc").remove();
                if(msg.map.statusCode == 200) {
                    $(msg.map.page.list).each(function (index, item) {
                        var tr = "<tr class='app' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                            "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                            "\t<td>" + ((msg.map.page.pageNum - 1)*msg.map.page.pageSize+(index + 1)) + "</td>\n" +
                            "\t<td>" + item.ntitle + "</td>\n" +
                            "\t<td align=\"center\"><span >" + item.remark + "</span></td>\n" +
                            "\t<td>2015-02-03</td>\n" +
                            "\t<td><a >删除</a></td>\n" +
                            "</tr>"
                        $("#insertMess").before(tr);
                    });
                    //分页展示
                    var div = "<div></div>";
                    //上一页
                    var firstPage = "<a onclick='pagePage(this.name)' href='javascript:void(0)'  name='" + msg.map.requestURI + "?pageNum=1+ msg.map.paramVal' >首页</a> &nbsp;";
                    var prePage = "<a onclick='pagePage(this.name)' href='javascript:void(0)' name='" + msg.map.requestURI + "?pageNum=" + (msg.map.page.pageNum - 1)+ msg.map.paramVal  + "' >上一页</a>&nbsp;";
                    var nextPage = "<a onclick='pagePage(this.name)' href='javascript:void(0)' name='" + msg.map.requestURI + "?pageNum=" + (msg.map.page.pageNum + 1)+ msg.map.paramVal  + "' >下一页</a>&nbsp;";
                    var endPage = "<a onclick='pagePage(this.name)' href='javascript:void(0)' name='" + msg.map.requestURI + "?pageNum=" + (msg.map.page.pages)+ msg.map.paramVal + "' >尾页</a>";

                    var page = "";
                    $(msg.map.page.navigatepageNums).each(function (index,item) {
                        /* if(msg.map.page.pageNum = pageNum){*/
                        page = page + "<a onclick='pagePage(this.name)' href='javascript:void(0)' name'"+ msg.map.requestURI+"?pageNum="+item+ msg.map.paramVal+"'>"+item+"页</a>&nbsp;"
                        /*}
                        if(msg.map.page.pageNum = pageNum){
                            page = page + "<a href='"+ msg.map.requestURI+"?pageNum="+item+"'>"+item+"页</a>"
                        }*/

                    })

                    $(div).append(firstPage).append(prePage).append(page).append(nextPage).append(endPage).appendTo($("#dddd"))
                }
            }
		})
    }
</script>
</html>