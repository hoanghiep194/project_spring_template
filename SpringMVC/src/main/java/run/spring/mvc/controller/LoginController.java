package run.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import run.spring.mvc.dto.UserDto;
import run.spring.mvc.services.LoginService;


@Controller
@SessionAttributes("user")

public class LoginController {

    @Autowired
    private LoginService loginService;

    private static final Logger logger = Logger.getLogger(LoginController.class);

    private List<String> list = new ArrayList<>();

    @ModelAttribute("user")
    public UserDto setUser() {
       return new UserDto();
    }

//    @ModelAttribute("user")
//    public UserDto getUser() {
//        return new UserDto();
//
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user1") UserDto user, Model model) throws Exception {
        ModelAndView modelView = new ModelAndView("welcome");

        List<UserDto> result = loginService.login(user);
        model.addAttribute("user", result.get(0));
        return modelView;
    }
//    @RequestMapping("/welcome")
//    public ModelAndView helloWorld() {
//
////        String message = "<br><div style='text-align:center;'>"
////                + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
////        return new ModelAndView("welcome", "message", message);
//
////        list = getList();
//        ModelAndView model = new ModelAndView("welcome");
//        model.addObject("lists", list);
//
//        return model;
//    }
//
//    private List<String> getList() {
//
//        List<String> list = new ArrayList<String>();
//        list.add("Java");
//        list.add("C++");
//        list.add("PHP");
//
//        return list;
//
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addBooks(@ModelAttribute("book") Books book) {
//
//        logger.info("1111111111111");
//        String booksName = book.getBooksName();
//        logger.info("2222222222222 " + booksName);
//
//        logger.info("3333333333333 " + book.getSession());
//
//        book.getSession().add(booksName);
//        logger.info("444444444444 " + book.getSession());
//        ModelAndView model = new ModelAndView("welcome");
//        model.addObject("lists", book.getSession());
//
//        return model;
//    }
//
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView userInfo(@SessionAttribute("user") UserDto user) {

//        UserDto user = (UserDto) model.asMap().get("user");
        System.out.println("UserName : " + user.getUserName());
        System.out.println("Password : " + user.getPassWord());

        ModelAndView modelview = new ModelAndView("welcome");
        modelview.addObject("username", user.getUserName());

       return modelview;
    }
}
