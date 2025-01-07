import "bootstrap/dist/css/bootstrap.min.css";
import { Button, TextField } from "@vaadin/react-components";
import { useState } from "react";
import Markdown from "react-markdown";
import { FinancialAnalysisAgent } from "Frontend/generated/endpoints";

export default function Index() {
    const [company, setCompany] = useState<string>("");
    const [response, setResponse] = useState<string>("");
    const [loading, setLoading] = useState<boolean>(false);

    async function askAgent() {
        setLoading(true);
        try {
            const resp = await FinancialAnalysisAgent.financialAnalysisReport(company);
            setResponse(resp);
        } catch (error) {
            console.error("Erreur lors de la récupération du rapport:", error);
            setResponse("Une erreur s'est produite lors de la récupération du rapport.");
        } finally {
            setLoading(false);
        }
    }

    return (
        <div className="container py-5">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <h2 className="text-center mb-4">Agent d'analyse financière</h2>
                    <div className="card shadow-sm p-4">
                        <div className="mb-3">
                            <TextField
                                style={{ width: '100%' }}
                                onChange={(e) => setCompany(e.target.value)}
                                value={company}
                                placeholder="Entrez le nom de l'entreprise"
                                label="Nom de l'entreprise"
                            />
                        </div>
                        <div className="text-center">
                            <Button
                                onClick={askAgent}
                                theme={"primary"}
                                className="btn btn-primary"
                                disabled={loading}
                            >
                                {loading ? "Chargement..." : "Demander à l'agent"}
                            </Button>
                        </div>
                    </div>
                    <div className="mt-4">
                        <h4>Réponse</h4>
                        <div className="border p-3 rounded bg-light">
                            <Markdown>
                                {response || "Aucune réponse pour le moment. Veuillez saisir le nom d'une entreprise et cliquer sur « Demander à l'agent »."}
                            </Markdown>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
