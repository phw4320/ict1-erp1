/*package com.ict.erp.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;

@Controller
public class LevelInfoController {

	@Autowired
	private LevelInfoService lis;
	private UriController uc;
	
	
	@RequestMapping(value="/levelinfo", method=RequestMethod.GET)
	public String getLevelInfoList(@RequestParam("linum") String linum, Model m) throws SQLException {
	public String getLevelInfoList(@ModelAttribute LevelInfo li, Model m) throws SQLException {
		System.out.println(li);
		System.out.println(m.toString());
		if(li.getLiname()==null) {
			m.addAttribute("liList", lis.getLevelInfoList(null));
		} else {
			m.addAttribute("liList", lis.getLevelInfo(li));
		}
		return "levelinfo/list";
	}
	
	@RequestMapping(value="/levelinfo2", method=RequestMethod.GET)
	public ModelAndView getLevelInfoList2(@ModelAttribute LevelInfo li, ModelAndView mav) throws SQLException {
		mav.setViewName("levelInfo/list");
		mav.addObject("liList", lis.getLevelInfo(li));
		return mav;
	}
	
	
	@RequestMapping(value="/levelinfo", method=RequestMethod.POST)
	public String insertLevelInfoList(@ModelAttribute LevelInfo li, Model m) throws SQLException {
			m.addAttribute("li", lis.insertLevelInfo(li));
		return "levelinfo/list";
	}
	
	@RequestMapping(value="/levelinfo/{path}", method=RequestMethod.POST)
	public String updateLevelInfoList(@ModelAttribute LevelInfo li, Model m) throws SQLException {
			m.addAttribute("li", lis.updateLevelInfo(li));
		return "levelinfo/list";
	}
	
	@RequestMapping(value="/levelinfo", method=RequestMethod.DELETE)
	public String deleteLevelInfoList(@ModelAttribute LevelInfo li, Model m) throws SQLException {
			m.addAttribute("li", lis.deleteLevelInfo(li));
		return "levelinfo/list";
	}
}
*/

package com.ict.erp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;

@Controller
public class LevelInfoController {

	@Autowired
	private LevelInfoService lis;

	/*@RequestMapping(value="/levelinfo",method=RequestMethod.GET)
	public String getLevelInfoList(
			 @ModelAttribute LevelInfo li,
			Model m) throws SQLException {
		m.addAttribute("liList", lis.getLevelInfoList(li));
		return "levelinfo/list";
	}*/
	
	
	@RequestMapping(value="/levelinfo",method=RequestMethod.GET)
	public @ResponseBody List<LevelInfo> getLevelInfoList(@ModelAttribute LevelInfo li) throws SQLException {
		return lis.getLevelInfoList(li);
	}
	
	@RequestMapping(value="/levelinfo/{liname}",method=RequestMethod.GET)
	public String getLevelInfo(
			 @ModelAttribute LevelInfo li,
			Model m) throws SQLException {
		m.addAttribute("liList", lis.getLevelInfo(li));
		return "levelinfo/list";
	}
	

	@RequestMapping(value="/levelinfo",method=RequestMethod.POST)
	@ResponseBody 
	public Integer insertLevelInfoList(
			@RequestBody LevelInfo li,
			Model m) throws SQLException {
		m.addAttribute("iCnt", lis.insertLevelInfo(li));
		System.out.println(li);
		return lis.insertLevelInfo(li); 
	}
	
	@RequestMapping(value="/levelinfo/{linum}",method=RequestMethod.PUT)
	@ResponseBody 
	public Integer updateLevelInfoList(@RequestBody LevelInfo li, @PathVariable Integer linum) throws SQLException {
		System.out.println(li);
		/*ObjectMapper m = new ObjectMapper();
		m.readValue(src, valueType)*/
		li.setLinum(linum);
		
		return lis.updateLevelInfo(li);
	}
	

	@RequestMapping(value="/levelinfo/{linum}",method=RequestMethod.DELETE)
	@ResponseBody 
	public String deleteLevelInfoList(
			@PathVariable int linum) throws SQLException {

		return lis.deleteLevelInfo(linum)+""; 
	}
	
	@RequestMapping(value="/levelinfo2",method=RequestMethod.POST)
	
	public @ResponseBody List<LevelInfo> getLevelInfoList1(@RequestBody LevelInfo li) throws SQLException {
		System.out.println(li);
		return lis.getLevelInfoList(li);
	}


}