package lift.majiang.community.community.controller;

import lift.majiang.community.community.dto.AsseccTokenDTO;
import lift.majiang.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthorizeControllor {
    @Autowired
     private GithubProvider githubProvider;
    @GetMapping("/callback")
public String callback(@RequestParam(name="code")String code,
            @RequestParam(name="name") String state) throws IOException {
        AsseccTokenDTO asseccTokenDTO = new AsseccTokenDTO();
        githubProvider.getAccessToken(asseccTokenDTO);
        asseccTokenDTO.setCode("code");
        asseccTokenDTO.setClient_id("Iv1.2cb5d517226208e9");
        asseccTokenDTO.setClient_secret("c915c55d381468bcc63f709edf2cea85080e5d82");
        asseccTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        asseccTokenDTO.setState(state);
        githubProvider.getAccessToken(asseccTokenDTO);

    return "index";

}
}
