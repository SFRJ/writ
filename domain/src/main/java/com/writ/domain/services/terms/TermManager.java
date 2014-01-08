package com.writ.domain.services.terms;


import com.writ.domain.core.Term;

import java.util.List;

public interface TermManager {

    public boolean add(Term term);

    public Term getByName(String name);

    public List<Term> getTerms();

    public List<Term> getTermsWithNameContaining(String partialString);

    public void update(Term term);
}
