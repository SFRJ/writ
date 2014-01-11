package com.writ.integration;

import com.writ.domain.services.HexagonalArchitectureService;
import com.writ.domain.services.knowledge.KnowledgeProviderManager;
import com.writ.domain.services.knowledge.KnowledgeProviderManagerImpl;
import com.writ.domain.services.terms.TermManager;
import com.writ.domain.services.terms.TermManagerImpl;
import com.writ.domain.services.voting.VotesManager;
import com.writ.domain.services.voting.VotesManagerImpl;
import com.writ.persistence.filesystem.knowledgeproviders.KnowledgeProvidersInMemoryStorage;
import com.writ.persistence.filesystem.terms.TermsInMemoryStorage;
import com.writ.persistence.filesystem.votes.VotesInMemoryStorage;

public class WritAssembler {

    //Services offered by domain
    private TermManager termManager;
    private VotesManager votesManager;
    private KnowledgeProviderManager knowledgeProviderManager;

    public void assembly() {
        //Preparing adapters for file system persistence
        enableFilePersistenceAtServices();
        enableWebInterfaceForTheServices(termManager,votesManager,knowledgeProviderManager);
    }

    private void enableFilePersistenceAtServices() {
        termManager =  new TermManagerImpl(new TermsInMemoryStorage());
        votesManager = new VotesManagerImpl(new VotesInMemoryStorage());
        knowledgeProviderManager = new KnowledgeProviderManagerImpl(new KnowledgeProvidersInMemoryStorage());
    }

    private void enableWebInterfaceForTheServices(HexagonalArchitectureService... services) {
    }

}
