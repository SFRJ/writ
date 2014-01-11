package com.writ.domain.services.voting;

import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.core.Term;
import com.writ.domain.services.HexagonalArchitectureService;

public interface VotesManager extends HexagonalArchitectureService{
    public void plusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider);
    public void minusVote(Term sampleTerm, KnowledgeProvider knowledgeProvider);
}
