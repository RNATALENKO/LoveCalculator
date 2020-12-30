package globaldemo;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lovecalc.methodlevelmodel.infoDto;


//This class holds handlers that will be available to all controllers

@ControllerAdvice
public class GlobalDemo {
	
	//exception anywhere in any controller
	@ExceptionHandler(value = Exception.class)
	public String handleAnyException() {
		return "nullpointerexception";
	}
	
	//an infodate model available for every controller/handler method
	@ModelAttribute("info")
	public infoDto setupInfoDto() {
		infoDto info = new infoDto();
		//set data here
		return info;
	}
	
	//for every controller, create and register a form editor
	//so this executes for every controller before handlers get executed
	@InitBinder
	public void dateBinder(WebDataBinder binder) {
		
		//parse date formats and register editor
		
		/*SimpleDateFormate, CustomeDateEditor, Binder etc...
		 * binder.registerCustomEdtor()
		 */
		
	}

}
