package cn.itzixiao.ai.langchain4j;

import cn.itzixiao.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {

    /**
     * ollama接入
     */
    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, ollamaChatModel);
        String result = assistant.chat("请写一个关于机器学习的小文章");
        System.out.println(result);
    }

    @Autowired
    private Assistant assistant;

    @Test
    public void testChat2() {
        String result = assistant.chat("请写一个关于机器学习和小文章");
        System.out.println(result);
    }

}
