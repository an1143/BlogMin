<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

	<!-- main -->
	  <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
  
  <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
   <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 게시글 수정</h3>
        
        
        
        <!-- role는  html5에서 새롭게 추가된 속성 
        	ARIA라는 HTML 상세 규격  해당 태그에 대한 정의 
        	시각장애인이 리더기 사용하여 읽을때  여기가 폼테그라는걸 알려줌  -->
        <form role="form" method="post"> 
      
     
        </form>
        
        <!-- BASIC FORM ELELEMNTS -->
        <div class="row mt">
          <div class="col-lg-12">
            <div class="form-panel">
              <h4 class="mb"><i class="fa fa-angle-right"></i> 수정내용</h4>
              <form id="bbs_from" role="form" class="form-horizontal style-form" method="post">
               
               <input type="hidden" name="page" value="${pCri.page}"/>
               <input type="hidden" name="numPerPage" value="${pCri.numPerPage}"/>
             
                 <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">글번호</label >
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="bid_tb" value="${bbsVo.bid_tb}" readonly="readonly">
                  </div>
                </div>
              
              
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">제목</label >
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="subject" value="${bbsVo.subject}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">글내용 </label>
                  <div class="col-sm-10">
                    <textarea rows="10" cols="2" class="form-control" name="content"  >${bbsVo.content}</textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">작성자</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="writer" value="${bbsVo.writer}" >
                  </div>
                  
                  
              
        		
                  
                  
                </div>
                <div class="form-group">
               	 <div class="class= col-sm-12 " align="center">
               		<button type="button" id="btn_save" class="btn btn-primary">저장하기</button>
           			<button type="button" id = "bbs_list" class="btn btn-info">목록으로</button>
               	</div>
             	</div>	
              </form>
            </div>
          </div>
          <!-- col-lg-12-->
        </div>
        
        <script type="text/javascript">
        
        //$는 제이쿼리라는 의미
        $(document).ready(function(){
        	
        	var frmObj = $("#bbs_from");
        	//var frmObj = $("form[role='form']");
        	console.log("폼태그 입니다.");
        	
        	
    
        	
         	$("#btn_save").on("click",function(){
         	
        		frmObj.attr("action","/bbs/modifyPage");
        		frmObj.attr("method","post");
        		frmObj.submit();
        	});
        	
        	
        
        	
        	$("#bbs_list").on("click",function(){
        	    self.location ="/bbs/Pagelist?page=${pCri.page}&numPerPage=${pCri.numPerPage}";
        	  
        	}); 
        	
        	
        	
        });
        
        
        </script>
        
        
     
        <!-- /row -->
        <!-- INLINE FORM ELELEMNTS -->
  
        <!-- INPUT MESSAGES -->
    
     
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->

<!--  mainEnd -->
<%@include file="../include/footer.jsp" %>
 