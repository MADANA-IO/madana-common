package de.digiclothes.server.web.spring;

import de.digiclothes.server.ConnectorCommunicationServiceDummy;
import de.digiclothes.server.DC_ServerSessionManager;
import de.digiclothes.server.ifc.ConnectorCommunicationService;
import de.digiclothes.server.ifc.ConnectorDescription;
import de.digiclothes.server.object.DC_Shop;
import de.madana.common.datastructures.ShoppingCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@EnableAutoConfiguration
public class SampleController {

	private ConnectorCommunicationService connectorCommunicationService;

	public SampleController() {
		// TODO inject dependency and let Spring do the wiring
		this.connectorCommunicationService = new ConnectorCommunicationServiceDummy();
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		// TODO: Use a template instead of writing HTML here
		return "<a href='/web/connectors'>Active Connectors</a>";
	}
	@RequestMapping("/home")
	String newhome() {
		// TODO: Use a template instead of writing HTML here
		return "WEB-INF/views/home.jsp";

	}
	@RequestMapping("/welcome2")
	public ModelAndView helloWorld() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	@RequestMapping("/hello")
	public String hello(Model model) 
	{
		model.addAttribute("greeting", "Hello Spring MVC");
		return "helloworld";
	}
	@RequestMapping(path = "/web/checkout/{connectorId}")
	@ResponseBody
	ShoppingCart initiateShoppingCartCheckout(@PathVariable String connectorId) {
		try {
			// TODO Don't block the execution here, but call the client when the result is ready
			return connectorCommunicationService.askForShoppingCart(connectorId).get().orElse(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/web/connectors")
	@ResponseBody
	List<DC_Shop> connectors() {
		// For now just pipe out the list (is converted to JSON by spring)
		// TODO: Use a template instead of writing HTML here
		return DC_ServerSessionManager.getConnectedShops();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}