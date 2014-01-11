package com.writ.domain.services.knowledge;

import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.services.HexagonalArchitectureService;

public interface KnowledgeProviderManager extends HexagonalArchitectureService{

    public boolean add(KnowledgeProvider knowledgeProvider);

    public void updateVotes(KnowledgeProvider knowledgeProvider, String termName);

    public KnowledgeProvider getKnowledgeProvider(String nickname);

    public void deleteKnowledgeProvider(String nickname);
}
