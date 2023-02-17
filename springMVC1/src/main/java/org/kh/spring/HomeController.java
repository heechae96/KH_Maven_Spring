package org.kh.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public String home() {
		
		// DB에서 가져온 값을
		// model에 addAtrribute를 해주면
		// MAIN화면으로 사용이 가능
		return "home";
	}
	
}
