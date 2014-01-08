package com.writ.domain.api;

import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.core.Term;

public interface VotesManagementService {
    public void plusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider);
    public void minusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider);
}