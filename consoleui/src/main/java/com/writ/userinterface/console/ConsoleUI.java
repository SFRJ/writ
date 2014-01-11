package com.writ.userinterface.console;

import com.writ.domain.api.KnowledgeProviderManagementService;
import com.writ.domain.api.TermManagementService;
import com.writ.domain.api.VotesManagementService;
import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.core.Term;
import com.writ.domain.services.knowledge.KnowledgeProviderManagerImpl;
import com.writ.domain.services.terms.TermManagerImpl;
import com.writ.domain.services.voting.VotesManagerImpl;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleUI implements TermManagementService,KnowledgeProviderManagementService,VotesManagementService {


    private KnowledgeProviderManagerImpl knowledgeService;
    private TermManagerImpl termsService;
    private VotesManagerImpl votesService;

    public ConsoleUI(KnowledgeProviderManagerImpl knowledgeService, TermManagerImpl termsService, VotesManagerImpl votesService) {
        this.knowledgeService = knowledgeService;
        this.termsService = termsService;
        this.votesService = votesService;
    }

    public void welcomeMenu() {
        System.out.println("What is that you want to do?:");
        System.out.println("1)Add a term:");
        System.out.println("2)Search a term");
        System.out.println("3)Edit a term");
        System.out.println("4)Delete a term");

        Scanner consoleScanner = new Scanner(System.in);
        int selection = parseInt(consoleScanner.nextLine());
        switch (selection) {
            case 1:
            {
                System.out.println("What is your name?:");
                String author = consoleScanner.nextLine();
                System.out.println("What is the term you want to add?:");
                String termName = consoleScanner.nextLine();
                System.out.println("Describe the term please:");
                String termDescription = consoleScanner.nextLine();
                Term term = new Term(termName,termDescription,author);
                if(add(term))
                    System.out.println("Succesfuly added " +  term.getName());
                else
                    System.out.println("It was not possible to add " + term.getName());

            }
            case 2: {}
            case 3: {}
            case 4: {}
        }

    }

    //TERMS
    @Override
    public boolean add(Term term) {
        return termsService.add(term);
    }

    @Override
    public Term getByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Term> getTerms() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Term> getTermsWithNameContaining(String partialString) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Term term) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

   //KNOWLEDGEPROVIDERS
    @Override
    public boolean addKnowledeProvider(KnowledgeProvider knowledgeProvider) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KnowledgeProvider getKnowledgeProvider(String nickname) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteKnowledgeProvider(String nickname) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    //VOTES
    @Override
    public void plusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void minusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
