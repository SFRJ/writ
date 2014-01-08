package com.writ.domain.api;

import com.writ.domain.core.KnowledgeProvider;

public interface KnowledgeProviderManagementService {

    public boolean addKnowledeProvider(KnowledgeProvider knowledgeProvider);

    public KnowledgeProvider getKnowledgeProvider(String nickname);

    public void deleteKnowledgeProvider(String nickname);
}