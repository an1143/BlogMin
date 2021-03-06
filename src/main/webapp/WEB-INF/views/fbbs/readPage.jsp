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
        <h3><i class="fa fa-angle-right"></i> 게시글 조회!!</h3>
        
        
        
        <!-- role는  html5에서 새롭게 추가된 속성 
        	ARIA라는 HTML 상세 규격  해당 태그에 대한 정의 
        	시각장애인이 리더기 사용하여 읽을때  여기가 폼테그라는걸 알려줌  -->
        <form role="form" method="post"> 
         <input type="hidden" name="bid" value="${bbsVo.bid_tb}">
         <input type="hidden" name="page" value="${fCri.page}">
         <input type="hidden" name="numPerPage" value="${fCri.numPerPage}">
         <input type="hidden" name="findType" value="${fCri.findType}">
         <input type="hidden" name="keyword" value="${fCri.keyword}">
         
         
        </form>
        
        <!-- BASIC FORM ELELEMNTS -->
        <div class="row mt">
          <div class="col-lg-12">
            <div class="form-panel">
              <h4 class="mb"><i class="fa fa-angle-right"></i> 글쓰기 입력사항</h4>
              <form class="form-horizontal style-form" method="post">
              
             
              
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">제목</label >
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="subject" value="${bbsVo.subject}" readonly="readonly">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">글내용 </label>
                  <div class="col-sm-10">
                    <textarea rows="10" cols="2" class="form-control" name="content" readonly="readonly" >${bbsVo.content}</textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">작성자</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="writer" value="${bbsVo.writer}" readonly="readonly">
                  </div>

                  
                </div>
                <div class="form-group">
               	 <div class="class= col-sm-12 " align="center">
               		<button type="button" id="btn_modify" class="btn btn-primary">수정하기</button>
          			<button type="button" id="bbs_delete" class="btn btn-danger">삭제하기</button>
           			<button type="button" id ="bbs_list" class="btn btn-info">목록으로</button>
               	</div>
             	</div>	
              </form>
            </div>
            </div>
          <!-- col-lg-12-->
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
          <div class="row mt">
          <div class="col-lg-12">
            <div class="form-panel">
              <h4 class="mb"><i class="fa fa-angle-right"></i> 댓글</h4>
                           
                 <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">작성자</label >
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="replyer" id="writer" >
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">댓글 </label>
                  <div class="col-sm-10">
                   	<input class="form-control"  type="text" maxlength="50" size="50" name="replycontent" id="addReContent">
                  </div>
                </div> 
              <br><button class="btn btn-primary" id="submitBtn" >댓글 작성</button>       
                   
                   
                   
                  <!--  댓글이랑 페이지 목록 -->
                  <div class="form-group">  
                   <h4>댓글 리스트</h4>
					<ul id="reply">
			
					</ul>
					<ul class="pgeNumList">
					
					</ul>
                   </div>
                       
                       
                       
                                   
            </div>
            </div>
          <!-- col-lg-12-->
        </div>
        
        
        
        
        
        
 <div id="modifyDiv" style="display: none">
		
		<span class="title-dialog"></span>번 댓글

	<div>
	        수정내용 <br>
		<input type="text" id="reContent" size="65">
	</div>
	
	<div align="center">
		<button type="button" id="reModifyBtn">수정  </button>
		<button type="button" id="reDelBtn">삭제  </button>
		<button type="button" id="closeBtn">닫기  </button>
	</div>
	
