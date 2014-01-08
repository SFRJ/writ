package com.writ.domain.services.voting;

import com.writ.domain.api.VotesManagementService;
import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.core.Term;

public class VotesManagerImpl implements VotesManager {

    private final VotesManagementService votesManagementService;

    public VotesManagerImpl(VotesManagementService votesManagementService) {
        this.votesManagementService = votesManagementService;
    }

    @Override
    public void plusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider) {
        votesManagementService.plusVote(sampleTerm,knowledgeProvider);
    }

    @Override
    public void minusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider) {
        votesManagementService.minusVote(sampleTerm,knowledgeProvider);
    }
}
