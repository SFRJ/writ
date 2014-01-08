package com.writ.persistence.filesystem.votes;

import com.writ.domain.core.KnowledgeProvider;

public class VoteValidator {

    public static boolean canCastAVote(KnowledgeProvider knowledgeProvider, String termName) {
        for(String currentTerm : knowledgeProvider.getVotedTerms())
            if(currentTerm.equalsIgnoreCase(termName))
                return false;
        return true;
    }

}
