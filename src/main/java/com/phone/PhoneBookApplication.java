package com.phone;

import com.phone.form.MainJFrame;
import com.phone.repos.PhoneRepository;
import com.phone.repos.UserRepository;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhoneBookApplication {

    @Autowired UserRepository userRepository;
    @Autowired PhoneRepository phoneRepository;
    MainJFrame frame;
    public static void main(String[] args) {
        new SpringApplicationBuilder(PhoneBookApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
        System.setProperty("java.awt.headless", "false");
       
    }
    
    @Bean
    public MainJFrame frame() {
         SwingUtilities.invokeLater(() -> {
            frame = new MainJFrame(userRepository,phoneRepository);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
         return frame;
    }

}
