package entity;

import entity.Empleadocinco;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-27T20:01:42")
@StaticMetamodel(Documentocinco.class)
public class Documentocinco_ { 

    public static volatile SingularAttribute<Documentocinco, BigDecimal> idDocumento;
    public static volatile SingularAttribute<Documentocinco, String> nombreDocumento;
    public static volatile CollectionAttribute<Documentocinco, Empleadocinco> empleadocincoCollection;

}