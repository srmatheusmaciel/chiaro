package br.com.chiaro.audit;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        AuditRevision rev = (AuditRevision) revisionEntity;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            rev.setUsuarioResponsavel(auth.getName());
        } else {
            rev.setUsuarioResponsavel("SISTEMA_OU_ANONIMO");
        }
    }
}