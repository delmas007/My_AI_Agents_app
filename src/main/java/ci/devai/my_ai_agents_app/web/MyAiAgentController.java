package ci.devai.my_ai_agents_app.web;

import ci.devai.my_ai_agents_app.agents.FinancialAnalysisAgent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ask")
public class MyAiAgentController {
    public MyAiAgentController(FinancialAnalysisAgent financialAnalysisAgent) {
        this.financialAnalysisAgent = financialAnalysisAgent;
    }

    private final FinancialAnalysisAgent financialAnalysisAgent;

    @GetMapping(value = "/{company}", produces = MediaType.TEXT_MARKDOWN_VALUE)
    public String askAgent(@PathVariable String company) {
        return financialAnalysisAgent.financialAnalysisReport(company);
    }
}
