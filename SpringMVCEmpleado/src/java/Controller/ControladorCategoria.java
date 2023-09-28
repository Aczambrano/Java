/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Categoria;
import config.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anderson
 */
public class ControladorCategoria {
    
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;

    @RequestMapping("categoria.htm")
    public ModelAndView Categoria() {
        String sql = "select * from categoria";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaCategoria", datos);
        mav.setViewName("categoria");
        return mav;
    }

    @RequestMapping(value = "agregarCategoria.htm", method = RequestMethod.GET)
    public ModelAndView AgregarCategoria() {
        mav.addObject(new Categoria());
        mav.setViewName("agregarCategoria");
        return mav;
    }

     @RequestMapping(value = "agregarCategoria.htm", method = RequestMethod.POST)
    public ModelAndView AgregarArea(Categoria c){
        String sql = "insert into categoria(nombre_categoria) values(?)";
        this.jdbcTemplate.update(sql,c.getNombre_categoria());
        return new ModelAndView("redirect:/categoria.htm");
    }
    
    @RequestMapping(value = "editarCategoria.htm", method = RequestMethod.GET)
    public ModelAndView EditarCategoria(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from categoria where id_categoria="+id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaCategoria", datos);
        mav.setViewName("editarCategoria");
        return mav;
    }
    
    @RequestMapping(value = "editarCategoria", method = RequestMethod.POST)
    public ModelAndView EditarCategoria(Categoria c){
        String sql = "update categoria set nombre_categoria=? where id_categoria="+id;
        this.jdbcTemplate.update(sql,c.getNombre_categoria());
        return new ModelAndView("redirect:/categoria.htm");
    }
    
    @RequestMapping("eliminarCategoria.htm")
    public ModelAndView EliminarCategoria(HttpServletRequest request){
    id = Integer.parseInt(request.getParameter("id"));
    String sql = "delete from categoria where id_categoria="+id;
    this.jdbcTemplate.update(sql);
    return new ModelAndView("redirect:/categoria.htm");
    }
}
