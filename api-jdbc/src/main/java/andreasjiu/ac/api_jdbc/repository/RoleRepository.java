package andreasjiu.ac.api_jdbc.repository;
import andreasjiu.ac.api_jdbc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Role> findAll() {
        String sql = "SELECT * FROM roles";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Role.class));
    }

    public Role findById(int id) {
        String sql = "SELECT * FROM roles WHERE role_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Role.class), id);
    }

    public int save(Role role) {
        String sql = "INSERT INTO roles (role_name) VALUES (?)";
        return jdbcTemplate.update(sql, role.getRoleName());
    }

    public int update(Role role) {
        String sql = "UPDATE roles SET role_name = ? WHERE role_id = ?";
        return jdbcTemplate.update(sql, role.getRoleName(), role.getRoleId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM roles WHERE role_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
