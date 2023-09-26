/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityController;

import Entity.Cargocinco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class CargocincoFacade extends AbstractFacade<Cargocinco> {

    @PersistenceContext(unitName = "JSFEmpleadoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargocincoFacade() {
        super(Cargocinco.class);
    }
    
}
