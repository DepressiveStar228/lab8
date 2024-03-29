/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.mavenproject2.Controllers;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sumdu.edu.ua.mavenproject2.model.Student;
import sumdu.edu.ua.mavenproject2.Repo.Repo_Student;

/**
 *
 * @author artem
 */
@Controller
public class StudentController {
    List<Student> students;
    ApplicationContext factory;
    
    @Autowired
    private Repo_Student dao;
    
    @ModelAttribute
    public void modelData(Model m){
        if(students==null){ students = new LinkedList<Student>();}
        factory = new ClassPathXmlApplicationContext("/spring.xml");
    }
    
    @RequestMapping("/")
    public String home(Model m) {
        students=dao.getAllStudents();
        m.addAttribute("students", dao.findAll());
	return "student";
    }
    
    @RequestMapping(value = "/StudentAdd")
    public String addStudent(HttpServletRequest request,Model m){              
        if (request.getParameter("name") != "" && request.getParameter("surname") != "") {
            Student student = (Student) factory.getBean("Student");
            
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setAge(Integer.parseInt(request.getParameter("age")));
            student.setEmail(request.getParameter("email"));
            student.setGroup(request.getParameter("group"));
            student.setFaculty(request.getParameter("faculty"));
            dao.save(student);
        }
        
        students=dao.findAll();
    
        m.addAttribute("students", students);
        return "student";
    }     
}
