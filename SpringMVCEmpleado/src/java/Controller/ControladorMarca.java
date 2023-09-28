/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Marca;
import config.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anderson
 */
@Controller
public class ControladorMarca {

    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;

    @RequestMapping("marca.htm")
    public ModelAndView Area() {
        String sql = "select * from marca";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaMarca", datos);
        mav.setViewName("marca");
        return mav;
    }

    @RequestMapping(value = "agregarMarca.htm", method = RequestMethod.GET)
    public ModelAndView AgregarArea() {
        mav.addObject(new Marca());
        mav.setViewName("agregarMarca");
        return mav;
    }

     @RequestMapping(value = "agregarMarca.htm", method = RequestMethod.POST)
    public ModelAndView AgregarArea(Marca c){
        String sql = "insert into marca(nombre_marca) values(?)";
        this.jdbcTemplate.update(sql,c.getNombre_marca());
        return new ModelAndView("redirect:/marca.htm");
    }
    
    @RequestMapping(value = "editarMarca.htm", method = RequestMethod.GET)
    public ModelAndView EditarArea(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from marca where id_marca="+id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaMarca", datos);
        mav.setViewName("editarMarca");
        return mav;
    }
    
    @RequestMapping(value = "editarMarca", method = RequestMethod.POST)
    public ModelAndView EditarMarcaa(Marca c){
        String sql = "update marca set nombre_marca=? where id_marca="+id;
        this.jdbcTemplate.update(sql,c.getNombre_marca());
        return new ModelAndView("redirect:/marca.htm");
    }
    
    @RequestMapping("eliminarMarca.htm")
    public ModelAndView EliminarMarca(HttpServletRequest request){
    id = Integer.parseInt(request.getParameter("id"));
    String sql = "delete from marca where id_marca="+id;
    this.jdbcTemplate.update(sql);
    return new ModelAndView("redirect:/marca.htm");
    }

}
