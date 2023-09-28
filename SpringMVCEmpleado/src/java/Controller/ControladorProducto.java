/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Producto;
import config.Conexion;
import java.text.SimpleDateFormat;
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
public class ControladorProducto {

    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;

    @RequestMapping("producto.htm")
    public ModelAndView Producto() {
        String sql = "SELECT p.*, m.nombre_marca, c.nombre_categoria " +
                 "FROM producto3 p " +
                 "JOIN marca m ON p.id_marca = m.id_marca " +
                 "JOIN categoria c ON p.id_categoria = c.id_categoria";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaProducto", datos);
        mav.setViewName("producto");
        return mav;
    }

    @RequestMapping(value = "agregarProducto.htm", method = RequestMethod.GET)
    public ModelAndView AgregarProducto() {
        mav.addObject(new Producto());
        mav.setViewName("agregarProducto");
        return mav;
    }

    @RequestMapping(value = "agregarProducto.htm", method = RequestMethod.POST)
    public ModelAndView AgregarProducto(Producto c) {

   

        String sql = "insert into producto3(id_categoria,id_marca,descripcion_producto,precio_producto)"
                + " values(?,?,?,?)";
        this.jdbcTemplate.update(sql, c.getId_categoria(), c.getId_marca(), c.getDescripcion_producto(),
                c.getPrecio_producto());
        return new ModelAndView("redirect:/producto.htm");
    }

    @RequestMapping(value = "editarProducto.htm", method = RequestMethod.GET)
    public ModelAndView EditarProducto(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from producto3 where id_producto=" + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaProducto", datos);
        mav.setViewName("editarProducto");
        return mav;
    }

    @RequestMapping(value = "editarProducto", method = RequestMethod.POST)
    public ModelAndView EditarProducto(Producto c) {
        String sql = "update producto3 set id_categoria=?,id_marca=?, descripcion_producto=?,"
                + "precio_producto=? where id_producto=" + id;
        this.jdbcTemplate.update(sql, c.getId_categoria(), c.getId_marca(), c.getDescripcion_producto(),
                c.getPrecio_producto());
        return new ModelAndView("redirect:/producto.htm");
    }

    @RequestMapping("eliminarProducto.htm")
    public ModelAndView EliminarProducto(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from producto3 where id_producto=" + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/producto.htm");
    }
}
