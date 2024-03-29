/*
 * package io.github.anantharajuc.sbmwa.security;
 * 
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import io.github.anantharajuc.sbmwa.model.AppUser; import
 * io.github.anantharajuc.sbmwa.repository.UserRepository; import
 * lombok.RequiredArgsConstructor;
 * 
 * @Service
 * 
 * @RequiredArgsConstructor public class MyUserDetails implements
 * UserDetailsService {
 * 
 * private final UserRepository userRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { final AppUser appUser =
 * userRepository.findByUsername(username);
 * 
 * if (appUser == null) { throw new UsernameNotFoundException("User '" +
 * username + "' not found"); }
 * 
 * return org.springframework.security.core.userdetails.User//
 * .withUsername(username)// .password(appUser.getPassword())//
 * .authorities(appUser.getAppUserRoles())// .accountExpired(false)//
 * .accountLocked(false)// .credentialsExpired(false)// .disabled(false)//
 * .build(); }
 * 
 * }
 */