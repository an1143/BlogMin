package com.mingyu.an;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mingyu.service.ReplySvc;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.PagingMaker;
import com.mingyu.vo.ReplyVo;

@RestController
@RequestMapping("/replies")
public class ReplyController {

		@Inject
		private ReplySvc rsvc;
		
		
		
		//ResponseEntity 은 http 상태 코드  @RequestBody 은 전송된 데이터를 객체로 변환 시켜줌 
		@RequestMapping(value = "", method = RequestMethod.POST)
		public ResponseEntity<String> input(@RequestBody ReplyVo rvo){
			
			
			System.out.println("ResponseEntity Start"+rvo.getBid_tb()+rvo.getReplycontent()+rvo.getReplyer());
			
			ResponseEntity<String> resEntity = null;
			
			//sql문은 예외처리가 필요함 
			try {
				rsvc.inputReply(rvo);
				resEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
			
			return resEntity;
			
		}
		
		
		@RequestMapping(value = "/selectAll/{bid_tb}", method = RequestMethod.GET)
		public ResponseEntity<List<ReplyVo>> list(@PathVariable("bid_tb") Integer bid_tb){
			
			
			System.out.println("list Start"+bid_tb);
			
			ResponseEntity<List<ReplyVo>> resEntity = null;
			
			//sql문은 예외처리가 필요함 
			try {
				
				resEntity = new ResponseEntity<>(rsvc.replyList(bid_tb),HttpStatus.OK);
				List<ReplyVo> a 	= resEntity.getBody();
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			
		 
		 
		
			
			return resEntity;
			
		}
		
		
		@RequestMapping(value = "/{rebid}", method = {RequestMethod.PUT, RequestMethod.PATCH })
		public ResponseEntity<String> modify(@PathVariable("rebid") Integer rebid, @RequestBody ReplyVo rvo){
			
			
			System.out.println("modify");
			
			ResponseEntity<String> resEntity = null;
			
			
			
			
			//sql문은 예외처리가 필요함 
			try {
				rvo.setRebid(rebid);
				rsvc.modifyReply(rvo);
				resEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resEntity = new ResponseEntity<String>(e.getMessage() ,HttpStatus.BAD_REQUEST);
			}
			
			return resEntity;
			
		}
		
		
		
		@RequestMapping(value = "/{rebid}", method = {RequestMethod.DELETE})
		public ResponseEntity<String> reDel(@PathVariable("rebid") Integer rebid){
			
			
			System.out.println("reDel");
			
			ResponseEntity<String> resEntity = null;
			
			
			
			
			//sql문은 예외처리가 필요함 
			try {
		
				rsvc.delReply(rebid);
				resEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
			
			return resEntity;
			
		}
		
		
		
		@RequestMapping(value = "/{bid_tb}/{page}", method = {RequestMethod.GET })
		public ResponseEntity<Map<String,Object>> reListPage(@PathVariable("bid_tb") Integer bid_tb, @PathVariable("page") Integer page){
			
			
			System.out.println("reListPage!!"+bid_tb+", "+page);
		
			
			ResponseEntity<Map<String, Object>> resEntity = null;
			
			
			
			try {
				
				PageCriteria pCri = new PageCriteria();
				pCri.setPage(page);
				
				
				PagingMaker pagingMaker = new PagingMaker();
				pagingMaker.setpCria(pCri);

				
			
				
				Map<String, Object> reMap = new HashMap<String, Object>();
				
				
				System.out.println(pCri.getStrPage()+"and" + pCri.getEndPage());
				List<ReplyVo> reList = rsvc.reListPage(bid_tb, pCri);
				
	
				
				
				//System.out.println(rvo.getBid_tb()+"내용");
				
				reMap.put("reList", reList);
				
		
				
				int reCount = rsvc.reCount(bid_tb);
				pagingMaker.setTotalData(reCount);
				
				reMap.put("pagingMaker", pagingMaker);
				
				
				
				
				
				resEntity = new ResponseEntity<Map<String,Object>>(reMap,HttpStatus.OK);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				resEntity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			}
			
			
			
			

			return resEntity;
			
		}
		
		
		
	
}
