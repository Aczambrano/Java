/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidad.Area;
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
public class ControllerArea {
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;

    @RequestMapping("area.htm")
    public ModelAndView Area() {
        String sql = "select * from area";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaArea", datos);
        mav.setViewName("area");
        return mav;
    }

    @RequestMapping(value = "agregarArea.htm", method = RequestMethod.GET)
    public ModelAndView AgregarArea() {
        mav.addObject(new Area());
        mav.setViewName("agregarArea");
        return mav;
    }

     @RequestMapping(value = "agregarArea.htm", method = RequestMethod.POST)
    public ModelAndView AgregarArea(Area c){
        String sql = "insert into area(nombre_area) values(?)";
        this.jdbcTemplate.update(sql,c.getNombre_area());
        return new ModelAndView("redirect:/area.htm");
    }
    
    @RequestMapping(value = "editarArea.htm", method = RequestMethod.GET)
    public ModelAndView EditarArea(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from area where id_area="+id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaArea", datos);
        mav.setViewName("editarArea");
        return mav;
    }
    
    @RequestMapping(value = "editarArea", method = RequestMethod.POST)
    public ModelAndView EditarArea(Area c){
        String sql = "update area set nombre_area=? where id_area="+id;
        this.jdbcTemplate.update(sql,c.getNombre_area());
        return new ModelAndView("redirect:/area.htm");
    }
    
    @RequestMapping("eliminarArea.htm")
    public ModelAndView EliminarArea(HttpServletRequest request){
    id = Integer.parseInt(request.getParameter("id"));
    String sql = "delete from area where id_area="+id;
    this.jdbcTemplate.update(sql);
    return new ModelAndView("redirect:/area.htm");
    }
}
