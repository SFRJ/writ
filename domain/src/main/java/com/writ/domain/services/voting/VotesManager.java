package com.writ.domain.services.voting;

import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.core.Term;

public interface VotesManager {
    public void plusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider);
    public void minusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider);
}
