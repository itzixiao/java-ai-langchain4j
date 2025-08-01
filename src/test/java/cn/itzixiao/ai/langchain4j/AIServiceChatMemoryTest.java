package cn.itzixiao.ai.langchain4j;

import cn.itzixiao.ai.langchain4j.assistant.Assistant;
import cn.itzixiao.ai.langchain4j.assistant.MemoryChatAssistant;
import cn.itzixiao.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class AIServiceChatMemoryTest {

    /**
     * ollama接入
     */
    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testChatMemory() {
        // 第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是子孝");
        ChatResponse chatResponse1 = openAiChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        // 输出大语言模型的回复
        System.out.println(aiMessage1.text());
        // 第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse chatResponse2 = openAiChatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        // 输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory2() {
        //创建chatMemory
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        //创建AIService
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(openAiChatModel)
                .chatMemory(chatMemory)
                .build();
        //调用service的接口
        String answer1 = assistant.chat("我是子孝");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }


    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testChatMemory3() {
        //调用service的接口
        String answer1 = memoryChatAssistant.chat("我是子孝");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我是谁");
        System.out.println(answer2);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory4() {
        String answer1 = separateChatAssistant.chat(1,"我是子孝");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1,"我是谁");
        System.out.println(answer2);
        String answer3 = separateChatAssistant.chat(2,"我是谁");
        System.out.println(answer3);
    }
}
