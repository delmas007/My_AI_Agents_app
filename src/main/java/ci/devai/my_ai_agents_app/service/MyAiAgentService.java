package ci.devai.my_ai_agents_app.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class MyAiAgentService {

    private ChatClient chatClient;

    public MyAiAgentService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    String systemPrompt = """
                             Il vous sera demandé de générer un rapport financier sur une entreprise donnée
                             Votre rapport doit inclure des informations sur l'entreprise (nom, pays, domaine)
                             Votre rapport doit inclure une conclusion concise sur une analyse financière.
                             le rapport doit etre en français.
                           """;

    public String askAgent(String company) {
        return chatClient.prompt()
                .system(systemPrompt)
                .user("Company Name : " + company)
                .functions("countryIdentityInfo")
                .call().content();
    }

}
