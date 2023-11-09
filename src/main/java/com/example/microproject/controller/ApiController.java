package com.example.microproject.controller;

import com.example.microproject.model.*;
import com.example.microproject.service.XmlDataService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
public class ApiController {

    @Autowired
    private XmlDataService xmlDataService;

    @GetMapping("/students")
    public List<Student> getStudents() throws JAXBException {
        return  xmlDataService.readXmlData().getStudentList();
    }
    @GetMapping("/login/{name}/{apogee}")
    public String login(@PathVariable("name") String name,@PathVariable("apogee") String apogee) throws JAXBException {
        File xmlFile = new File("src/main/resources/data/students.xml");
        JAXBContext context = null;
        String updatedXml = "";
        Students semester2=null;
        List<Student> students = new ArrayList<>();
        context = JAXBContext.newInstance(Students.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        semester2 = (Students) unmarshaller.unmarshal(xmlFile);
        students = semester2.getStudentList();
        for (Student student : students) { if ((student.getApogee()+"").equals(apogee) && name.equals(student.getName())) return "student existe";}
        return "student no existe";
    }
    @GetMapping("/adminLogin/{name}/{mdp}")
    public String admin(@PathVariable("name") String name,@PathVariable("mdp") String mdp){
        if (name.equals("admin") && mdp.equals("admin")) return "login successfully ";
        return "login unsuccessfully";
    }
   /* @GetMapping("/modules")
    public Modules getModules()throws JAXBException{
        return xmlDataService.readModulesXmlData();
    }*/

    @GetMapping("/hi")
    public String hi() {
        return "hi abdelhaq";
    }

   /* @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) throws JAXBException {
        xmlDataService.addStudent(student);
        return "Student added successfully.";
    }*/
    @GetMapping("/student/{semester}/{apogee}")
    public Student getnotes(@PathVariable("apogee") int apogee,@PathVariable("semester") int semester){
        Student trgetStudent = null;
        try {

            // Load the XML file
            File xmlFile = new File("src/main/resources/data/semester"+semester+".xml");
            JAXBContext context = null;
            String updatedXml = "";
            List<Student> students = new ArrayList<>();
            Marshaller marshaller;
            Semester2 semester2=null;
            Semester3 semester3=null;
            Semester1 semester1 = null;
            Semester4 semester4 = null;
            // Unmarshal (read) the XML file into a Semester6 object


            if( semester == 2){
                context = JAXBContext.newInstance(Semester2.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester2 = (Semester2) unmarshaller.unmarshal(xmlFile);
                students = semester2.getStudents();
            } else if (semester == 1) {

                context = JAXBContext.newInstance(Semester1.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester1 = (Semester1) unmarshaller.unmarshal(xmlFile);
                students = semester1.getStudents();
            } else if (semester == 3) {
                context = JAXBContext.newInstance(Semester3.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester3 = (Semester3) unmarshaller.unmarshal(xmlFile);
                students = semester3.getStudents();
            } else if (semester == 4) {
                context = JAXBContext.newInstance(Semester4.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester4 = (Semester4) unmarshaller.unmarshal(xmlFile);
                students = semester4.getStudents();
            }

            for (Student student : students) { if (student.getApogee() == apogee) trgetStudent = student;}
        } catch (JAXBException e) {
            e.printStackTrace();
        }
       return trgetStudent;
    }
   /* @GetMapping("/students")
    public List<Student> getAll(){
        List<Student> trgetStudent = null;
        try {

            // Load the XML file
            File xmlFile = new File("src/main/resources/data/students.xml");
            JAXBContext context = null;
            String updatedXml = "";
            List<Student> students = new ArrayList<>();
            Marshaller marshaller;
            Students s=null;

            // Unmarshal (read) the XML file into a Semester6 object

                context = JAXBContext.newInstance(Students.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                s = (Students) unmarshaller.unmarshal(xmlFile);
                students = s.getStudentList();


            trgetStudent = students;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return trgetStudent;
    }*/
    @GetMapping("/students/{semester}")
    public List<Student> getstudentSemster(@PathVariable("semester") int semester){
        List<Student> trgetStudent = null;
        try {

            // Load the XML file
            File xmlFile = new File("src/main/resources/data/semester"+semester+".xml");
            JAXBContext context = null;
            String updatedXml = "";
            List<Student> students = new ArrayList<>();
            Marshaller marshaller;
            Semester2 semester2=null;
            Semester3 semester3=null;
            Semester1 semester1 = null;
            Semester4 semester4 = null;
            // Unmarshal (read) the XML file into a Semester6 object


            if( semester == 2){
                context = JAXBContext.newInstance(Semester2.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester2 = (Semester2) unmarshaller.unmarshal(xmlFile);
                students = semester2.getStudents();
            } else if (semester == 1) {

                context = JAXBContext.newInstance(Semester1.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester1 = (Semester1) unmarshaller.unmarshal(xmlFile);
                students = semester1.getStudents();
            } else if (semester == 3) {
                context = JAXBContext.newInstance(Semester3.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester3 = (Semester3) unmarshaller.unmarshal(xmlFile);
                students = semester3.getStudents();
            } else if (semester == 4) {
                context = JAXBContext.newInstance(Semester4.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester4 = (Semester4) unmarshaller.unmarshal(xmlFile);
                students = semester4.getStudents();
            }

             trgetStudent = students;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return trgetStudent;
    }
    @PutMapping("/updateNote/{semester}/{apogeeP}/{note}/{module}/{session}")
    public void updateNote(@PathVariable("note") double note,@PathVariable("session") String session,@PathVariable("module") double module,@PathVariable("apogeeP" ) int apogeeP,@PathVariable("semester" ) int semester){
        try {
            // Load the XML file
            File xmlFile = new File("src/main/resources/data/semester"+semester+".xml");
            JAXBContext context = null;
            String updatedXml = "";
            List<Student> students = new ArrayList<>();
            Marshaller marshaller;
            Semester2 semester2=null;
            Semester3 semester3=null;
            Semester1 semester1 = null;
            Semester4 semester4 = null;
            // Unmarshal (read) the XML file into a Semester6 object


            if( semester == 2){
                 context = JAXBContext.newInstance(Semester2.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester2 = (Semester2) unmarshaller.unmarshal(xmlFile);
                 students = semester2.getStudents();
            } else if (semester == 1) {

                context = JAXBContext.newInstance(Semester1.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester1 = (Semester1) unmarshaller.unmarshal(xmlFile);
                students = semester1.getStudents();
            } else if (semester == 3) {
                context = JAXBContext.newInstance(Semester3.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester3 = (Semester3) unmarshaller.unmarshal(xmlFile);
                students = semester3.getStudents();
            } else if (semester == 4) {
                context = JAXBContext.newInstance(Semester4.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                semester4 = (Semester4) unmarshaller.unmarshal(xmlFile);
                students = semester4.getStudents();
            }

            for (Student student : students) {
                if(student.getApogee() == apogeeP) {
                    if(session.equals("O")) {
                        switch ((int) module) {
                            case 1:
                                student.setM1(note);
                                break;
                            case 2:
                                student.setM2(note);
                                break;
                            case 3:
                                student.setM3(note);
                                break;
                            case 4:
                                student.setM4(note);
                                break;
                            case 5:
                                student.setM5(note);
                                break;
                            case 6:
                                student.setM6(note);
                                break;
                            default:
                                break;
                        }
                    }else{
                        switch ((int) module) {
                            case 1:
                                student.setMR1(note);
                                break;
                            case 2:
                                student.setMR2(note);
                                break;
                            case 3:
                                student.setMR3(note);
                                break;
                            case 4:
                                student.setMR4(note);
                                break;
                            case 5:
                                student.setMR5(note);
                                break;
                            case 6:
                                student.setMR6(note);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            // Marshal (write) the modified Semester6 object
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter xmlWriter = new StringWriter();
            if (semester == 1){
                marshaller.marshal(semester1, xmlWriter);
            } else if (semester == 2) {
                marshaller.marshal(semester2, xmlWriter);
            } else if (semester == 3) {
                marshaller.marshal(semester3, xmlWriter);
            } else if (semester == 4) {
                marshaller.marshal(semester4, xmlWriter);
            }
            updatedXml = xmlWriter.toString();

            // Print or save the updated XML to a new file
            System.out.println(updatedXml);

            // Save the updated XML to a new file
            String outputPath = "src/main/resources/data/semester"+semester+".xml";
            try (FileWriter writer = new FileWriter(outputPath)) {
                writer.write(updatedXml);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }



}