package ci.devai.my_ai_agents_app.tools;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("financialDataTool")
@Description("""
        Obtenez des données financières sur l'entreprise, notamment :
        - Le chiffre d'affaires des 3 dernières années
        - Le bénéfice des 3 dernières années
        - La valeur de l'action au cours des 7 derniers jours
        """)
public class FinancialDataTool implements Function<FinancialDataTool.Request, FinancialDataTool.Response> {
    public record Request(String companyName){};
    public record Response(
            double [] turnover,
            double [] profit,
            double [] stock ){}

    @Override
    public Response apply(Request request) {
        System.out.println("financialDataTool invocation  company => "+request.companyName);
        return new Response(
                new double[]{1000000,2000000,3000000},
                new double[]{10000,20000,30000},
                new double[]{450,460,480,480, 320,340,250}
        );
    }
}
