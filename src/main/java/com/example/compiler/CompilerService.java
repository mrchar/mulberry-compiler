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
    // 接收到代码后，你需要先检查程序是否有错误，如果有错误则返回错误的错误的片段并说明原因；
    // 如果代码中没有错误，则直接输出编译后的Java代码，变异后的代码写在main方法中，不要包含任何其他信息。
    return this.chatClient
        .prompt()
        .user(
            u -> u.text(ResourceUtils.getText("classpath:./user-prompt.md")).param("input", input))
        .stream()
        .content();
  }

  public String syncCompile(String input) {
    return this.chatClient
        .prompt()
        .user(
            u -> u.text(ResourceUtils.getText("classpath:./user-prompt.md")).param("input", input))
        .call()
        .content();
  }
}
