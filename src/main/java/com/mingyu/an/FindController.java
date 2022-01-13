package com.mingyu.an;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mingyu.service.BbsService;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.PagingMaker;

@Controller
@RequestMapping("/fbbs/*")
public class FindController {

	
	private static final Logger logger = LoggerFactory.getLogger(FindController.class);
	
	
	@Inject
	private BbsService bsvc;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("fCri") FindCriteria fCri, Model model ) throws Exception {
		                                 //URI에 success가 남는데 RedirectAttributes 사용하면 한번만 전송함 
		logger.info("start!!!");
		
		//model.addAttribute("list", bsvc.listCriteria(fCri));
		model.addAttribute("list", bsvc.listFind(fCri));
		
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setpCria(fCri);
		
		//pagingMaker.setTotalData(bsvc.listCountData(fCri));
		pagingMaker.setTotalData(bsvc.findCountData(fCri));
		
		
		System.out.println(bsvc.listCountData(fCri)+"!!!!!!!!!!!!!!!!!!!");
		
		model.addAttribute("pagingMaker", pagingMaker);
		
	
		return "/fbbs/list";
	}
	
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public String read( Model model, @RequestParam("bid") int bid_tb, @ModelAttribute("fCri") FindCriteria fCri) throws Exception {
		
	
		
		 model.addAttribute(bsvc.read(bid_tb));
		 //model.addAttribute(Bvo);  //키값 입력안하면 클래의 이름을 자동으로 소문자로 시작해서 집어 넣음 bbsVo로 들어감 
		
		logger.info("write read....");
		//logger.info(bvo.toString());
		

		
		
		return "/fbbs/readPage";
	}
	 
	
	 @RequestMapping(value = "/delPage", method = RequestMethod.POST) public String
	  delete( Model model, @RequestParam("bid") int bid_tb, FindCriteria fCri, RedirectAttributes reAttr) throws Exception {
	  
	  
	  
	  bsvc.remove(bid_tb);
	  reAttr.addAttribute("page",fCri.getPage());
	  reAttr.addAttribute("numPerPage",fCri.getNumPerPage());
	  reAttr.addAttribute("findType",fCri.getFindType());
	  reAttr.addAttribute("keyword",fCri.getKeyword());
	  reAttr.addFlashAttribute("result1","success2");
	  
	  
	  
	  return "redirect:/fbbs/list"; }
	 
	 
	 
	 
		
		@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
		public void modifyGET( @RequestParam("bid") int bid_tb, @ModelAttribute("fCri") FindCriteria fCri, Model model) throws Exception {
			
			logger.info(" modifyPage....");

			model.addAttribute(bsvc.read(bid_tb));
			//model.addAttribute("pCri", fCri);

			
			
		//	return "redirect:/fbbs/list";

		}
		
		
		
		@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
		public String modifyPost(BbsVo bvo, FindCriteria fCri ,RedirectAttributes redAttr) throws Exception {
			
			logger.info(" modifyPOST....!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			bsvc.modify(bvo);
			//redAttr.addAttribute("result1", "success3");
			//redAttr.addAttribute("page", fCri.getPage());
			//redAttr.addAttribute("numPerPage", fCri.getNumPerPage());
			//redAttr.addAttribute("findType", fCri.getFindType());
			//redAttr.addAttribute("keyword", fCri.getKeyword());
			
			
			return "redirect:/fbbs/list";

		}
		
		
		@RequestMapping(value = "/write", method = RequestMethod.GET)
		public void writeGet(BbsVo vo, Model model) throws Exception {
			
			
			logger.info("write Get....");
			
			
			
			
		}
		
		@RequestMapping(value = "/write", method = RequestMethod.POST)
		public String writePost(BbsVo bvo,RedirectAttributes reAttr) throws Exception {
			                                 //URI에 success가 남는데 RedirectAttributes 사용하면 한번만 전송함 
			
			logger.info("write POST....");
			//logger.info(bvo.toString());
			
		
			bsvc.write(bvo);;
			//reAttr.addFlashAttribute("result","success"); //URI에 success가 남는데 RedirectAttributes 사용하면 한번만 전송함  내용이 안남음 
			
			reAttr.addFlashAttribute("result1","success");
			
			//리다이렉트는 웹브라우저를 간후  다시 컨트롤로 돌아옴 돌아올때 get형식 
			return "redirect:/fbbs/list";
		}
	
	
	
}
