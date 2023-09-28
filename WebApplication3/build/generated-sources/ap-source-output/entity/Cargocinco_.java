package entity;

import entity.Empleadocinco;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-27T20:01:42")
@StaticMetamodel(Cargocinco.class)
public class Cargocinco_ { 

    public static volatile SingularAttribute<Cargocinco, BigDecimal> idCargo;
    public static volatile SingularAttribute<Cargocinco, String> nombreCargo;
    public static volatile CollectionAttribute<Cargocinco, Empleadocinco> empleadocincoCollection;

}