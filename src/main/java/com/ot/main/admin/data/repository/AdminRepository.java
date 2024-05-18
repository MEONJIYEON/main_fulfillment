package com.ot.main.admin.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ot.main.admin.data.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