</div>
        
        
        
        
        
        
        
        
        
        
        
        
        
        <script type="text/javascript">
        
        //$는 제이쿼리라는 의미
        $(document).ready(function(){
        	
        	var frmObj = $("form[role='form']");
        	//console.log("폼태그 입니다.");
        	
        	
    
        	
         	$("#btn_modify").on("click",function(){
         		
        		frmObj.attr("action","/fbbs/modifyPage");
        		frmObj.attr("method","get");
        		frmObj.submit();
        	});
        	
        	
        	$("#bbs_delete").on("click",function(){
        		//alert(" 진입");
        		frmObj.attr("action","/fbbs/delPage");
        		frmObj.attr("method","POST");
        		frmObj.submit();
        	});
        	
        
        	
        	$("#bbs_list").on("click",function(){
        	
        		
        		   
              	    //self.location ="/bbs/Pagelist"
        			frmObj.attr("method","get");
        			frmObj.attr("action","/fbbs/list");
        			frmObj.submit();
              	    
        	}); 
        	
        	
        	
        });
        
        
        </script>
        
        
        
        
        
        <script type="text/javascript">

		var bid_tb =${bbsVo.bid_tb};
		getPgeNum(1);
		
		

		function getPgeNum(page){
			$.getJSON("/replies/"+bid_tb+"/"+page, function(data){
				
			console.log(data.reList.length);
				
			
			var str = "";
			
			$(data.reList).each(function(){
				
				
				str += "<li data-rebid= '"+this.rebid+"' class='reList'>"
				 	+ this.rebid + " | " +this.replycontent
				 	+"<button>수정</button>"
					+"</li>";
				
				});
			
					showPageNum(data.pagingMaker);		
			
					$("#reply").html(str);
			});
		}//getPgeNum
		
		
		
		
		//댓글 페이지 아래 항목 
		function showPageNum(pagingMaker){
			
			var str = "";
			if(pagingMaker.prev){
				str += "<li><a href='"+(pagingMaker.startPage-1)+"'>◀</a></li>";
				
			}
			
			for(var i = pagingMaker.startPage, end = pagingMaker.endPage; i<end; i++ ){
				str += "<a href='"+i+"'><button type='button'>"+i+"</button> </a>";
			}
			
			
			if(pagingMaker.next){
				str += "<li><a href='"+(pagingMaker.endPage+1)+"'>▶</a></li>";
				
			}
		
			$(".pgeNumList").html(str);
			
			
		}//showPageNum
		
		
		
		var rePage =1;
		
		//댓글  페이지번호 클릭시 이벤트 발생      a태그 아래 버튼 이벤트가 발생하면
		$(".pgeNumList").on("click","a button", function(e){
			
		e.preventDefault();  //화면 전환이 일어나지 않도록 하는 함수
		
		              //this 는 버튼임
				     //버튼 부모 a태그 
			repage = $(this).parent().attr("href");
			
		
			getPgeNum(repage);
			
		});
		
		
		
		
		
		
		
		
		
		
		
		function reListAll(){
			
			
			$.getJSON("/replies/selectAll/"+bid_tb,function(data){
				
		/* 		console.log(data.length);
				console.log("안녕"); */
				 
				var str ="";
				
				$(data).each(function(){
					
					
					str += "<li data-rebid= '"+this.rebid+"' class='reList'>"
					 	+ this.rebid + " | " +this.replycontent
					 	+"<button>수정</button>"
						+"</li>";
					
				});
				
				
				$("#reply").html(str);
				
				
			});

		} // :ListAll
		
		
		
		
		
		$("#reply").on("click", ".reList button", function(){
			
			
			
			
			var li = $(this).parent(); /* 버튼의 부모 리스트 선택 */
			var rebid = li.attr("data-rebid");
			var replycontent = li.text();
			
			//alert( "댓글번호:"+rebid +": 수정할내용: "+ replycontent);
			$(".title-dialog").html(rebid);
			$("#reContent").val(replycontent);
			$("#modifyDiv").show("slow");
		});
		
		
		
		
		
		
		
    //쓰기
	$("#submitBtn").on("click",function(){
		
	
		
	
		
		var reWriter = $("#writer").val();
		var reContent = $("#addReContent").val();
		

		
		$.ajax({
			type: 'post',
			url: '/replies',
			headers: {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				
				
			},
			
			dataType : 'text', 
			data : JSON.stringify({
				
				bid_tb : bid_tb,
				replyer : reWriter,
				replycontent : reContent
				
			}),
			
			success : function(result) {
				if(result == "Success"){
					//alert("댓글등록 성공");
					reListAll();
				}
			}

		});
		
	});
	
	

	//삭제
	$("#reDelBtn").on("click",function(){
	
	
		var rebid = $(".title-dialog").html();
		var reContent = $("#reContent").val();
		
		console.log(rebid);
		
		$.ajax({
			
			type:'delete',
			url:'/replies/'+rebid,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
					},
			dataType: 'text',
 			
			success : function(result) {
				 console.log("result:", result);
				if(result == "Success"){
				    alert("삭제성공");
				    $("#modifyDiv").hide("slow");
				    reListAll();
				}
			} 
		
			
		});//ajax
			
	});
	
	
	//수정
	$("#reModifyBtn").on("click",function(){
	
	
		var rebid = $(".title-dialog").html();
		var reContent = $("#reContent").val();
		
		console.log(rebid);
		
		$.ajax({
			
			type:'put',
			url:'/replies/'+rebid,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
				
					},
			data : JSON.stringify({
						
						replycontent : reContent
						
					}),
			dataType: 'text',
 			
			success : function(result) {
				 console.log("result:", result);
				if(result == "Success"){
				    alert("수정성공");
				    $("#modifyDiv").hide("slow");
				    reListAll();
				}
			} 
		
			
		});//ajax
	

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
 