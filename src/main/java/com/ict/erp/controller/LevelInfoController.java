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

	@RequestMapping(value="/levelinfo",method=RequestMethod.GET)
	public String getLevelInfoList(@ModelAttribute LevelInfo li, Model m) throws SQLException {
		m.addAttribute("liList", lis.getLevelInfoList(li));
		return "levelinfo/list";
	}

	@RequestMapping(value="/levelinfos",method=RequestMethod.GET)
	public @ResponseBody List<LevelInfo> getLevelInfoList2(@ModelAttribute LevelInfo li) throws SQLException {
		return lis.getLevelInfoList(li);
	}
	
	@RequestMapping(value="/levelinfos/{linum}",method=RequestMethod.GET)
	public @ResponseBody LevelInfo getLevelInfoList3(@ModelAttribute LevelInfo li, @PathVariable Integer linum) throws SQLException {
		li.setLinum(linum);
		return lis.getLevelInfo(li);
	}
	 @RequestMapping(value="/levelinfos/{linum}",method=RequestMethod.DELETE)
		@ResponseBody
		public Integer getLevelInfoList4(@ModelAttribute LevelInfo li, @PathVariable Integer linum) throws SQLException {
			li.setLinum(linum);
			return lis.deleteLevelInfo(linum);
		}
	 @RequestMapping(value="/levelinfos/{linum}",method=RequestMethod.PUT)
		@ResponseBody
		public Integer getLevelInfoList5(@ModelAttribute LevelInfo li, @PathVariable Integer linum) throws SQLException {
			li.setLinum(linum);
			li.setLilevel(78);
			li.setLiname("update");
			li.setLidesc("complete");
			return lis.updateLevelInfo(li);
		}

		@RequestMapping(value="/levelinfos/{linum}",method=RequestMethod.POST)
		@ResponseBody
		public Integer getLevelInfoList6(@ModelAttribute LevelInfo li, @PathVariable Integer linum) throws SQLException {
			li.setLinum(linum);
			li.setLilevel(72);
			li.setLiname("insert");
			li.setLidesc("complete");
			return lis.insertLevelInfo(li);
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
			@RequestBody LevelInfo li
			) throws SQLException {
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