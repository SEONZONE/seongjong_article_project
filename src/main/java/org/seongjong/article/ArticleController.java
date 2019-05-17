package org.seongjong.article;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;


	static final Logger logger = LogManager.getLogger();
	
	@RequestMapping("/register")
	public String registerForm() {
		
		return "register";
	}
	
	@PostMapping("/articlelist")
	public String registerComplete(Article article, 
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model){
		
		articleDao.insert(article);
		// 페이지 당 가져오는 행의 수
				final int COUNT = 100;
				// 시작점
				int offset = (page - 1) * COUNT;

				List<Article> articleList = articleDao.selectAll(offset, COUNT);

				int totalCount = articleDao.countAll();

				model.addAttribute("totalCount", totalCount);
				model.addAttribute("articlelist", articleList);
				return "articlelist";
		
	}
	

	

	@GetMapping("/articlelist")
	public String articlelist(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articlelist", articleList);
		return "articlelist";
	}
	
		@RequestMapping(value ="/content", method=RequestMethod.GET)
	    public String content(
	    		@RequestParam("articleId") int articleId, 
	    		Model model )  {
	
		 	Article article = articleDao.getBoard(articleId);
		 	model.addAttribute("article", article);
		 	return "content";
	 }
}