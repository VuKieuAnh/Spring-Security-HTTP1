//package com.example.securityHTTP.service.user;
//
//import com.example.securityHTTP.model.AppUser;
//import com.example.securityHTTP.model.UserPrinciple;
//import com.example.securityHTTP.repo.IAppUserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
////@Service
//public class AppUserService implements IAppUserService, UserDetailsService {
//    @Autowired
//    private IAppUserRepo appUserRepo;
//
//    @Override
//    public Iterable<AppUser> findAll() {
//        return appUserRepo.findAll();
//    }
//
//    @Override
//    public Optional<AppUser> findById(Long id) {
//        return appUserRepo.findById(id);
//    }
//
//    @Override
//    public AppUser save(AppUser appUser) {
//        return appUserRepo.save(appUser);
//    }
//
//    @Override
//    public void remove(Long id) {
//        appUserRepo.deleteById(id);
//    }
//
//    public AppUser findByUsername(String name) {
//        return appUserRepo.findByUsername(name);
//    }
//
//    public UserDetails loadUserByUsername(String username) {
//        return UserPrinciple.build(appUserRepo.findByUsername(username));
//    }
//}
