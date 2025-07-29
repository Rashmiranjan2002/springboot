package com.springweb.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springweb.dto.RashmiDto;
import com.springweb.entity.RashmiEntity;
//import com.springweb.entity.AddressEntity;
//import com.springweb.entity.RashmiEntity;
import com.springweb.service.RashmiService;

@Controller
public class RashmiController {
private static final Logger logger=LoggerFactory.getLogger(RashmiController.class);
@Autowired
		private RashmiService rashmiService;
		@RequestMapping("/view")
		public String viewRegisterEmp() {
			return "rashmi";
		}
//@RequestMapping("/saveReg")
//		public String createreg(RashmiEntity rashmiEntity ) {
//	 rashmiService.saveDetails(rashmiEntity);
//System.out.println("record saved successfully");
//			return "rashmi";
//		}
@RequestMapping("/saveReg")
public String getRegistrationData(@ModelAttribute RashmiDto rashmiDto, Model model) {
	logger.info(" recived in comeing data :{}",rashmiDto);
	   try {
           rashmiService.saveEmployeeDetails(rashmiDto);
           logger.info("Employee data saved successfully.");
           model.addAttribute("msg", "Record is saved");
       } catch (Exception e) {
           logger.error("Error saving employee data", e); // logs error with stack trace
           model.addAttribute("msg", "Something went wrong");
       }
       return "rashmi";
}

		
}
