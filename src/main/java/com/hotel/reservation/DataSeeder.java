package com.hotel.reservation;

import com.hotel.reservation.person.Admin;
import com.hotel.reservation.person.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AdminRepository adminRepository;

    public DataSeeder(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void run(String... args) {
        // Create a default admin if none exists
        if (adminRepository.findByEmail("admin@hotel.com").isEmpty()) {
            Admin admin = new Admin();
            admin.setName("System Admin");
            admin.setEmail("admin@hotel.com");
            admin.setPhone("0700000000");
            admin.setPassword("admin123");
            admin.setPosition("Administrator");
            admin.setSalary(0);
            admin.setAdminLevel(2);  // super admin
            adminRepository.save(admin);
            System.out.println("Default admin created: admin@hotel.com / admin123");
        }
    }
}