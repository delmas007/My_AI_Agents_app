package ci.devai.my_ai_agents_app.web;

import ci.devai.my_ai_agents_app.service.MyAiAgentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ask")
public class MyAiAgentController {
    public MyAiAgentController(MyAiAgentService myAiAgentService) {
        this.myAiAgentService = myAiAgentService;
    }

    private final MyAiAgentService myAiAgentService;

    @GetMapping(value = "/{company}", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String askAgent(@PathVariable String company) {
        return myAiAgentService.askAgent(company);
    }
}
