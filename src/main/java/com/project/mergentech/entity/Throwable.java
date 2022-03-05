package com.project.mergentech.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "THROWABLE")
@Table(name = "THROWABLE", schema = "HATALOG")
public class Throwable implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_THROWABLE", sequenceName = "SEQ_THROWABLE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_THROWABLE")
    @Column(name = "DETAYLAR_ID")
    private Long th_Id;
    @Column(name = "CLASS_NAME")
    private String className;
    @Column(name = "METHOD_NAME")
    private String methodName;
    @Column(name = "LINE_NUMBER")
    private String lineNumber;
    @Column(name = "FILE_NAME")
    private String fileName;
    //    private Long fk_m_Id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Master.class)
    @JoinColumn(name = "master_m_ıd",referencedColumnName = "M_ID")
    @JsonIgnoreProperties("throwables")
    private Master master;

}