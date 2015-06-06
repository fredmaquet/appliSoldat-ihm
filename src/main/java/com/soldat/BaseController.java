package com.soldat;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index";
	private final Locale defaultLocale = Locale.getDefault();
	private final ResourceBundle MESSAGE = ResourceBundle.getBundle("messages", defaultLocale);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		String test = MESSAGE.getString("message.hello.from.controller");

		model.addAttribute("message", test);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", "" + name);
		return VIEW_INDEX;

	}

}