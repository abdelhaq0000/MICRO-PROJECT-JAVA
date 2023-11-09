package com.example.microproject;

import com.example.microproject.model.Student;
import com.example.microproject.model.Students;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class Main {
  /*  public static void main(String[] args) throws JAXBException {
        Student s = new Student();
        s.setName("abdooo");
        Semseter1Sevice semseter1Sevice = new Semseter1Sevice();
        Students students = new Students();
        students.addStudent(s);
    }*/
  public static void main(String[] args) throws JAXBException {
    List<Integer> list = new ArrayList<Integer>();
    int[][] list1 = new int[][]{{1,2},{1,2}};
    Set<Integer> list2 = new HashSet<Integer>();
    Map<String,Integer> list3 = new HashMap<String,Integer>();
    list3.put("one",1);
    list3.put("two",2);
    list2.add(3);
    list2.add(4);
    list.add(1);
    list.add(2);
   // System.out.println(list3.get("one"));
    //for(Integer i : list2){
     // System.out.println(i);
    //}
    for (int i = 0; i<3 ; i++){
      System.out.println(i);
    }
  }
}
