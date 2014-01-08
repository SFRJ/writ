package com.writ.persistence.filesystem.votes;//import static main.java.com.djordje.apps.dataaccess.inmemory.votes.VoteValidator.canCastAVote;

import com.writ.domain.api.VotesManagementService;
import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.core.Term;
import com.writ.domain.core.errors.AlreadyVotedOnThatTermException;
import com.writ.persistence.filesystem.knowledgeproviders.KnowledgeProvidersInMemoryStorage;
import com.writ.persistence.filesystem.terms.TermsInMemoryStorage;

import static com.writ.persistence.filesystem.votes.VoteValidator.canCastAVote;

public class VotesInMemoryStorage implements VotesManagementService {

    //Will use this to update the votes
    private KnowledgeProvidersInMemoryStorage knowledgeProvidersInMemoryStorage = new KnowledgeProvidersInMemoryStorage();
    private TermsInMemoryStorage termsInMemoryStorage =  new TermsInMemoryStorage();

    @Override
    public void plusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider) {
        if(canCastAVote(knowledgeProvider, sampleTerm.getName())) {
            addAVoteToTerm(getTermByName(sampleTerm));
            addTermToListOfVotedTermsByKnowledProvider(knowledgeProvider, sampleTerm);
        }
        else {
            throw new AlreadyVotedOnThatTermException(knowledgeProvider.getNickname() + " already voted in term " + sampleTerm.getName());
        }
    }

    @Override
    public void minusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider) {
        if(canCastAVote(knowledgeProvider, sampleTerm.getName())) {
            deductAVoteFromTerm(sampleTerm);
            addTermToListOfVotedTermsByKnowledProvider(knowledgeProvider, sampleTerm);
        }
        else {
            throw new AlreadyVotedOnThatTermException(knowledgeProvider.getNickname() + " already voted in term " + sampleTerm.getName());
        }
    }
    private void addAVoteToTerm(Term term) {
        term.setPlusVotes(term.getPlusVotes() + 1);
        term.setTotalVotes(term.getPlusVotes() - term.getMinusVotes());
        termsInMemoryStorage.update(term);
    }

    private Term getTermByName(Term sampleTerm) {
        return termsInMemoryStorage.getByName(sampleTerm.getName());
    }

    private void addTermToListOfVotedTermsByKnowledProvider(KnowledgeProvider knowledgeProvider, Term term) {
        knowledgeProvider.getVotedTerms().add(term.getName());
        knowledgeProvidersInMemoryStorage.updateVotes(knowledgeProvider, term.getName());
    }

    private void deductAVoteFromTerm(Term term) {
        term.setMinusVotes(term.getMinusVotes() + 1);
        term.setTotalVotes(term.getPlusVotes() - term.getMinusVotes());
        termsInMemoryStorage.update(term);
    }
}

