package asLtda.catalogoAccesorios;

import asLtda.catalogoAccesorios.model.Accessory;
import asLtda.catalogoAccesorios.model.User;
import asLtda.catalogoAccesorios.repository.crud.AccessoryCrudRepository;
import asLtda.catalogoAccesorios.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoAccesoriosApplication implements CommandLineRunner{
    @Autowired
    private UserCrudRepository userRepo;
    @Autowired
    private AccessoryCrudRepository accessoryCrud;

    public static void main(String[] args) {
	SpringApplication.run(CatalogoAccesoriosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        accessoryCrud.deleteAll();
        
        /*userRepo.saveAll(List.of(
                        new User(1, "1018460767", "JUANA LA LOCA", "CR 19 # 19-45", "311234123", "juanaloca@gmail.com", "Demo123.", "Zona 1", "ADM"),
                        new User(2, "8460767", "FELIPE EL HERMOSO", "CR 19 # 19-45", "234123311", "felipeh@gmail.com", "Demo123.", "Zona 1", "COORD"),
                        new User(3, "10460767", "ISABEL I", "CR 19 # 19-45", "234311123", "isabelI@gmail.com", "Demo123.", "Zona 1", "ASE"),
                        new User(4, "53535457", "FERNANDO DE ARAGON", "CR 19 # 19-45", "233114123", "ferchoviii@gmail.com", "Demo123.", "Zona 1", "ASE")
                ));
 
        accessoryCrud.saveAll(List.of(
                new Accessory("AP-903", "DINO BOOT", "BELTS", "LEATHER/METAL", "LEATHER BELT FOR LADY...", true, 250000, 10, "https://www.catalog.com/belt1.png"),
                new Accessory("AP-904", "ACME", "MATERIAL 1", "PRESENTACION 1", "DESCRIPCION DETALLADA...", true, 130000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg")
                ));
        
        System.out.println("Listado de usuarios");
        userRepo.findAll().forEach(System.out::println);
        
        System.out.println("Listado de accesorios");
        accessoryCrud.findAll().forEach(System.out::println);*/
        
        /*System.out.println("Aqui se ejecutaran la creación de documentos de mongo...");
        
        //para efectos de formateo de fechas
        SimpleDateFormat ft = new SimpleDateFormat("yyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd");
        
        //Agregar documentos a la colección "usuarios"
        userRepo.saveAll(
                List.of(
                        new User(1, "453423", "JUANA LA LOCA", ft.parse("1986-11-15"), "11", "CL 34 NRO AAA..", "234123", "juanaloca@gmail.com", "Demo123.", "Zona 1", "ADM"),
                        new User(2, "3453423", "FELIPE EL HERMOSO", ft.parse("1984-11-15"), "11", "CL 34 NRO AAA..", "234123", "felipeh@gmail.com", "Demo123.", "Zona 1", "COORD"),
                        new User(3, "253423", "ISABEL I", ft.parse("1943-11-15"), "11", "CL 34 NRO AAA..", "234123", "isabelI@gmail.com", "Demo123.", "Zona 1", "ASE"),
                        new User(4, "34534423", "FERNANDO DE ARAGON", ft.parse("1953-11-15"), "11", "CL 34 NRO AAA..", "234123", "ferchoviii@gmail.com", "Demo123.", "Zona 1", "ASE")
                ));
        
        //Agregar documentos a la colección "accesorios"
        accessoryCrud.saveAll(
                List.of(
                        new Accessory("AP-903", "ACME", "MATERIAL 1", "PRESENTACION 1", "DESCRIPCION DETALLADA", true, 120000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
                        new Accessory("AP-904", "ACME", "MATERIAL 2", "PRESENTACION 2", "DESCRIPCION DETALLADA", true, 130000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg")
                ));
        
        System.out.println("Listado de usuarios");
        userRepo.findAll().forEach(System.out::println);
        
        System.out.println("Listado de accesorios");
        accessoryCrud.findAll().forEach(System.out::println);*/
    }

}
