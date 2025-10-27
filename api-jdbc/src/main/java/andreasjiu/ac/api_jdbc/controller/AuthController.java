package andreasjiu.ac.api_jdbc.controller;

import andreasjiu.ac.api_jdbc.model.User;
import andreasjiu.ac.api_jdbc.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();

        if ("andreas".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            response.put("token", token);
            response.put("message", "Login success!");
        } else {
            response.put("message", "Invalid username or password");
        }

        return response;
    }
}
