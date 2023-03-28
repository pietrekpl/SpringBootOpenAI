package com.example.springbootopenai.chatGpt.service;


import com.example.springbootopenai.chatGpt.config.OpenAIChatConfiguration;
import com.example.springbootopenai.chatGpt.model.ChatGptRequest;
import com.example.springbootopenai.chatGpt.model.ChatGptResponse;
import com.example.springbootopenai.chatGpt.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BotService {
    private final OpenAIChatConfiguration chatConfiguration;
    private final static RestTemplate restTemplate = new RestTemplate();

    public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatGptRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(chatConfiguration.getMediaType()));
        headers.add(chatConfiguration.getAuthorization(), chatConfiguration.getBearer() + chatConfiguration.getApiKey());
        return new HttpEntity<>(chatGptRequest, headers);
    }

    public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatGptRequestHttpEntity) {
        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                chatConfiguration.getUrl(),
                chatGptRequestHttpEntity,
                ChatGptResponse.class
        );
        return responseEntity.getBody();
    }

    public ChatGptResponse askQuestion(UserResponse userResponse) {
        return this.getResponse(this.buildHttpEntity(
                new ChatGptRequest(
                        chatConfiguration.getChatModel(),
                        userResponse.getMessage(),
                        chatConfiguration.getMaxTokens(),
                        chatConfiguration.getTemperate(),
                        chatConfiguration.getTopP()
                )
        ));
    }

}
