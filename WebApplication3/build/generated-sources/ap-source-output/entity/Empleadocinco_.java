package entity;

import entity.Areacinco;
import entity.Cargocinco;
import entity.Documentocinco;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-27T20:01:42")
@StaticMetamodel(Empleadocinco.class)
public class Empleadocinco_ { 

    public static volatile SingularAttribute<Empleadocinco, Cargocinco> idCargo;
    public static volatile SingularAttribute<Empleadocinco, BigDecimal> idEmpleado;
    public static volatile SingularAttribute<Empleadocinco, Areacinco> idArea;
    public static volatile SingularAttribute<Empleadocinco, Documentocinco> idDocumento;
    public static volatile SingularAttribute<Empleadocinco, String> apellidoEmpleado;
    public static volatile SingularAttribute<Empleadocinco, String> nombreEmpleado;

}