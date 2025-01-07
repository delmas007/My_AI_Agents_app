package ci.devai.my_ai_agents_app.tools;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("additionalFinancialInfos")
@Description("""
       Obtenez des informations financières supplémentaires sur l'entreprise au cours des dernières années
        """)
public class AdditionalFinancialInfos implements Function<AdditionalFinancialInfos.Request, AdditionalFinancialInfos.Response> {
    public record Request(String companyName){};
    public record Response(String additionalFinancialInfos){};

    @Override
    public Response apply(Request request) {
        System.out.println("AdditionalFinancialInfos Tool => Company "+request.companyName);
        return new Response("Le nombre de demande dans la technologie est en forte hausse depuis quelques années");
    }
}
