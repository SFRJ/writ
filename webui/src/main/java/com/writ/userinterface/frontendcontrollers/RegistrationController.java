package com.writ.userinterface.frontendcontrollers;


import com.writ.domain.core.KnowledgeProvider;
import com.writ.domain.services.knowledge.KnowledgeProviderManager;
import com.writ.domain.services.knowledge.KnowledgeProviderManagerImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RegistrationController {

    private String nickName;
    private String password;
    private KnowledgeProviderManager knowledgeProviderManager;

    public RegistrationController() {
        knowledgeProviderManager = new KnowledgeProviderManagerImpl(null);
    }
    //This should not redirect to the search page if it fails to register
    public String register() {
        return validateRegistration(nickName, password) ? "search":"index";
    }

    private boolean validateRegistration(String nickName, String password) {
        //TODO implement validation
        KnowledgeProvider knowledgeProvider = new KnowledgeProvider();
        knowledgeProvider.setPassword(password);
        knowledgeProvider.setNickname(nickName);
        return knowledgeProviderManager.add(knowledgeProvider);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
