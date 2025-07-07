package cn.itzixiao.ai.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT, chatModel = "ollamaChatModel")
public interface Assistant {

    String chat(String message);

}
