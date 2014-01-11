package com.writ.domain.services.terms;


import com.writ.domain.core.Term;
import com.writ.domain.services.HexagonalArchitectureService;

import java.util.List;

public interface TermManager extends HexagonalArchitectureService {

    public boolean add(Term term);

    public Term getByName(String name);

    public List<Term> getTerms();

    public List<Term> getTermsWithNameContaining(String partialString);

    public void update(Term term);
}
