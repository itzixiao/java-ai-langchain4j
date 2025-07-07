package cn.itzixiao.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools"
)
public interface SeparateChatAssistant {

    /**
     * 分离聊天记录
     *
     * @param memoryId    聊天id
     * @param userMessage 用户消息
     * @return
     */
    @SystemMessage("你是我的好朋友，请用东北话回答问题。")//系统消息提示词
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}