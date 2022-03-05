package com.project.mergentech.api;
import com.project.mergentech.entity.Filtre;
import com.project.mergentech.entity.Master;
import com.project.mergentech.entity.Throwablekonsol;
import com.project.mergentech.service.ServiceInterface;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.service.spi.ServiceException;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;
import java.util.List;
//@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/deneme")
public class Controller {
    private final ServiceInterface serviceinterface;

    public Controller(ServiceInterface serviceiterface) {
        this.serviceinterface = serviceiterface;
    }

    //for cors error.
    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            //            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("http://localhost:4200");
            }
        };
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Master>> kaydetMaster(@RequestBody Filtre filtre) {
        List<Master> res = serviceinterface.filtreliListele(filtre);
        return ResponseEntity.ok(res);
    }
//    @RequestBody Master master
    @GetMapping("/konsol")
    public ResponseEntity<List<Master>> kaydetKonsol() {
        List<Master> res = serviceinterface.hataKonsolunaGetir();
        return ResponseEntity.ok(res);
    }
    @PostMapping("/createMaster")
    public ResponseEntity<Master> kaydetMasterdeneme(@RequestBody Master master) {
        Master resultMaster = serviceinterface.kaydetMasterdeneme(master);
        return ResponseEntity.ok(resultMaster);

    }


}
