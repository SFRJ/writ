package com.writ.userinterface.frontendcontrollers;


import com.writ.domain.core.Term;
import com.writ.domain.services.terms.TermManager;
import com.writ.domain.services.terms.TermManagerImpl;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.List;

@ManagedBean
@RequestScoped
public class RetrieveController {

    private TermManager termsPersistencyManager;
    private List<Term> termsToDisplay;
    private String searchTerm;

    @PostConstruct
    public void init() {
        //Todo: Display by default the latest added(by time)
        termsPersistencyManager = new TermManagerImpl(null);
        termsToDisplay = termsPersistencyManager.getTerms();
        searchTerm = "";
    }

    public List<Term> getTerms() {
        return termsToDisplay;
    }

    public void setTermsToDisplay(List<Term> termsToDisplay) {
        this.termsToDisplay = termsToDisplay;
    }

    //TODO: Add search funcionality that with AJAX returns a list of all those terms that contain the given string.
    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void searchTermThatContainsString(AjaxBehaviorEvent ajaxBehaviorEvent) {
        termsToDisplay = termsPersistencyManager.getTermsWithNameContaining(searchTerm);
    }
}

