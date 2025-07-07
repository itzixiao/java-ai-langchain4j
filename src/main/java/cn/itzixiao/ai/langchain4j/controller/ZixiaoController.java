package cn.itzixiao.ai.langchain4j.controller;

import cn.itzixiao.ai.langchain4j.assistant.ZixiaoAgent;
import cn.itzixiao.ai.langchain4j.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "子孝")
@RestController
@RequestMapping("/zixiao")
public class ZixiaoController {

    @Autowired
    private ZixiaoAgent zixiaoAgent;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {
        return zixiaoAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}