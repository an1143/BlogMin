package com.mingyu.an;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mingyu.service.BbsService;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.PagingMaker;

@Controller
@RequestMapping("/bbs/*")
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	
	@Inject
	private BbsService bsvc;
	
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void writeGet(BbsVo vo, Model model) throws Exception {
		
		
		logger.info("write Get....   ");
		
		
		
		
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
		return "redirect:/bbs/list";
	}
	
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public String list( Model model) throws Exception {
		
		
		
		List<BbsVo> list = bsvc.list();
	
		model.addAttribute("list", list);
		
		logger.info(" List....");
		//logger.info(bvo.toString());
		

		
		
		return "/bbs/list";
	}
	

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public String read( Model model, @RequestParam("bid") int bid_tb, @ModelAttribute("pCri") PageCriteria pCri) throws Exception {
		
	
		
		 model.addAttribute(bsvc.read(bid_tb));
		 //model.addAttribute(Bvo);  //키값 입력안하면 클래의 이름을 자동으로 소문자로 시작해서 집어 넣음 bbsVo로 들어감 
		
		logger.info("write read....");
		//logger.info(bvo.toString());
		

		
		
		return "/bbs/readPage";
	}
	 
	
	
	/*
	 * @RequestMapping(value = "/delete", method = RequestMethod.POST) public String
	 * delete( Model model, @RequestParam("bid") int bid_tb, RedirectAttributes
	 * redAttr) throws Exception {
	 * 
	 * 
	 * logger.info(" delete...."); redAttr.addFlashAttribute("result1", "success2");
	 * bsvc.remove(bid_tb);
	 * 
	 * 
	 * 
	 * 
	 * return "redirect:/bbs/list"; }
	 */
	
	
	  @RequestMapping(value = "/delPage", method = RequestMethod.GET) public String
	  delete( Model model, @RequestParam("bid") int bid_tb, PageCriteria pCri, RedirectAttributes reAttr) throws Exception {
	  
	  
	  
	  bsvc.remove(bid_tb);
	  reAttr.addAttribute("page",pCri.getPage());
	  reAttr.addAttribute("numPerPage",pCri.getNumPerPage());
	  reAttr.addFlashAttribute("result1","success2");
	  
	  
	  
	  return "redirect:/bbs/pageList"; }
	 
	
	
	
//	@RequestMapping(value = "/modify", method = RequestMethod.GET)
//	public void modifyGET( Model model, int bid) throws Exception {
//		
//		logger.info(" modifyGET....");
//		model.addAttribute(bsvc.read(bid));
//
//	}
	
	
//	@RequestMapping(value = "/modify", method = RequestMethod.POST)
//	public String modifyPOST( Model model, BbsVo bbsVo, RedirectAttributes redAttr) throws Exception {
//		
//		logger.info(" modifyPOST....");
//		bsvc.modify(bbsVo);
//		redAttr.addAttribute("result1", "success3");
//		
//		return "redirect:/bbs/list";
//
//	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPage( @RequestParam("bid") int bid_tb, @ModelAttribute("pCri") PageCriteria pCri, Model model) throws Exception {
		
		logger.info(" modifyPage....");

		model.addAttribute(bsvc.read(bid_tb));
		
	//	return "redirect:/bbs/list";

	}
	
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPage( BbsVo bbsVo, PageCriteria pCri ,RedirectAttributes redAttr) throws Exception {
		
		logger.info(" modifyPOST....");
		bsvc.modify(bbsVo);
		redAttr.addAttribute("result1", "success3");
		redAttr.addAttribute("page", pCri.getPage());
		redAttr.addAttribute("numPerPage", pCri.getNumPerPage());
		
		
		return "redirect:/bbs/pageList";

	}
	
	@RequestMapping(value = "/pageList", method = {RequestMethod.GET})
	public String pageList( Model model, PageCriteria pCria) throws Exception {
		
		logger.info(" pageList...."+pCria.getPage());
		//logger.info(bvo.toString());
		
		
	
		model.addAttribute("list", bsvc.listCriteria(pCria));
		PagingMaker pageingMaker = new PagingMaker();
		pageingMaker.setpCria(pCria);
		pageingMaker.setTotalData(bsvc.totalData());
		
		
		logger.info(pageingMaker.getStartPage()+"getStartPage");
		logger.info(pageingMaker.getEndPage()+"getEndPage");
		
		
		
		
	
		
		model.addAttribute("pagingMaker", pageingMaker);
		
		return "/bbs/pageList";
	}
	
	
	
	
}
