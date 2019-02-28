package com.sbs.springit.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sbs.springit.domain.User;
import com.sbs.springit.repository.UserRepository;

@Service
public class UserDetailsServiceImpl {
	
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {			
		this.userRepository = userRepository;			
	}
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Optional<User> user = userRepository.findByEmail(email);
		if( !user.isPresent() ) {
			throw new UsernameNotFoundException(email);
		}
		
		return user.get();
	}
}
