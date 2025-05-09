package com.yosr.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yosr.vetements.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
