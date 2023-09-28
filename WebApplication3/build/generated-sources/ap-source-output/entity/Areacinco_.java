package entity;

import entity.Empleadocinco;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-27T20:01:42")
@StaticMetamodel(Areacinco.class)
public class Areacinco_ { 

    public static volatile SingularAttribute<Areacinco, String> nombreArea;
    public static volatile SingularAttribute<Areacinco, BigDecimal> idArea;
    public static volatile CollectionAttribute<Areacinco, Empleadocinco> empleadocincoCollection;

}