package lift.majiang.community.community.provider;

        import lift.majiang.community.community.dto.AsseccTokenDTO;
        import okhttp3.*;
        import org.springframework.stereotype.Component;

        import java.io.IOException;

@Component//注解不用new对象
public class GithubProvider {
    public String getAccessToken(AsseccTokenDTO asseccTokenDTO) throws IOException {
      MediaType JSON
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
           String string= response.body().string();
           System.out.println(string);
           return string;
        }
        return null;
    }
}
