package andreasjiu.ac.api_jdbc.controller;

import andreasjiu.ac.api_jdbc.model.User;
import andreasjiu.ac.api_jdbc.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

//    jadi saya buat auth controller utama untuk si login user dimana ada endpoint "login" untuk nerima data username
    //dan password dari body

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
//        nah disini ada @RequestBody user user ini untuk nerima si data username dan password
        Map<String, String> response = new HashMap<>();

        if ("andreas".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
//            disini saya buat username dan password sendiri apabila itu benar maka akan dituliskan token nya dan message login success
            // saya juga insert foto nya di email hehehe
            String token = jwtUtil.generateToken(user.getUsername());
            response.put("token", token);
            response.put("message", "Login success!");
        } else {
//            if salah print invalid username
            response.put("message", "Invalid username or password");
        }

        return response;
    }
}
