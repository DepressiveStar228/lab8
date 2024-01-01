/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.mavenproject2.security;
import org.springframework.data.jpa.repository.JpaRepository;
import sumdu.edu.ua.mavenproject2.model.User;


/**
 *
 * @author artem
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    public void save(User user);
}
