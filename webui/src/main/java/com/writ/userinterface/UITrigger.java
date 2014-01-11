package com.writ.userinterface;

import com.writ.domain.services.knowledge.KnowledgeProviderManager;
import com.writ.domain.services.terms.TermManager;
import com.writ.domain.services.voting.VotesManager;

public class UITrigger {

    private final TermManager termManagerService;
    private final KnowledgeProviderManager knowledgeProviderManagerService;
    private final VotesManager votesManagerService;

    public UITrigger(TermManager termManagerService, KnowledgeProviderManager knowledgeProviderManagerService, VotesManager votesManagerService) {
        this.termManagerService = termManagerService;
        this.knowledgeProviderManagerService = knowledgeProviderManagerService;
        this.votesManagerService = votesManagerService;
    }

    public TermManager getTermManagerService() {
        return termManagerService;
    }

    public KnowledgeProviderManager getKnowledgeProviderManagerService() {
        return knowledgeProviderManagerService;
    }

    public VotesManager getVotesManagerService() {
        return votesManagerService;
    }
}
