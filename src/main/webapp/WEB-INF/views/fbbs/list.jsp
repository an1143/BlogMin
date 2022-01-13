<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

	 <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 리스트페이지</h3>
        <div class="row mt">
          <div class="col-lg-12">
            <div class="content-panel" align="center">
          
              <h4><i class="fa fa-angle-center"></i> 게시판 목록</h4>
              <section id="unseen">
            
             <div align="center">
             <span class="col-md-12"> 
             <select name="findType" id="findType" >
                  <option value="N"  <c:out value= "${fCri.findType == null? 'selected' : ''}" /> >-------------</option>
                  <option value="S"  <c:out value= "${fCri.findType == 'S'? 'selected' : '' }" /> >제목</option>
                  <option value="C"  <c:out value= "${fCri.findType == 'C'? 'selected' : '' }" />>내용</option>
                  <option value="W"  <c:out value= "${fCri.findType == 'W'? 'selected' : '' }" />>작성자</option>
                  <option value="SC" <c:out value= "${fCri.findType == 'SC'? 'selected' : '' }" />>제목+내용</option>
                  <option value="CW" <c:out value= "${fCri.findType == 'CW'? 'selected' : '' }" />>내용+작성자</option>
                  <option value="SCW"<c:out value= "${fCri.findType == 'SCW'? 'selected' : '' }" />>제목+내용+작성자</option>
            </select>
            
              <input type="text" name="keyword" id="findword" value="${fCri.keyword}"/>
              <button type="button" id="findBtn">검색</button>
              </span>
             </div>
            <br/><br/>
                <table class="table table-bordered table-striped table-condensed">
                  <thead>
                    <tr>
                
                      <th >글번호</th>
                      <th >제목</th>
                      <th >작성자</th>
                      <th>작성일 </th>
                      <th  class="numeric" >조회수</th>
                    </tr>
                  </thead>
                  <tbody>
                   
                   <c:forEach items="${list}" var = "bvo">
                   			<tr>
                   				<td>${bvo.bid_tb}</td>
                   				<%-- <td><a href="/bbs/read?bid=${bvo.bid_tb}">${bvo.subject}</a></td> --%>
                   				<td><a href="/fbbs/readPage${pagingMaker.makeFind(pagingMaker.cri.page)}&bid=${bvo.bid_tb}">${bvo.subject}</a></td> 
                   				<td>${bvo.writer}</td>
                   				<td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${bvo.regdate}" ></fmt:formatDate></td>
								<td>${bvo.hit}</td>
                   	
                   			</tr>
                   </c:forEach>

                  </tbody>
                </table>
              </section>
              
               <div align=center>
                   <button type="button" id="writeBtn">글쓰기</button>
              </div>
              
              <div class="showback" align="center">
              <div class="btn-group" >
              
              <c:if test="${pagingMaker.prev}">
                <a href="list${pagingMaker.makeFind(pagingMaker.startPage-1)}"><button type="button" class="btn btn-theme02">◀ </button></a>
              </c:if> 
               
               
               <c:forEach begin = "${pagingMaker.startPage}"  end="${pagingMaker.endPage}" var="pNum">
                 
                
                     	<a href="list${pagingMaker.makeFind(pNum)}">
                     	<button type="button" 
                     	class = "<c:out value = "${pagingMaker.cri.page == pNum?' btn btn-theme':'btn btn-default'}"/>  ">
                     	${pNum}
                     	</button>
                     	
                     
                     	</a> 
                
             
                </c:forEach>
             
              <c:if test="${pagingMaker.next&&pagingMaker.endPage>0}">
              
                      <a href="list${pagingMaker.makeFind(pagingMaker.endPage+1)}">
                          <button type="button" class="btn btn-theme02"> ▶</button>
                      </a> 
                
              </c:if>  
                
              </div>
            </div>
              
              
              
              
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-lg-4 -->
      
         
   
        </div>
        <!-- /row -->
   
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->

   <script>
  
    var  a1 = '${result1}';
    
 
    if(a1 == 'success'){
        alert('입력성공');
    	
    }

    
    if(a1 == 'success2'){
        alert('삭제성공');
    	
    }
    
    
    if(a1 == 'success3'){
        alert('수정성공');
    	
    }
    
    
    
    
    
    
    $(document).ready(function() {
		
    	$('#findBtn').on("click",function(e){
    	
    	
    	

    		
    		/* self.location = "/fbbs/list"+"${pagingMaker.makeURI(1)}"
    		+"&findType="+$("select option:selected").val()+"&keyword="+$("#findword").val(); */
    		
    		self.location = "/fbbs/list"+"${pagingMaker.makeURI(1)}"
    		+"&findType="+$("#findType option:selected").val()+"&keyword="+$("#findword").val();
    	
    	
    	});
    	
    	
    	$('#writeBtn').on("click",function(e){
    	
    		/* self.location = "/fbbs/list"+"${pagingMaker.makeURI(1)}"
    		+"&findType="+$("select option:selected").val()+"&keyword="+$("#findword").val(); */
    		
    		self.location = "/fbbs/write";
    	
    	
    	
    	});
    	
    	
	});
    
    
    
    
    
    
    
    
    
    
    
    
    </script>
<!--  mainEnd -->
<%@include file="../include/footer.jsp" %>
 