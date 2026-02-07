package br.com.chiaro.audit;

import br.com.chiaro.model.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.util.Date;

@Entity
@Table(name = "tb_revision_info")
@RevisionEntity(AuditListener.class)
@Getter
@Setter
public class AuditRevision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    private int id;

    @RevisionTimestamp
    private long timestamp;

    @Column(name = "usuario_responsavel")
    private String usuarioResponsavel;

    public Date getDataRevisao() {
        return new Date(timestamp);
    }
}