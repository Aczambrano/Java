package Controller;

import Entidad.Cargo;
import Entidad.Empleado;
import config.Conexion;
import java.util.List;
import javafx.scene.control.Alert;
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
public class Controlador {

    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;
    @RequestMapping("index.htm")
    public ModelAndView Listar() {
        String sql = "select * from empleado";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("cargo.htm")
    public ModelAndView Cargo() {
        String sql = "select * from cargo";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaCargo", datos);
        mav.setViewName("cargo");
        return mav;
    }

    @RequestMapping(value = "agregarCargo.htm", method = RequestMethod.GET)
    public ModelAndView AgregarCargo() {
        mav.addObject(new Cargo());
        mav.setViewName("agregarCargo");
        return mav;
    }

     @RequestMapping(value = "agregarCargo.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Cargo c){
        String sql = "insert into cargo(nombre_cargo) values(?)";
        this.jdbcTemplate.update(sql,c.getNombre_cargo());
        return new ModelAndView("redirect:/cargo.htm");
    }
    
    @RequestMapping(value = "editarCargo.htm", method = RequestMethod.GET)
    public ModelAndView EditarCargo(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from cargo where id_cargo="+id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaCargo", datos);
        mav.setViewName("editarCargo");
        return mav;
    }
    
    @RequestMapping(value = "editarCargo", method = RequestMethod.POST)
    public ModelAndView EditarCargo(Cargo c){
        String sql = "update cargo set nombre_cargo=? where id_cargo="+id;
        this.jdbcTemplate.update(sql,c.getNombre_cargo());
        return new ModelAndView("redirect:/cargo.htm");
    }
    
    @RequestMapping("eliminarCargo.htm")
    public ModelAndView EliminarCargo(HttpServletRequest request){
    id = Integer.parseInt(request.getParameter("id"));
    String sql = "delete from cargo where id_cargo="+id;
    this.jdbcTemplate.update(sql);
    return new ModelAndView("redirect:/cargo.htm");
    
    }
}
