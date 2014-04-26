<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="pageurl" description="跳转路径" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="pageinfo" description="分页信息" required="true" rtexprvalue="true" type="com.zyexam.util.PageInfo"%>
<%@ attribute name="pageparmamname" description="后台分页参数名" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="selectpagenum" description="是否启用页数容器选择" required="true" rtexprvalue="true" type="java.lang.Boolean" %>
<%@ attribute name="selectpagesize" required="true" rtexprvalue="true" type="java.lang.Boolean" %>
<%@ attribute name="currentPage" required="true" rtexprvalue="true" type="java.lang.Boolean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function(){
		$("ul.list li").each(function(){
			var pagenum = $(this).text();
			if(pagenum == ${pageinfo.currentPage}){
				$(this).removeClass();
				$(this).addClass("openbg");
			}
		});
	});
</script>
<ul style="list-style:none;" class="list">
	<li>${pageinfo.currentPage}/${pageinfo.pageCount}</li>
<c:if test="${pageinfo.currentPage != 1}">
	<li><a href="${pageurl}?${pageparmamname}.pageSize=${pageinfo.pageSize}&${pageparmamname}.currentPage=1&${pageparmamname}.partPageCount=${pageinfo.partPageCount}">首页</a></li>
</c:if>
<c:if test="${pageinfo.startPage > 1 }">
	<li><label>...</label></li>
</c:if>
<c:forEach var="i" begin="${pageinfo.startPage}" end="${pageinfo.endPage}" step="1">
	<li class="bg"><a href="${pageurl}?${pageparmamname}.pageSize=${pageinfo.pageSize}&${pageparmamname}.currentPage=${i }&${pageparmamname}.partPageCount=${pageinfo.partPageCount}"><div>${i}</div></a></li>
</c:forEach>
<c:if test="${pageinfo.endPage < pageinfo.pageCount}">
	<li><label>...</label></li>
</c:if>
<c:if test="${pageinfo.currentPage != pageinfo.pageCount}">
	<li><a href="${pageurl}?${pageparmamname}.pageSize=${pageinfo.pageSize}&${pageparmamname}.currentPage=${pageinfo.pageCount}&${pageparmamname}.partPageCount=${pageinfo.partPageCount}">尾页</a></li>
</c:if>
<c:if test="${selectpagenum}">
	<li>
		<script type="text/javascript">
			$(function(){
				$("#partPageCount>option").each(function(){
					var partPageCount = $(this).val();
					if(partPageCount == ${pageinfo.partPageCount}){
						$(this).attr("selected","selected");
					}
				});
				
				$("#partPageCount").change(function(){
					var partPageCount = $(this).val();
					var url = "${pageContext.request.contextPath}/${pageurl}?${pageparmamname}.pageSize=${pageinfo.pageSize}&${pageparmamname}.currentPage=${pageinfo.currentPage}&${pageparmamname}.partPageCount=" +partPageCount;
					location.href=url;
				});
			});
		</script>
		<label>页码数量：</label><select size="1" id="partPageCount">
			<option value="3">3</option>
			<option value="5">5</option>
			<option value="7">7</option>
			<option value="9">9</option>
			<option value="11">11</option>
		</select>
	</li>
</c:if>
<c:if test="${selectpagesize}">
	<li>
		<script type="text/javascript">
			$(function(){
				$("#pageSize>option").each(function(){
					var pageSize = $(this).val();
					if(pageSize == ${pageinfo.pageSize}){
						$(this).attr("selected","selected");
					}
				});
				$("#pageSize").change(function(){
					var pageSize = $(this).val();
					var url = "${pageContext.request.contextPath}/${pageurl}?${pageparmamname}.pageSize="+pageSize+"&${pageparmamname}.currentPage=${pageinfo.currentPage}&${pageparmamname}.partPageCount=${pageinfo.partPageCount}";
					location.href=url;
				});
			});
		</script>
		<label>每页数量：</label><select size="1" id="pageSize">
			<option value="1">1</option>
			<option value="5">5</option>
			<option value="10">10</option>
			<option value="15">15</option>
		</select>
	</li>
</c:if>
<c:if test="${currentPage}">
	<script type="text/javascript">
		$(function(){
			$("#currentPageNum").val(${pageinfo.currentPage});
			$("#currentPageButton").click(function(){
				var value = $("#currentPageNum").val();
				if(value < 1){
					alert("您输入的页码小于最小页码");
					return;
				}
				if(value > ${pageinfo.pageCount}){
					alert("您输入的页码大于最大页码");
					return;
				}
				var url = "${pageContext.request.contextPath}/${pageurl}?${pageparmamname}.pageSize=${pageinfo.pageSize}&${pageparmamname}.currentPage="+value+"&${pageparmamname}.partPageCount=${pageinfo.partPageCount}";
				location.href=url;
			});
		});
	</script>
	<li>
		<input type="text" style="width:60px; height:18px; border:1px solid #dedede;" id="currentPageNum"/>
	</li>
	<li>
		<input type="button" style="width:40px; height:20px;" value="GO" id="currentPageButton"/>
	</li>
</c:if>
</ul>