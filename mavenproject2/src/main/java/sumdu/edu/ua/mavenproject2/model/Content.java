/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.mavenproject2.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author artem
 */
@Entity
@Table(name="disciplines")
public class Content {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="id")
    private int id;
    @Column(name="student_id")
    private int stud_id;
    @Column(name="title")
    private String title;
    @Column(name="mark_let")
    String mark_let;
    @Column(name="mark_num")
    int mark_num;
    
    public Content(){}
    
    public Content(int id, int stud_id, String title, String mark_let, int mark_num) {
        this.id = id;
        this.stud_id = stud_id;
        this.title = title;
        this.mark_let = mark_let;
        this.mark_num = mark_num;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMark_let() {
        return mark_let;
    }

    public int getMark_num() {
        return mark_num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMark_let(String mark_let) {
        this.mark_let = mark_let;
    }

    public void setMark_num(int mark_num) {
        this.mark_num = mark_num;
    }

    public int getStud_id() {
        return stud_id;
    }
    
    
}
