package com.writ.userinterface.frontendcontrollers;


import com.writ.domain.core.Term;
import com.writ.domain.core.errors.TermAlreadyExistsException;
import com.writ.domain.services.terms.TermManager;
import com.writ.domain.services.terms.TermManagerImpl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CreateController {

    private String author;
    private String termName;
    private String termDescription;

    public CreateController() {
        this.author = "Get the author name from the session!!!!";
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermDescription() {
        return termDescription;
    }

    public void setTermDescription(String termDescription) {
        this.termDescription = termDescription;
    }

    public void saveTerm() {
        //TODO Find out where this should be instantiated and how to provide the service to the UI(Maybe a pressentation object can help)

        TermManager termManager = new TermManagerImpl(null);
        try {
            termManager.add(new Term(termName,termDescription,author));
        }
        catch (TermAlreadyExistsException e) {
            FacesMessage facesMessage =
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Term already exist", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

}
