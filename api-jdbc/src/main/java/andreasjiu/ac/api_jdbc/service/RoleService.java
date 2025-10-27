package andreasjiu.ac.api_jdbc.service;

import andreasjiu.ac.api_jdbc.model.Role;
import andreasjiu.ac.api_jdbc.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(int id) {


        Role role = new Role();
        role = roleRepository.findById(id);
        String roleName  = role.getRoleName()+"-1";
        role.setRoleName(roleName);

        return role;
    }

    public int addRole(Role role) {
        return roleRepository.save(role);
    }

    public int updateRole(Role role) {
        return roleRepository.update(role);
    }

    public int deleteRole(int id) {
        return roleRepository.delete(id);
    }
}

