package cn.itzixiao.ai.langchain4j.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryChatAssistantConfig {

    @Bean
    public ChatMemory ChatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }

}
