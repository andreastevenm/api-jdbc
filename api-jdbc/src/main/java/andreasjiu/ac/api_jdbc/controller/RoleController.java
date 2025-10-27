package andreasjiu.ac.api_jdbc.controller;

import andreasjiu.ac.api_jdbc.model.Role;
import andreasjiu.ac.api_jdbc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/hello")
    public String helloRole() {
        return "Hello World";
    }

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    public String addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return "Role added successfully!";
    }

    @PutMapping("/{id}")
    public String updateRole(@PathVariable int id, @RequestBody Role role) {
        role.setRoleId(id);
        roleService.updateRole(role);
        return "Role updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return "Role deleted successfully!";
    }
}
