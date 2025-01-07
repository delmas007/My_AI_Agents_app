package ci.devai.my_ai_agents_app.tools;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("countryIdentityInfo")
@Description("""
        obtenir des informations d'identité sur une entreprise donnée, notamment:
        - le nom de l'entreprise 
        - le pays de l'entreprise
        - le domaine d'activité de l'entreprise
        - l'année de création de l'entreprise
        """)
public class CountryIdentityInfo implements Function<CountryIdentityInfo.Request, CountryIdentityInfo.Response> {

    public record Request(String companyName){};
    public record Response(String companyName, String country, String industryDomaine, int foundedYear){};

    @Override
    public Response apply(Request request) {
        System.out.println("======== countryIdentityInfo ==== Company = "+request.companyName());
        return new Response(request.companyName(), "Côte d'Ivoire", "Technologie",2015);
    }

}
