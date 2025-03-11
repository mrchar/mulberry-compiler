package com.example.compiler;

import org.springframework.ai.ResourceUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CompilerService {
  private final ChatClient chatClient;

  public CompilerService(ChatClient.Builder clientBuilder) {
    this.chatClient =
        clientBuilder.defaultSystem(ResourceUtils.getText("classpath:./system-prompt.md")).build();
  }

  public Flux<String> compile(String input) {
    return this.chatClient.prompt().user(input).stream().content();
  }

  public String syncCompile(String input) {
    return this.chatClient.prompt().user(input).call().content();
  }
}
