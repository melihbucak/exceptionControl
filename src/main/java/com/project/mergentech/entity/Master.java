package com.project.mergentech.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "MASTER")
@Table(name = "MASTER", schema = "HATALOG")
public class Master implements Serializable {
    private static final long serialVersionUID = 1L;//bunu araştır
    @Id
    @SequenceGenerator(name = "SEQ_MASTER", sequenceName = "SEQ_MASTER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MASTER")
    @Column(name = "M_ID", unique = true, nullable = false)
    private Long m_Id;
    @Column(name = "HOSPITAL_NAME")
    private String hastaneAdi;
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    @Column(name = "MAC_ADDRESS")
    private String macAddress;
    @Column(name = "USER_CODE")
    private String kullaniciKodu;
    @Column(name = "MESSAGE_DESCRIBE")
    private String mesajTanimi;
    @Column(name = "TIME")
    private LocalDateTime zaman;
    @OneToMany(mappedBy = "master",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("master")
    private List<Throwable> throwables = new ArrayList<>();
//    @Column(name = "MASTER_M_ID", nullable = false)
//    private Long master_m_ıd;
}