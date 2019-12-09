package lift.majiang.community.community.controller;

import lift.majiang.community.community.dto.AccessTokenDTO;
import lift.majiang.community.community.dto.GithubUser;
import lift.majiang.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthorizeControllor {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state") String state) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
//        githubProvider.getAccessToken(accessTokenDTO);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("Iv1.2cb5d517226208e9");
        accessTokenDTO.setClient_secret("c915c55d381468bcc63f709edf2cea85080e5d82");
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser guser = githubProvider.getUser(accessToken);
        System.out.println("githubuser=:"+guser);
        return "index";

    }
}
