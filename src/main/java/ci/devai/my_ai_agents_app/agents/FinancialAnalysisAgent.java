package ci.devai.my_ai_agents_app.agents;

import ci.devai.my_ai_agents_app.annotations.AiAgent;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.ai.chat.client.ChatClient;

import java.util.Objects;

@BrowserCallable
@AnonymousAllowed
@AiAgent
public class FinancialAnalysisAgent {
    private ChatClient chatClient;

    String systemPrompt = """
             Il vous sera demandé de générer un rapport financier sur une entreprise donnée
             Votre rapport doit inclure des informations sur l'entreprise (nom, pays, domaine)
             Votre rapport doit inclure une conclusion concise sur une analyse financière.
             le rapport doit etre en français.
            """;

    private String[] tools= new String[]{
            "countryIdentityInfo","financialDataTool","additionalFinancialInfos"
    };

    public FinancialAnalysisAgent(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultSystem(systemPrompt)
                .defaultFunctions(tools)
                .build();
    }

    public String financialAnalysisReport(String companyName){
        return Objects.requireNonNull(chatClient.prompt()
                .user("Company Name : " + companyName)
                .call().content());
    }
}
