package com.writ.persistence.filesystem.terms;

import com.writ.domain.api.TermManagementService;
import com.writ.domain.core.Term;
import com.writ.domain.core.errors.LongDescriptionException;
import com.writ.domain.core.errors.TermAlreadyExistsException;

public class TermValidator {

    protected static boolean validateTerm(Term term,TermManagementService termsPersistencyManager) {
        return isTermNotInStorage(term.getName(), termsPersistencyManager) &&
                isDescriptionSmallerOrEqual400Characters(term.getDescription());
    }

    private static boolean isDescriptionSmallerOrEqual400Characters(String description) {
        if(description.length() > 400)
            throw new LongDescriptionException("The maximum description length is 400 but was " + description.length());
        return  true;
    }

    private static boolean isTermNotInStorage(String key,TermManagementService termsPersistencyManager) {
        if(termsPersistencyManager.getByName(key) != null)
            throw new TermAlreadyExistsException("The term " + key + " already exists in the storage");
        return true;
    }

}
