package com.magti.x509.rest;
import com.magti.x509.rest.resources.ResultObj;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by zviad on 5/20/18.
 * simple controller
 */
@RestController
@RequestMapping("simple")
public class SimpleController {
    Logger logger = Logger.getLogger(SimpleController.class);

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ResultObj sayHello(@RequestParam(name = "name") String userName, Principal principal) {
        String currentUserName = "";
        logger.info(principal);
        if (principal != null) {
            UserDetails currentUser
                    = (UserDetails) ((Authentication) principal).getPrincipal();
            currentUserName = currentUser.getUsername();
        }
        ResultObj res = new ResultObj(0L, "Hello " + userName +
                " you are pitalo" + " certified user=" + currentUserName);
        logger.info(res);
        return res;
    }

}
