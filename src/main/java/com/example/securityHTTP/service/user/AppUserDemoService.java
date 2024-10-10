//package com.example.securityHTTP.service.user;
//
//import com.example.securityHTTP.model.AppRole;
//import com.example.securityHTTP.model.AppUser;
//import com.example.securityHTTP.model.UserPrinciple;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//@Service
//public class AppUserDemoService implements IAppUserService, UserDetailsService {
//    static List<AppUser> users;
//    static {
//        AppRole appRole = new AppRole();
//        appRole.setId(1L);
//        appRole.setName("ROLE_USER");
//        Set<AppRole> appRoles1 = new HashSet<>();
//        appRoles1.add(appRole);
//
//        AppRole appRole1 = new AppRole();
//        appRole1.setId(2L);
//        appRole1.setName("ROLE_ADMIN");
//        Set<AppRole> appRoles = new HashSet<>();
//        appRoles.add(appRole1);
//        users = new ArrayList<>();
//        users.add(new AppUser(1L, "KA", "1234",appRoles));
//        users.add(new AppUser(2L, "KA1", "1234",appRoles1));
////        users.add(new AppUser(2L, "KA1", "1234",appRoles));
//    }
//
//    @Override
//    public Iterable<AppUser> findAll() {
//        return users;
//    }
//
//    @Override
//    public Optional<AppUser> findById(Long id) {
//        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
//    }
//
//    @Override
//    public AppUser save(AppUser user) {
//        users.add(user);
//        return user;
//    }
//
//    @Override
//    public void remove(Long id) {
//        users.removeIf(user -> user.getId().equals(id));
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<AppUser> user1 = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
//        AppUser user = user1.get();
//        return UserPrinciple.build(user);
//    }
//}
