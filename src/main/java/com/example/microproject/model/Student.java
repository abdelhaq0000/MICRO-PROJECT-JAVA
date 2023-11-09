package com.example.microproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.*;
@Data
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
   @XmlAttribute
    private String name;
    @XmlAttribute
    private int apogee;
    @XmlAttribute
    private String prenom;
    @XmlElement
    private double noteN;
    @XmlElement
    private double noteR;
    @XmlAttribute
    private String email;
    @XmlElement
    private double M1;
    @XmlElement
    private double M2;
    @XmlElement
    private double M3;
    @XmlElement
    private double M4;
    @XmlElement
    private double M5;
    @XmlElement
    private double M6;
 @XmlElement
 private double MR1;
 @XmlElement
 private double MR2;
 @XmlElement
 private double MR3;
 @XmlElement
 private double MR4;
 @XmlElement
 private double MR5;
 @XmlElement
 private double MR6;

    private static int lastApogee = 0;
    public Student() {
        lastApogee++;
        this.apogee = lastApogee;
    }


}
