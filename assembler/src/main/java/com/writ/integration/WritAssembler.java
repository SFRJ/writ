package com.writ.integration;

import com.writ.domain.services.knowledge.KnowledgeProviderManagerImpl;
import com.writ.domain.services.terms.TermManagerImpl;
import com.writ.domain.services.voting.VotesManagerImpl;
import com.writ.persistence.filesystem.knowledgeproviders.KnowledgeProvidersInMemoryStorage;
import com.writ.persistence.filesystem.terms.TermsInMemoryStorage;
import com.writ.persistence.filesystem.votes.VotesInMemoryStorage;
import com.writ.userinterface.console.ConsoleUI;


public class WritAssembler {

    public void assembly() {
        consoleInterfaceAndFilePersistence();
    }


    private void consoleInterfaceAndFilePersistence() {
        ConsoleUI consoleUI = new ConsoleUI(
                new KnowledgeProviderManagerImpl(
                        new KnowledgeProvidersInMemoryStorage()
                ),
                new TermManagerImpl(
                        new TermsInMemoryStorage()
                ),
                new VotesManagerImpl(
                        new VotesInMemoryStorage()
                )
        );
        consoleUI.welcomeMenu();//This is what starts the application
    }

}
